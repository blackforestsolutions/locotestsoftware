package de.blackforestsolutions.locotestsoftware.util.objectmothers;

import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

@Slf4j
public class ApiTokenAndUrlInformationObjectMother {

    public static ApiTokenAndUrlInformation getDbTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("München Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getMunichHbfCoordinates());
        builder.setArrival("Rendsburg");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getRendsburgCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getDbTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getDbTokenAndUrl());
        builder.setDeparture("Rendsburg");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getRendsburgCoordinates());
        builder.setArrival("München Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getMunichHbfCoordinates());
        return builder.build();
    }


    public static ApiTokenAndUrlInformation getHvvTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("Hamburg Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getHamburgHbfCoordinates());
        builder.setArrival("Hamburg Flughafen");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getHamburgAirportCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getHvvTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getHvvTokenAndUrl());
        builder.setDeparture("Hamburg Flughafen");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getHamburgAirportCoordinates());
        builder.setArrival("Hamburg Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getHamburgHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getNahShTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("Kiel Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getKielHbfCoordinates());
        builder.setArrival("Rendsburg");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getRendsburgCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getNahShTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getNahShTokenAndUrl());
        builder.setDeparture("Rendsburg");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getRendsburgCoordinates());
        builder.setArrival("Kiel Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getKielHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getVbbTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("Berlin Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getBerlinHbfCoordinates());
        builder.setArrival("Potsdam Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getPotsdamHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getVbbTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getVbbTokenAndUrl());
        builder.setDeparture("Potsdam Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getPotsdamHbfCoordinates());
        builder.setArrival("Berlin Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getBerlinHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getLufthansaTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("ZRH");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getZurichAirportCoordinates());
        builder.setArrival("FRA");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getFrankfurtAirportCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getLufthansaTokenAndUrlReverse() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getLufthansaTokenAndUrl());
        builder.setDeparture("FRA");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getFrankfurtAirportCoordinates());
        builder.setArrival("ZRH");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getZurichAirportCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBritishAirwaysTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("lhr");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getLondonHeathrowCoordinates());
        builder.setArrival("txl");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getBerlinAirportCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBritishAirwaysTokenAndUrlReverse() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getBritishAirwaysTokenAndUrl());
        builder.setDeparture("txl");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getBerlinAirportCoordinates());
        builder.setArrival("lhr");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getLondonHeathrowCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBbcTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("Hamburg");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getHamburgHbfCoordinates());
        builder.setArrival("Berlin");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getBerlinHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBbcTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getBbcTokenAndUrl());
        builder.setDeparture("Berlin");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getBerlinHbfCoordinates());
        builder.setArrival("Hamburg");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getHamburgHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getRmvTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setArrival("Offenbach Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getOffenbachHbfCoordinates());
        builder.setDeparture("Frankfurt Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getFrankfurtHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getRmvTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getRmvTokenAndUrl());
        builder.setDeparture("Frankfurt Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getFrankfurtHbfCoordinates());
        builder.setArrival("Offenbach Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getOffenbachHbfCoordinates());
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getApiTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setDeparture("Berlin Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getBerlinHbfCoordinates());
        builder.setArrival("München Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getMunichHbfCoordinates());
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getApiTokenAndUrlReverse() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder(getApiTokenAndUrl());
        builder.setDeparture("München Hbf");
        builder.setDepartureCoordinates(CoordinatesObjectMother.getMunichHbfCoordinates());
        builder.setArrival("Berlin Hbf");
        builder.setArrivalCoordinates(CoordinatesObjectMother.getBerlinHbfCoordinates());
        return builder.build();
    }
}
