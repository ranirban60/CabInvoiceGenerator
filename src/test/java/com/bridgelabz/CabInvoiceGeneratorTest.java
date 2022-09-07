package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator fare;

    @Before
    public  void setUp() throws Exception {
        fare = new CabInvoiceGenerator();
    }

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        CabInvoiceGenerator fare = new CabInvoiceGenerator();
        Assert.assertEquals(65, fare.calculateFare(5,15), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        CabInvoiceGenerator obj = new CabInvoiceGenerator();
        Ride[] ridesArray = { new Ride(3,10), new Ride(5,17), new Ride(7,20)};
        Assert.assertEquals(197, obj.calculateFareForMultipleRides(ridesArray), 0.000);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary() {
       Ride[] rides ={
               new Ride(1,3),
               new Ride(2,5),
               new Ride(3,7)
       };
       InvoiceSummary invoiceSummary = fare.invoiceSummaryCalculation(rides);
       InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,75);
       Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
       }
    }