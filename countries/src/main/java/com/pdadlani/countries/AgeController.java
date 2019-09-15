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

    // localhost:2019/age/age/{age}
    // return the countries that have a median age equal to or greater than the given age
    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesMedianAgeInput(@PathVariable int age) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/age/min
    //return the country with the smallest median age
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryMinMedianAge() {
        Country rtnCountry = CountriesApplication.ourCountryList.findCountryMinMedAge();
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:2019/age/max
    // return the country the the greatest median age
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMaxMedianAge() {
        Country rtnCountry = CountriesApplication.ourCountryList.findCountryMaxMedAge();
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // Stretch Goal
    // localhost:2019/age/median
    // return the country with the median median age
    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryMedMedianAge() {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int)(c1.getMedianAge() - c2.getMedianAge()));
        if (rtnCountries.size() % 2 != 0) {
            return new ResponseEntity<>(rtnCountries.get((int)(rtnCountries.size()/2 + 0.5)), HttpStatus.OK);
        }
        return new ResponseEntity<>(rtnCountries.get(rtnCountries.size()/2), HttpStatus.OK);
    }
}
