package com.pdadlani.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {

    // localhost:2019/population/size/{people}
    // return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationInput(@PathVariable long people) {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/population/min
    // return the country with the smallest population
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryMinPop() {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    // localhost:2019/population/max
    // return the country with the largest population
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMaxPop() {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    // Stretch Goal
    // localhost:2019/population/median
    // return the country with the median population
    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryMedianPop() {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        if (rtnCountries.size() % 2 != 0) {
            return new ResponseEntity<>(rtnCountries.get((int)(rtnCountries.size()/2 + 0.5)), HttpStatus.OK);

        }
        return new ResponseEntity<>(rtnCountries.get(rtnCountries.size()/2), HttpStatus.OK);
    }
}
