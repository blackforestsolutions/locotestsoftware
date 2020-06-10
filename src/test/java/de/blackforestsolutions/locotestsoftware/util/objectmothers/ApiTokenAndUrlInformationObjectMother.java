package de.blackforestsolutions.locotestsoftware.util.objectmothers;

import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.Coordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static de.blackforestsolutions.locotestsoftware.testutil.TestUtils.generateDateFromPatternAndString;

@Slf4j
public class ApiTokenAndUrlInformationObjectMother {

    public static ApiTokenAndUrlInformation getEmptyApiToken() {
        return new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder().build();
    }

    public static ApiTokenAndUrlInformation getOSMApiTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("nominatim.openstreetmap.org");
        builder.setDeparture("Stuttgart, Waiblinger Str. 84");
        builder.setArrival("Stuttgart, Waiblinger Str. 84");
        builder.setOutputFormat("json");
        builder.setResultLength(1);
        builder.setPath("/?addressdetails=1&q=Stuttgart,+Waiblinger+Str.+84&format=json&limit=1");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getNahShTokenAndUrl(String departure, String arrival) {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = getHafasStandardTokenAndUrl();
        builder.setHost("nah.sh.hafas.de");
        builder.setClientId("NAHSH");
        builder.setClientVersion("3000700");
        builder.setClientName("NAHSHPROD");
        builder.setAuthorization("r0Ot9FLFNAFxijLW");
        builder.setDeparture(departure);
        builder.setArrival(arrival);
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-02-13 11:46:50"));
        } catch (ParseException e) {
            log.error("Error While parsing Date", e);
        }
        builder.setHafasProductionValue("1023");
        builder.setResultLengthAfterDepartureTime(1);
        builder.setTimeIsDeparture(true);
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getVBBTokenAndUrl(String departure, String arrival) {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = getHafasStandardTokenAndUrl();
        builder.setHost("fahrinfo.vbb.de");
        builder.setApiName("VBB.1");
        builder.setMic("mic");
        builder.setMac("mac");
        builder.setClientId("VBB");
        builder.setClientVersion("4010300");
        builder.setClientName("vbbPROD");
        builder.setClientType("IPA");
        builder.setDeparture(departure);
        builder.setArrival(arrival);
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-02-14 09:26:53"));
        } catch (ParseException e) {
            log.error("Error While parsing Date", e);
        }
        builder.setAuthentificationType("AID");
        builder.setAuthorization("hafas-vbb-apps");
        builder.setDeparture(departure);
        builder.setArrival(arrival);
        builder.setAuthorizationKey("5243544a4d3266467846667878516649");
        builder.setHafasProductionValue("127");
        builder.setWalkingSpeed("foot_speed_normal");
        builder.setResultLengthAfterDepartureTime(1);
        builder.setTimeIsDeparture(true);
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getDBTokenAndUrl(String departure, String arrival) {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = getHafasStandardTokenAndUrl();
        builder.setHost("reiseauskunft.bahn.de");
        builder.setApiName("DB.R19.04.a");
        builder.setChecksum("checksum");
        builder.setHafasRtMode("HYBRID");
        builder.setClientId("DB");
        builder.setClientVersion("16040000");
        builder.setClientName("DB Navigator");
        builder.setClientType("IPH");
        builder.setDeparture(departure);
        builder.setArrival(arrival);
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-02-14 09:44:29"));
        } catch (ParseException e) {
            log.error("Error While parsing Date", e);
        }
        builder.setAuthentificationType("AID");
        builder.setAuthorization("n91dB8Z77MLdoR0K");
        builder.setAuthorizationKey("bdI8UVj40K5fvxwf");
        builder.setHafasProductionValue("1023");
        builder.setResultLengthAfterDepartureTime(1);
        builder.setTimeIsDeparture(true);
        builder.setAllowReducedPrice(true);
        builder.setPath("/bin/mgate.exe?checksum=6d0c117c5a7f98d00582bc4a9be5dad1");
        return builder.build();
    }

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
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse("2019-11-04-14-00-00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getHvvTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();

        builder.setProtocol("http");
        builder.setHost("api-test.geofox.de");
        builder.setPathVariable("gti/public");
        builder.setTravelPointPathVariable("/checkName");
        builder.setStationListPathVariable("/listStations");
        builder.setJourneyPathVariable("/getRoute");
        builder.setAuthentificationType("HmacSHA1");
        builder.setAuthentificationUser("janhendrikhausner");
        builder.setAuthentificationPassword("R!7aP2YUK3yD");
        builder.setApiVersion("37.3");
        builder.setLanguage("de");
        builder.setResultLength(1);
        builder.setDistanceFromTravelPoint(2500);
        builder.setDeparture("Ahrensburg");
        builder.setArrival("Stadthausbrücke");
        builder.setPath("/gti/public/checkName");
        builder.setHvvAllowTypeSwitch(true);
        builder.setAllowTariffDetails(true);
        builder.setHvvFilterEquivalent(true);
        builder.setResultLength(1);
        builder.setDistanceFromTravelPoint(2500);
        builder.setHvvAllowTypeSwitch(true);
        try {
            builder.setDepartureDate(generateDateFromPatternAndString("dd.MM.yyyy HH:mm", "31.01.2020 13:10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        builder.setResultLengthBeforeDepartureTime(2);
        builder.setResultLengthAfterDepartureTime(2);
        builder.setTariff("all");
        builder.setTimeIsDeparture(true);
        builder.setAllowReducedPrice(true);
        builder.setPath("/gti/public/getRoute");

        return builder.build();
    }

    public static ApiTokenAndUrlInformation getRMVTokenAndUrl(String departure, String arrival) {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("www.rmv.de");
        builder.setLocationPath("hapi/location.name?");
        builder.setGermanRailJourneyDeatilsPath("hapi/trip?");
        builder.setAuthorizationKey("Authorization");
        builder.setAuthorization("1a4fbca8-ce2b-40fc-a1ed-333bcf5aed6e");
        builder.setArrival(arrival);
        builder.setDeparture(departure);
        return builder.build();
    }

    public static ApiTokenAndUrlInformation configurationToken() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("www.rmv.de");
        builder.setPort(0);
        builder.setPathVariable("hapi/location.name?");
        builder.setLocationPath("hapi/location.name?");
        builder.setGermanRailJourneyDeatilsPath("hapi/trip?");
        builder.setAuthorizationKey(HttpHeaders.AUTHORIZATION);
        builder.setAuthorization("1a4fbca8-ce2b-40fc-a1ed-333bcf5aed6e");
        return builder.build();
    }

    public static ApiTokenAndUrlInformation requestInfos() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setDeparture("testDeparture");
        builder.setArrival("testArrival");
        builder.setArrivalDate(Date.from(Instant.ofEpochSecond(10)));
        builder.setDepartureDate(Date.from(Instant.ofEpochSecond(1)));
        return builder.build();
    }

    public static ApiTokenAndUrlInformation getBahnTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("https");
        builder.setHost("api.deutschebahn.com");
        builder.setApiVersion("v1");
        builder.setPathVariable("fahrplan-plus");
        builder.setGermanRailLocationPath("location");
        builder.setGermanRailArrivalBoardPath("arrivalBoard");
        builder.setStationId("8011160");
        try {
            builder.setGermanRailDatePathVariable(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-25"));
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-25"));
        } catch (ParseException ignored) {
        }
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
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-28"));
            builder.setArrivalDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-28"));
        } catch (ParseException e) {
            log.error("Error While parsing Date", e);
        }
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

    public static ApiTokenAndUrlInformation getHazelcastTokenAndUrl() {
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder builder = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        builder.setProtocol("http");
        builder.setHost("localhost");
        builder.setPort(8081);
        builder.setHazelcastPath("/hazelcast/read-data");
        builder.setHazelcastReadAllPath("/hazelcast/read-all-data");
        builder.setHazelcastSearchPath("/hazelcast/read-data");
        builder.setHazelcastWritePath("/hazelcast/write-data");
        builder.setPathVariable("operations/schedules");
        builder.setPath("operations/schedules");
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
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-20"));
            builder.setArrivalDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-20"));
        } catch (ParseException e) {
            log.info("unable to parse british airways token: " + e);
        }
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
        try {
            builder.setDepartureDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-28"));
            builder.setArrivalDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-28"));
        } catch (ParseException e) {
            log.info("unable to parse bbc token: " + e);
        }
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
        builder.setArrival("Furtwangen");
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
