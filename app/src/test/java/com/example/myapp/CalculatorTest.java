package com.example.myapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator calculator; //declaration

    //on create
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator(); //init
    }


    public void testAddition() {
        int expected = 30;
        int actual = calculator.add(10,20);
        assertEquals(expected,actual);
    }

    public  void testMultiplication(){
        int exp = 20;
        int act = calculator.multiply(5,4);
        assertEquals(exp,act);
    }


    //on destroy
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
