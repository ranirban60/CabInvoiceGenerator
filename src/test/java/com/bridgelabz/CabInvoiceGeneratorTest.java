package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator fare;

    @Before
    public void setUp() throws Exception {
        fare = new CabInvoiceGenerator();
    }

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        CabInvoiceGenerator fare = new CabInvoiceGenerator();
        Assert.assertEquals(65, fare.calculateFare(5, 15), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        CabInvoiceGenerator obj = new CabInvoiceGenerator();
        Ride[] ridesArray = {new Ride("1", 3, 10), new Ride("2", 5, 17), new Ride("3", 7, 20)};
        Assert.assertEquals(197, obj.calculateFareForMultipleRides(ridesArray), 0.000);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride("1", 1, 3),
                new Ride("2", 2, 5),
                new Ride("3", 3, 7)
        };
        InvoiceSummary invoiceSummary = fare.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 75);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdDistanceAndTimeShouldReturnInvoiceOfUser(){
        Ride[] rides = {
                new Ride("1", 2, 5),
                new Ride("2", 3, 7),
                new Ride("1", 5, 10)
        };
        InvoiceSummary invoiceSummary = fare.listOfRidesOfUniqueUserId(rides,"1");
        InvoiceSummary invoiceSummary2 = fare.listOfRidesOfUniqueUserId(rides,"2");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 85);
        InvoiceSummary expectedInvoiceSummary2 = new InvoiceSummary(1, 37);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
        Assert.assertEquals(expectedInvoiceSummary2,invoiceSummary2);
    }

}