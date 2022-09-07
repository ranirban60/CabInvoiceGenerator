package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare(){
        CabInvoiceGenerator fare = new CabInvoiceGenerator();
        Assert.assertEquals(65, fare.calculateFare(5,15), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        CabInvoiceGenerator obj = new CabInvoiceGenerator();
        Ride[] ridesArray = { new Ride(3,10), new Ride(5,17), new Ride(7,20)};
        Assert.assertEquals(197, obj.calculateFareForMultipleRides(ridesArray), 0.000);
    }
}