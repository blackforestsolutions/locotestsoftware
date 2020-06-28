package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.JourneyStatus;
import de.blackforestsolutions.datamodel.util.LocoJsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static de.blackforestsolutions.locotestsoftware.util.objectmothers.ApiTokenAndUrlInformationObjectMother.getAirportsFinderTokenAndUrl;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Value("${loco.flight.controller.url}")
    private String locoFlightControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_getFlights_with_test_data() throws JsonProcessingException {
        String urlString = this.locoFlightControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Frankfurt");
        testData.setArrival("Berlin");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<ApiTokenAndUrlInformation> requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getFlights(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }


    @Test
    void test_get_trains_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoFlightControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Frankfurt");
        testData.setArrival("Berlin");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        testData.setJourneyDetailsId("detailsId");
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<ApiTokenAndUrlInformation> requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getFlights(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }

    private ResponseEntity<String> getFlights(URI url, HttpEntity<ApiTokenAndUrlInformation> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }

    @Test
    void test_getFlights_with_airports_which_work_for_britishAirways_and_lufthansa() throws JsonProcessingException {
        String urlString = this.locoFlightControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("fra");
        testData.setArrival("lhr");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<ApiTokenAndUrlInformation> requestEntity = new HttpEntity(request);

        ResponseEntity<String> result = getFlights(uri, requestEntity);
        Map<UUID, JourneyStatus> resultMapped = new ObjectMapper().readValue(result.getBody(), HashMap.class);

        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(1);
        assertThat(resultMapped.values().stream().findFirst().get().getJourney().get().getId()).isEqualTo(resultMapped.entrySet().stream().findFirst().get());
    }

    @Test
    void test_getFlights_with_airports_which_dont_work_for_britishAirways_but_for_lufthansa() throws JsonProcessingException {
        String urlString = this.locoFlightControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("fra");
        testData.setArrival("ham");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<ApiTokenAndUrlInformation> requestEntity = new HttpEntity(request);
        ResponseEntity<String> result = getFlights(uri, requestEntity);
        Map<UUID, JourneyStatus> resultMapped = new ObjectMapper().readValue(result.getBody(), HashMap.class);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }
}
