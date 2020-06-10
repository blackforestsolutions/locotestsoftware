package de.blackforestsolutions.locotestsoftware.util.objectmothers;

import de.blackforestsolutions.datamodel.Coordinates;

public class CoordinatesObjectMother {

    public static Coordinates.CoordinatesBuilder getCoordinatesWithNoEmptyFields() {
        return new Coordinates.CoordinatesBuilder(0, 0);
    }
}
