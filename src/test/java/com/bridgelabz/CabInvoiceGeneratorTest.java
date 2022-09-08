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
        Assert.assertEquals(65, fare.calculateFare(5, 15, CabInvoiceGenerator.RideType.NORMAL_RIDE), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        Ride[] ridesArray = {new Ride("1", 3, 10, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("2", 5, 17, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("3", 7, 20, CabInvoiceGenerator.RideType.NORMAL_RIDE)};
        Assert.assertEquals(197, fare.calculateFareForMultipleRides(ridesArray), 0.000);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride("1", 1, 3, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("2", 2, 5, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("3", 3, 7, CabInvoiceGenerator.RideType.NORMAL_RIDE)
        };
        InvoiceSummary invoiceSummary = fare.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 75);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdDistanceAndTimeShouldReturnInvoiceOfUser(){
        Ride[] rides = {
                new Ride("1", 2, 5, CabInvoiceGenerator.RideType.PREMIUM_RIDE),
                new Ride("2", 3, 7, CabInvoiceGenerator.RideType.PREMIUM_RIDE),
                new Ride("1", 5, 10, CabInvoiceGenerator.RideType.PREMIUM_RIDE)
        };
        InvoiceSummary invoiceSummary = fare.listOfRidesOfUniqueUserId(rides,"1");
        InvoiceSummary invoiceSummary2 = fare.listOfRidesOfUniqueUserId(rides,"2");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 135);
        InvoiceSummary expectedInvoiceSummary2 = new InvoiceSummary(1, 59);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
        Assert.assertEquals(expectedInvoiceSummary2,invoiceSummary2);
    }

}