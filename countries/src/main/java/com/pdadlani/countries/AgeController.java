package com.pdadlani.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {
    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByMedianAgeGreaterThanInput(@PathVariable int age) {
        ArrayList<Country> rtnCts = CountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCts, HttpStatus.OK);
    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryMinMedianAge() {
        ArrayList<Country> allCts = CountriesApplication.ourCountryList.countryList;
        allCts.sort((c1, c2) -> (int) (c1.getMedianAge() - c2.getMedianAge()));
        return new ResponseEntity<>(allCts.get(0) , HttpStatus.OK);
    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMaxMedianAge() {
        ArrayList<Country> allCts = CountriesApplication.ourCountryList.countryList;
        allCts.sort((c1, c2) -> (int) (c2.getMedianAge() - c1.getMedianAge()));
        return new ResponseEntity<>(allCts.get(0) , HttpStatus.OK);
    }

    @GetMapping(value="/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryMedianMedianAge() {
        ArrayList<Country> allCts = CountriesApplication.ourCountryList.countryList;
        allCts.sort((c1, c2) -> (int) (c1.getMedianAge() - c2.getMedianAge()));
        if (allCts.size() % 2 != 0) {
            return new ResponseEntity<>(allCts.get((int) (allCts.size()/2 + 0.5)), HttpStatus.OK);
        }
        return new ResponseEntity<>(allCts.get(allCts.size()/2) , HttpStatus.OK);
    }
}
