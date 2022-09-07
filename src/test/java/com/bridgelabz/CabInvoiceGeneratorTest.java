package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare(){
        CabInvoiceGenerator fare = new CabInvoiceGenerator();
        Assert.assertEquals(65, fare.calculateFare(5,15), 0.000);
    }
}