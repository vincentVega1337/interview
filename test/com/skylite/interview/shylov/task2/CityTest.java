package com.skylite.interview.shylov.task2;

import com.skylite.interview.shylov.task2.solution.City;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    @Test
    public void equals() {
        City city = new City("Kharkov");
        assertEquals(city, new City("Kharkov"));
    }
}