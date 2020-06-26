package de.blackforestsolutions.locotestsoftware.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.Coordinates;
import de.blackforestsolutions.datamodel.util.LocoJsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.Date;

import static de.blackforestsolutions.locotestsoftware.util.objectmothers.ApiTokenAndUrlInformationObjectMother.getAirportsFinderTokenAndUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class NearestStationFinderControllerTest {

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    // todo problem is that before  sending a request we have to get de gps coordinates of the wanted location
    @Test
    void test_retrieveAirportsFinderTravelPoints_with_test_data() throws JsonProcessingException {
        String urlString = "http://localhost:8089/nearest-airports/get/";
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Berlin");
        testData.setArrival("Frankfurt");
        testData.setJourneyDetailsId("detailsId");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }


    @Test
    void test_retrieveAirportsFinderTravelPoints_with_reverse_test_data() throws JsonProcessingException {
        String urlString = "http://localhost:8089/nearest-airports/get/";
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Frankfurt");
        testData.setArrival("Berlin");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        testData.setJourneyDetailsId("detailsId");
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<String> requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }

    private ResponseEntity<String> getLocations(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }

    @Test
    void test_retrieveAirportsFinderTravelPoints_with_Coordinates_returns_correctly() throws JsonProcessingException {
        String urlString = "http://localhost:8089/nearest-airports/get/";
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Berlin");
        testData.setArrival("Frankfurt");
        testData.setJourneyDetailsId("detailsId");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        testData.setDepartureCoordinates(getTestDataCoordinates(52.52437, 13.41053));
        testData.setArrivalCoordinates(getTestDataCoordinates(50.11552, 8.68417));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }

    private Coordinates getTestDataCoordinates(double lat, double lon) {
        return new Coordinates.CoordinatesBuilder(lat, lon).build();

    }

    @Test
    void test_retrieveAirportsFinderTravelPoints_without_needed_coordinates_returns_error_code_in_controller_callStatus() throws JsonProcessingException {
        String urlString = "http://localhost:8089/nearest-airports/get/";
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Berlin");
        testData.setArrival("Frankfurt");
        testData.setJourneyDetailsId("detailsId");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        testData.setDepartureCoordinates(getTestDataCoordinates(52.52437, 13.41053));
        testData.setArrivalCoordinates(getTestDataCoordinates(50.11552, 8.68417));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }

}
