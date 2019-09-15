package com.pdadlani.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    // fields

    // use atomic counter for id
    // static - it is shared across all employee objects
    // final - we do not want it to change; but do not want object to change; data inside can
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private long landMassSize;
    private int medianAge;

    // constructor
    public Country(String name, long population, long landMassSize, int medianAge) {
        // to use the atomic counter
        // call it, and then incrementAndGet() to make sure
        // each object has its own value
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    // getters and setters
    // do not need a setter for id; it is already set w/ AtomicLong counter
    public long getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", landMassSize=" + landMassSize + ", medianAge=" + medianAge + '}';
    }
}
