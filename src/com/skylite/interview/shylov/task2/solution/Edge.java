package com.skylite.interview.shylov.task2.solution;

import java.util.ArrayList;

/**
 * Class describes edge entity
 *
 * @author Artem Shylov
 * @author artem.shylov.1993@gmail.com
 */
public class Edge {

    private ArrayList<City> cities;

    private int value;

    public Edge(City city1, City city2, int value) {
        this.cities = new ArrayList<>();
        this.cities.add(city1);
        this.cities.add(city2);
        this.value = value;
    }

    public Edge(City city1, City city2) {
        this.cities = new ArrayList<>();
        this.cities.add(city1);
        this.cities.add(city2);
        this.value = 0;
    }

    public boolean containsCity(City city) {
        return cities.contains(city);
    }

    public City getOtherCity(City city) {
        City result = cities.get(0);
        if(result.equals(city)){
            result = cities.get(1);
        }
        return result;
    }

    /**
     * Compare edges by cities and value
     *
     * @param obj comparable edge
     * @return equals
     */
    @Override
    public boolean equals(Object obj) {
        Edge secondEdge = (Edge) obj;
        return this.cities.containsAll(((Edge) obj).getCities());
    }

    @Override
    public String toString() {
        return cities.get(0) + " <-" + this.value + "-> " + cities.get(1);
    }

    //  getters and setters

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}