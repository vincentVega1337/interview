package com.skylite.interview.shylov.task3;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void bigFactorial() {
        assertEquals(Task3.bigFactorial(new BigInteger("5")), new BigInteger("120"));
    }

    @Test
    public void numberCounter() {
        assertEquals(Task3.numberCounter(Task3.bigFactorial(new BigInteger("100")).toString()), 648);
    }
}