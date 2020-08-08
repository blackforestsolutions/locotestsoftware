package de.blackforestsolutions.locotestsoftware.util.objectmothers;

import de.blackforestsolutions.datamodel.Coordinates;

public class CoordinatesObjectMother {

    public static Coordinates getFrankfurtHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(50.106474d)
                .setLongitude(8.662044d)
                .build();
    }

    public static Coordinates getOffenbachHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(8.760724d)
                .setLongitude(50.099497d)
                .build();
    }

    public static Coordinates getHamburgHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(53.553104d)
                .setLongitude(10.005362d)
                .build();
    }

    public static Coordinates getBerlinHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(52.525182d)
                .setLongitude(13.369158d)
                .build();
    }

    public static Coordinates getMunichHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(48.140185d)
                .setLongitude(11.560706d)
                .build();
    }

    public static Coordinates getLondonHeathrowCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(51.471249d)
                .setLongitude(-0.458878d)
                .build();
    }

    public static Coordinates getBerlinAirportCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(52.558154d)
                .setLongitude(13.288774d)
                .build();
    }

    public static Coordinates getFrankfurtAirportCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(50.045574d)
                .setLongitude(8.553178d)
                .build();
    }

    public static Coordinates getZurichAirportCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(47.452268d)
                .setLongitude(8.559991d)
                .build();
    }

    public static Coordinates getPotsdamHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(52.391679d)
                .setLongitude(13.066773d)
                .build();
    }

    public static Coordinates getKielHbfCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(54.315415d)
                .setLongitude(10.132096d)
                .build();
    }

    public static Coordinates getRendsburgCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(54.302570d)
                .setLongitude(9.669926d)
                .build();
    }

    public static Coordinates getHamburgAirportCoordinates() {
        return new Coordinates.CoordinatesBuilder()
                .setLatitude(53.631895d)
                .setLongitude(10.001780d)
                .build();
    }
}
