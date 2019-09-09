package com.pdadlani.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

    public static CountryList ourCountryList;

    public static void main(String[] args) {
        ourCountryList = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
