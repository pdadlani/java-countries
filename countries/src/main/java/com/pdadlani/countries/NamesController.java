package com.pdadlani.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController {
    @GetMapping(value = "/all",
            produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesAlpha() {
        ArrayList<Country> rtnCts = CountriesApplication.ourCountryList.countryList;
        rtnCts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCts, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetterAlpha(
            @PathVariable
                    char letter) {
        ArrayList<Country> rtnCts = CountriesApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCts, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLengthAlpha(
            @PathVariable
                    int number) {
        ArrayList<Country> rtnCts = CountriesApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
        rtnCts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCts, HttpStatus.OK);
    }

}
