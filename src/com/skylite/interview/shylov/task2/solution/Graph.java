package com.skylite.interview.shylov.task2.solution;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Graph entity
 * Contains arrayLists of cities and edges
 * Can calculate destination between 2 cities by inner class DijkstraUnit
 *
 * @author Artem Shylov
 * @author artem.shylov.1993@gmail.com
 */
public class Graph {

    private ArrayList<City> cities;

    private ArrayList<Edge> edges;

    private DijkstraUnit dijkstraUnit;

    public Graph(ArrayList<City> cities, ArrayList<Edge> edges) {
        this.cities = new ArrayList<>();
        this.edges = new ArrayList<>();

        this.addAllCities(cities);
        this.addAllEdges(edges);

        dijkstraUnit = new DijkstraUnit(this.cities, this.edges);
    }

    public void addCity(City city) {
        if (!this.containsCity(city)) {
            this.cities.add(city);
        }
    }

    public void addAllCities(ArrayList<City> cities) {
        for (City city : cities) {
            if (!containsCity(city)) {
                this.addCity(city);
            }
        }
    }

    public void addEdge(Edge edge) {
        if (!this.containsEdge(edge)) {
            this.edges.add(edge);
        }
    }

    public void addAllEdges(ArrayList<Edge> edges) {
        for (Edge edge : edges) {
            if (!containsEdge(edge)) {
                this.addEdge(edge);
            }
        }
    }

    public boolean containsCity(City city) {
        return this.cities.contains(city);
    }

    public boolean containsEdge(Edge edge) {
        return this.edges.contains(edge);
    }

    public int calculateMinimalPath(String initString) {
        String[] cities = initString.split("\\s");
        return this.dijkstraUnit.calculate(cities[0], cities[1]);
    }

    @Override
    public String toString() {
        return "cities=" + cities + "\n" + "edges=" + edges;
    }

    //getters and setters

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Inner class, calculate path from initial to destination and all other cities by Dijkstra algorithm
     *
     *
     * @author Artem Shylov
     * @author artem.shylov.1993@gmail.com
     */
    class DijkstraUnit {

        private ArrayList<City> cities;
        private ArrayList<Edge> edges;
        private ArrayList<Edge> currentEdgesPool;
        private HashMap<City, Integer> resultTable;

        public DijkstraUnit(ArrayList<City> cities, ArrayList<Edge> edges) {
            this.cities = cities;
            this.edges = edges;
            currentEdgesPool = new ArrayList<>();
            resultTable = initResultTable();
        }

        private HashMap<City, Integer> initResultTable() {
            HashMap<City, Integer> result = new HashMap<>();
            for (City city : cities) {
                result.put(city, Integer.MAX_VALUE);
            }
            return result;
        }

        /**
         * Main method of class, realize Dijkstra algorithm
         *
         * @param initCity source
         * @param destination destination
         * @return int value of path length
         */
        public int calculate(String initCity, String destination) {
            City initialCity = cities.get(cities.lastIndexOf(new City(initCity)));  // get init city from cities
            City destinationCity = cities.get(cities.lastIndexOf(new City(destination)));   // get destination city from cities
            resultTable.put(initialCity, 0);    //set destination do init city to 0
            addCityToPool(initialCity); //add init city to pool
            while (!currentEdgesPool.isEmpty()) {
                City nextCity = findMinimalPath();
                if (nextCity == null) {
                    break;
                }
                addCityToPool(nextCity);
                updateTable();
            }   //get all new cities

            int result = resultTable.get(destinationCity);
            reset();    //reset tables to init state
            return result;
        }

        private City findMinimalPath() {
            Edge minimalPath = new Edge(null, null, Integer.MAX_VALUE);
            City result = null;
            for (City city : cities) {
                if (city.getCityStatus() == CityStatus.KNOWN) {
                    for (Edge edge : currentEdgesPool) {
                        if (edge.containsCity(city)) {
                            int pathLength = resultTable.get(edge.getOtherCity(city)) + edge.getValue();
                            if (pathLength <= minimalPath.getValue()) {
                                minimalPath = edge;
                                result = city;
                            }
                        }
                    }
                }
            }
            return result;
        }

        private void addCityToPool(City necessaryCity) {
            necessaryCity.setCityStatus(CityStatus.VISITED); // change status of target city
            for (Edge edge : edges) {
                if (edge.containsCity(necessaryCity)) {
                    currentEdgesPool.add(edge);
                }
            }   //add all edges with necessary city
            City otherCity;
            for (Edge edge : currentEdgesPool) {
                otherCity = edge.getOtherCity(necessaryCity);
                if (otherCity.getCityStatus() == CityStatus.UNKNOWN) {
                    otherCity.setCityStatus(CityStatus.KNOWN);
                }
            }   //change statuses of new KNOWN city
            updateTable(); //update result table
        }

        private void updateTable() {
            for (City city : cities) {
                if (city.getCityStatus() == CityStatus.KNOWN) {
                    for (Edge edge : currentEdgesPool) {
                        if (edge.containsCity(city)) {
                            int destination = edge.getValue() + resultTable.get(edge.getOtherCity(city));
                            if (destination < resultTable.get(city)) {
                                resultTable.put(city, destination);
                            }
                        }
                    }
                }
            }
        }

        private void reset() {
            for (City city : cities) {
                city.setCityStatus(CityStatus.UNKNOWN);
            }
            resultTable = initResultTable();
            currentEdgesPool = new ArrayList<>();
        }

    }
}