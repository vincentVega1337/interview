package com.skylite.interview.shylov.task2;

import com.skylite.interview.shylov.task2.solution.City;
import com.skylite.interview.shylov.task2.solution.Edge;
import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {

    @Test
    public void containsCity() {
        Edge edge1 = new Edge(new City("Kharkov"), new City("Kiev"));
        assertTrue(edge1.containsCity(new City("Kharkov")));
    }

    @Test
    public void equals() {
        Edge edge1 = new Edge(new City("Kharkov"), new City("Kiev"));
        Edge edge2 = new Edge(new City("Kiev"), new City("Kharkov"));
        assertEquals(edge1, edge2);
    }
}