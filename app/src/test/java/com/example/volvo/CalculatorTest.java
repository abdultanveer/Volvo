package com.example.volvo;

import junit.framework.TestCase;


public class CalculatorTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //init resources
    }

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        //release resources
    }
}