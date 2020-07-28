package de.blackforestsolutions.locotestsoftware.util.objectmothers;

import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.Coordinates;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

@Slf4j
public class ApiTokenAndUrlInformationObjectMother {

    private static ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder getHafasStandardTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setLanguage("de");
        builder.setResultLength(1);
        builder.setLocationPath("LocMatch");
        builder.setJourneyPathVariable("TripSearch");
        builder.setApiVersion("1.16");
        builder.setPathVariable("bin/mgate.exe?");
        builder.setAllowIntermediateStops(true);
        builder.setTransfers(-1);
        builder.setMinTransferTime(0);
        builder.setForDisabledPersons("notBarrierfree");
        builder.setAllowTariffDetails(true);
        builder.setAllowCoordinates(false);
        return builder;
    }

    public static ApiTokenAndUrlInformation getSearchChTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("fahrplan.search.ch");
        builder.setPathVariable("api");
        builder.setLocationPath("completion.json");
        builder.setJourneyPathVariable("route.json");
        builder.setSearchChTermParameter("term");
        builder.setLocationSearchTerm("lu");
        builder.setSearchChStationId("show_ids=1");
        builder.setSearchChStationCoordinateParameter("show_coordinates=1");
        builder.setDatePathVariable("date");
        builder.setDeparture("8503283");
        builder.setArrival("Zürich,+Förrlibuckstr.+60");
        builder.setTimePathVariable("time");
        builder.setSearchChDelayParameter("show_delays=1");
        builder.setSearchChResults("num=1");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getSearchChReverseTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("fahrplan.search.ch");
        builder.setPathVariable("api");
        builder.setLocationPath("completion.json");
        builder.setJourneyPathVariable("route.json");
        builder.setSearchChTermParameter("term");
        builder.setLocationSearchTerm("lu");
        builder.setSearchChStationId("show_ids=1");
        builder.setSearchChStationCoordinateParameter("show_coordinates=1");
        builder.setDatePathVariable("date");
        builder.setDeparture("8503283");
        builder.setArrival("Zürich,+Förrlibuckstr.+60");
        builder.setTimePathVariable("time");
        builder.setSearchChDelayParameter("show_delays=1");
        builder.setSearchChResults("num=1");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBahnTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setDeparture("Berlin");
        builder.setArrival("Frankfurt");
        builder.setJourneyDetailsId("detailsId");
        builder.setProtocol("https");
        builder.setHost("api.deutschebahn.com");
        builder.setApiVersion("v1");
        builder.setPathVariable("fahrplan-plus");
        builder.setGermanRailLocationPath("location");
        builder.setGermanRailArrivalBoardPath("arrivalBoard");
        builder.setStationId("8011160");
        builder.setGermanRailDatePathVariable(ZonedDateTime.now());
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setGermanRailDepartureBoardPath("departureBoard");
        builder.setStationId("8011160");
        builder.setLocationPath("location");
        builder.setGermanRailJourneyDeatilsPath("journeyDetails");
        builder.setJourneyDetailsId("715770%2F254084%2F898562%2F210691%2F80%3fstation_evaId%3D8000312");
        builder.setAuthorizationKey("Authorization");
        builder.setAuthorization("Bearer 4d3c7b35a42c7ecadeb41b905e0007f8");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBahnTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setArrival("Berlin");
        builder.setDeparture("Frankfurt");
        builder.setJourneyDetailsId("detailsId");
        builder.setProtocol("https");
        builder.setHost("api.deutschebahn.com");
        builder.setApiVersion("v1");
        builder.setPathVariable("fahrplan-plus");
        builder.setGermanRailLocationPath("location");
        builder.setGermanRailArrivalBoardPath("arrivalBoard");
        builder.setStationId("8011160");
        builder.setGermanRailDatePathVariable(ZonedDateTime.now());
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setGermanRailDepartureBoardPath("departureBoard");
        builder.setStationId("8011160");
        builder.setLocationPath("location");
        builder.setGermanRailJourneyDeatilsPath("journeyDetails");
        builder.setJourneyDetailsId("715770%2F254084%2F898562%2F210691%2F80%3fstation_evaId%3D8000312");
        builder.setAuthorizationKey("Authorization");
        builder.setAuthorization("Bearer 4d3c7b35a42c7ecadeb41b905e0007f8");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getLufthansaTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("api.lufthansa.com");
        builder.setApiVersion("v1");
        builder.setPathVariable("oauth/token");
        builder.setJourneyPathVariable("operations/schedules");
        builder.setDeparture("ZRH");
        builder.setArrival("FRA");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setXOriginationIp("88.66.47.47");
        builder.setXOriginationIpKey("X-Originating-IP");
        builder.setClientId("v6tqqk92k2a6zzaharpz56x6");
        builder.setClientSecret("c9kUKEuT3k");
        builder.setClientType("client_credentials");
        builder.setAuthorization("fhfdds7fskppmt6xn2z423a9");
        builder.setPath("/v1/operations/schedules/ZRH/FRA/2019-12-28");
        builder.setAuthorizationKey("Authorization");
        builder.setXOriginationIp("88.66.47.47");
        builder.setXOriginationIpKey("X-Originating-IP");
        builder.setAuthorization("Bearer guuryzmgpftrnum76twe3y7k");
        builder.setPath("/v1/operations/schedules/ZRH/FRA/2019-12-28");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getLufthansaTokenAndUrlReverse() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("api.lufthansa.com");
        builder.setApiVersion("v1");
        builder.setPathVariable("oauth/token");
        builder.setJourneyPathVariable("operations/schedules");
        builder.setArrival("ZRH");
        builder.setDeparture("FRA");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setXOriginationIp("88.66.47.47");
        builder.setXOriginationIpKey("X-Originating-IP");
        builder.setClientId("v6tqqk92k2a6zzaharpz56x6");
        builder.setClientSecret("c9kUKEuT3k");
        builder.setClientType("client_credentials");
        builder.setAuthorization("fhfdds7fskppmt6xn2z423a9");
        builder.setPath("/v1/operations/schedules/ZRH/FRA/2019-12-28");
        builder.setAuthorizationKey("Authorization");
        builder.setXOriginationIp("88.66.47.47");
        builder.setXOriginationIpKey("X-Originating-IP");
        builder.setAuthorization("Bearer guuryzmgpftrnum76twe3y7k");
        builder.setPath("/v1/operations/schedules/ZRH/FRA/2019-12-28");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBritishAirwaysTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("api.ba.com");
        builder.setApiVersion("rest-v1/v1");
        builder.setPathVariable("flights");
        builder.setDeparture("lhr");
        builder.setArrival("txl");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setAuthorizationKey("client-key");
        builder.setAuthorization("64x9epryst4b4g2aaks4b3yn");
        builder.setPath("/rest-v1/v1/flights;departureLocation=lhr;arrivalLocation=txl;scheduledDepartureDate=2020-10-20");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBritishAirwaysTokenAndUrlReverse() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("api.ba.com");
        builder.setApiVersion("rest-v1/v1");
        builder.setPathVariable("flights");
        builder.setDeparture("txl");
        builder.setArrival("lhr");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setAuthorizationKey("client-key");
        builder.setAuthorization("64x9epryst4b4g2aaks4b3yn");
        builder.setPath("/rest-v1/v1/flights;departureLocation=lhr;arrivalLocation=txl;scheduledDepartureDate=2020-10-20");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBbcTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("public-api.blablacar.com");
        builder.setApiVersion("api/v2");
        builder.setPathVariable("trips?");
        builder.setDeparture("ZRH");
        builder.setArrival("FRA");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setAuthorizationKey("key");
        builder.setXOriginationIp("88.66.47.47");
        builder.setXOriginationIpKey("X-Originating-IP");
        builder.setAuthorization("7f529ec36ab542b78e63f5270a621837");
        builder.setPath("/api/v2/trips?fn=ZRH&tn=FRA&db=2019-10-20\"");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBbcTokenAndUrlReversed() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("public-api.blablacar.com");
        builder.setApiVersion("api/v2");
        builder.setPathVariable("trips?");
        builder.setArrival("ZRH");
        builder.setDeparture("FRA");
        builder.setDepartureDate(ZonedDateTime.now());
        builder.setArrivalDate(ZonedDateTime.now().plusSeconds(99999));
        builder.setAuthorizationKey("key");
        builder.setXOriginationIp("88.66.47.47");
        builder.setXOriginationIpKey("X-Originating-IP");
        builder.setAuthorization("7f529ec36ab542b78e63f5270a621837");
        builder.setPath("/api/v2/trips?fn=ZRH&tn=FRA&db=2019-10-20\"");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getAirportsFinderTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("cometari-airportsfinder-v1.p.rapidapi.com");
        builder.setPathVariable("api/airports/by-radius");
        builder.setDepartureCoordinates(new Coordinates.CoordinatesBuilder(48.1301564, 8.2324351).build());
        builder.setAuthorizationKey("x-rapidapi-key");
        builder.setAuthorization("b441403e78mshfe074d6ec0c2af2p1be89cjsn04932ccb889e");
        builder.setPath("/api/airports/by-radius;radius=300;lng=8.2324351;lat=48.1301564");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getApiTokenAndUrlInformation() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setApiName("testApi");
        builder.setProtocol("http");
        builder.setHost("testHost");
        builder.setPort(8089);
        builder.setApiVersion("V1");
        builder.setPathVariable("/testPathVariable/");
        builder.setDeparture("Berlin");
        builder.setArrival("Frankfurt");
        builder.setDepartureDate(null);
        builder.setArrivalDate(null);
        builder.setXOriginationIpKey("testKey");
        builder.setXOriginationIp("testIp");
        builder.setAuthorizationKey("testAuthKey");
        builder.setAuthorization("testAuth");
        builder.setPath("/testPath/");
        builder.setHazelcastPath("/hazelcastPath/");
        builder.setHazelcastWritePath("/hazelCastWritePath/");
        builder.setHazelcastReadAllPath("/hazelcastReadPath/");
        builder.setHazelcastSearchPath("/hazelcastSearchPath/");
        builder.setGermanRailJourneyDeatilsPath("/germanRailDetailsPath/");
        builder.setGermanRailDepartureBoardPath("/departureBoard");
        builder.setGermanRailArrivalBoardPath("arrivalBoard");
        builder.setGermanRailLocationPath("locationPath");
        builder.setGermanRailDatePathVariable(null);
        builder.setStationId("testStationId");
        builder.setJourneyDetailsId("testJourneyDetailsId");
        builder.setBahnLocation("testBahnLocation");
        builder.setDatePathVariable("dataPathVariable");
        builder.setSearchChRoutePathVariable("SearchChRoutePathVariable");
        builder.setSearchChResults("setSearchChResults");
        builder.setSearchChDelayParameter("setSearchChDelayParameter");
        builder.setTimePathVariable("setTimePathVariable");
        builder.setStartLocation("setStartLocation");
        builder.setDestinationLocation("setDestinationLocation");
        builder.setLocationPath("setLocationPath");
        builder.setSearchChTermParameter("setSearchChTermParameter");
        builder.setSearchChStationId("setSearchChStationId");
        builder.setSearchChStationCoordinateParameter("setSearchChStationCoordinateParameter");
        builder.setLocationSearchTerm("setLocationSearchTerm");
        builder.setLanguage("setLanguage");
        builder.setAuthentificationUser("setAuthentificationUser");
        builder.setAuthentificationType("setAuthentificationPassword");
        builder.setAuthentificationPassword("");
        builder.setStationListPathVariable("setStationListPathVariable");
        builder.setJourneyPathVariable("setJourneyPathVariable");
        builder.setTravelPointPathVariable("setTravelPointPathVariable");
        builder.setResultLength(888);
        builder.setDistanceFromTravelPoint(999);
        builder.setResultLengthBeforeDepartureTime(1111);
        builder.setResultLengthAfterDepartureTime(2222);
        builder.setTariff("setTariff");
        builder.setTimeIsDeparture(false);
        builder.setHvvFilterEquivalent(false);
        builder.setHvvAllowTypeSwitch(false);
        builder.setAllowTariffDetails(false);
        builder.setAllowReducedPrice(false);
        builder.setAllowIntermediateStops(false);
        builder.setHvvReturnContSearchData(false);
        builder.setMic("setMic");
        builder.setChecksum("setChecksum");
        builder.setMac("setMac");
        builder.setHafasRtMode("setHafasRtMode");
        builder.setClientId("setClientId");
        builder.setClientSecret("setClientSecret");
        builder.setClientVersion("setClientVersion");
        builder.setClientName("setClientName");
        builder.setClientType("setClientType");
        builder.setTransfers(6);
        builder.setMinTransferTime(777);
        builder.setHafasProductionValue("setHafasProductionValue");
        builder.setForDisabledPersons("setForDisabledPersons");
        builder.setWalkingSpeed("setWalkingSpeed");
        builder.setAllowCoordinates(false);
        builder.setDepartureCoordinates(CoordinatesObjectMother.getCoordinatesWithNoEmptyFields().build());
        builder.setArrivalCoordinates(CoordinatesObjectMother.getCoordinatesWithNoEmptyFields().build());
        builder.setOutputFormat("setOutputFormat");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getApiTokenAndUrlInformationReverse() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setApiName("testApi");
        builder.setProtocol("http");
        builder.setHost("testHost");
        builder.setPort(8089);
        builder.setApiVersion("V1");
        builder.setPathVariable("/testPathVariable/");
        builder.setArrival("Berlin");
        builder.setDeparture("Frankfurt");
        builder.setDepartureDate(null);
        builder.setArrivalDate(null);
        builder.setXOriginationIpKey("testKey");
        builder.setXOriginationIp("testIp");
        builder.setAuthorizationKey("testAuthKey");
        builder.setAuthorization("testAuth");
        builder.setPath("/testPath/");
        builder.setHazelcastPath("/hazelcastPath/");
        builder.setHazelcastWritePath("/hazelCastWritePath/");
        builder.setHazelcastReadAllPath("/hazelcastReadPath/");
        builder.setHazelcastSearchPath("/hazelcastSearchPath/");
        builder.setGermanRailJourneyDeatilsPath("/germanRailDetailsPath/");
        builder.setGermanRailDepartureBoardPath("/departureBoard");
        builder.setGermanRailArrivalBoardPath("arrivalBoard");
        builder.setGermanRailLocationPath("locationPath");
        builder.setGermanRailDatePathVariable(null);
        builder.setStationId("testStationId");
        builder.setJourneyDetailsId("testJourneyDetailsId");
        builder.setBahnLocation("testBahnLocation");
        builder.setDatePathVariable("dataPathVariable");
        builder.setSearchChRoutePathVariable("SearchChRoutePathVariable");
        builder.setSearchChResults("setSearchChResults");
        builder.setSearchChDelayParameter("setSearchChDelayParameter");
        builder.setTimePathVariable("setTimePathVariable");
        builder.setStartLocation("setStartLocation");
        builder.setDestinationLocation("setDestinationLocation");
        builder.setLocationPath("setLocationPath");
        builder.setSearchChTermParameter("setSearchChTermParameter");
        builder.setSearchChStationId("setSearchChStationId");
        builder.setSearchChStationCoordinateParameter("setSearchChStationCoordinateParameter");
        builder.setLocationSearchTerm("setLocationSearchTerm");
        builder.setLanguage("setLanguage");
        builder.setAuthentificationUser("setAuthentificationUser");
        builder.setAuthentificationType("setAuthentificationPassword");
        builder.setAuthentificationPassword("");
        builder.setStationListPathVariable("setStationListPathVariable");
        builder.setJourneyPathVariable("setJourneyPathVariable");
        builder.setTravelPointPathVariable("setTravelPointPathVariable");
        builder.setResultLength(888);
        builder.setDistanceFromTravelPoint(999);
        builder.setResultLengthBeforeDepartureTime(1111);
        builder.setResultLengthAfterDepartureTime(2222);
        builder.setTariff("setTariff");
        builder.setTimeIsDeparture(false);
        builder.setHvvFilterEquivalent(false);
        builder.setHvvAllowTypeSwitch(false);
        builder.setAllowTariffDetails(false);
        builder.setAllowReducedPrice(false);
        builder.setAllowIntermediateStops(false);
        builder.setHvvReturnContSearchData(false);
        builder.setMic("setMic");
        builder.setChecksum("setChecksum");
        builder.setMac("setMac");
        builder.setHafasRtMode("setHafasRtMode");
        builder.setClientId("setClientId");
        builder.setClientSecret("setClientSecret");
        builder.setClientVersion("setClientVersion");
        builder.setClientName("setClientName");
        builder.setClientType("setClientType");
        builder.setTransfers(6);
        builder.setMinTransferTime(777);
        builder.setHafasProductionValue("setHafasProductionValue");
        builder.setForDisabledPersons("setForDisabledPersons");
        builder.setWalkingSpeed("setWalkingSpeed");
        builder.setAllowCoordinates(false);
        builder.setDepartureCoordinates(CoordinatesObjectMother.getCoordinatesWithNoEmptyFields().build());
        builder.setArrivalCoordinates(CoordinatesObjectMother.getCoordinatesWithNoEmptyFields().build());
        builder.setOutputFormat("setOutputFormat");
        return builder.build();
    }
}
