package com.skylite.interview.shylov.task2;

import com.skylite.interview.shylov.task2.solution.City;
import com.skylite.interview.shylov.task2.solution.Edge;
import com.skylite.interview.shylov.task2.solution.Graph;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void addCity() {
        City city1 = new City("Kharkov");
        City city2 = new City("Kiev");

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(city1, city2));
        Graph graph = new Graph(cities, edges);
        graph.addCity(new City("Odessa"));

        ArrayList<City> cities2 = new ArrayList<>();
        cities2.add(city1);
        cities2.add(city2);
        cities2.add(new City("Odessa"));

        assertEquals(graph.getCities(), cities2);
    }

    @Test
    public void containsCity() {
        City city1 = new City("Kharkov");
        City city2 = new City("Kiev");

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(city1, city2));
        Graph graph = new Graph(cities, edges);
        graph.addCity(new City("Odessa"));
        assertTrue(graph.containsCity(new City("Odessa")));
    }

    @Test
    public void addEdge() {
        City city1 = new City("Kharkov");
        City city2 = new City("Kiev");

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(city1, city2));
        Graph graph = new Graph(cities, edges);

        graph.addEdge(new Edge(city1, new City("Odessa")));

        ArrayList<Edge> edges2 = new ArrayList<>();
        edges2.add(new Edge(city1, city2, 111));
        edges2.add(new Edge(city1, new City("Odessa")));
        assertEquals(graph.getEdges(), edges2);
    }

    @Test
    public void containsEdge() {
        City city1 = new City("Kharkov");
        City city2 = new City("Kiev");

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(city1, city2));
        Graph graph = new Graph(cities, edges);
        assertTrue(graph.containsEdge(new Edge(city1, city2)));
    }
}