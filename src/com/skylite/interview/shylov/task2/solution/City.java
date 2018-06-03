package com.skylite.interview.shylov.task2.solution;

/**
 * Class describes city entity
 *
 * @author Artem Shylov
 * @author artem.shylov.1993@gmail.com
 */
public class City {

    private String name;

    private CityStatus cityStatus;

    public City(String name) {
        this.name = name;
        this.cityStatus = CityStatus.UNKNOWN;
    }

    /**
     * Compare  cities by name
     *
     * @param obj city to compare
     * @return equals
     */
    @Override
    public boolean equals(Object obj) {
        City second = (City) obj;
        return this.getName().equals(((City) obj).getName());
    }

    @Override
    public String toString() {
        return this.name;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityStatus getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(CityStatus cityStatus) {
        this.cityStatus = cityStatus;
    }
}