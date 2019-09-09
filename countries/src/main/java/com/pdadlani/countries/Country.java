package com.pdadlani.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private long landMassSize;
    private int medianAge;

    public Country(String name, long population, long landMassSize, int medianAge) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public Country(Country toClone) {
        this.id = toClone.id;
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMassSize = toClone.getLandMassSize();
        this.medianAge = toClone.getMedianAge();
    }

    // getters and setters
    // write out the id
    public long getId() {
        return id;
    }

    // generate the rest
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(long landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    // generate a toString by convention

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", landMassSize=" + landMassSize + ", medianAge=" + medianAge + '}';
    }
}
