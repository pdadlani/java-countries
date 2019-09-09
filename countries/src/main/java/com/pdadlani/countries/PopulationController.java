package com.pdadlani.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/population")
public class PopulationController {
    @GetMapping(value="/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationInput(@PathVariable long people) {
        ArrayList<Country> rtnCts = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCts, HttpStatus.OK);
    }

    @GetMapping(value="/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopCountry() {
        ArrayList<Country> allCts = CountriesApplication.ourCountryList.countryList;
        allCts.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
//        Collections.max(allCts.getPopulation());
        return new ResponseEntity<>(allCts.get(0) , HttpStatus.OK);
    }

    @GetMapping(value="/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopCountry() {
        ArrayList<Country> allCts = CountriesApplication.ourCountryList.countryList;
        allCts.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(allCts.get(0) , HttpStatus.OK);
    }

    @GetMapping(value="/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianPopCountry() {
        ArrayList<Country> allCts = CountriesApplication.ourCountryList.countryList;
        allCts.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        if (allCts.size() % 2 != 0) {
            return new ResponseEntity<>(allCts.get((int) (allCts.size()/2 + 0.5)), HttpStatus.OK);
        }
        return new ResponseEntity<>(allCts.get(allCts.size()/2) , HttpStatus.OK);
    }
}
