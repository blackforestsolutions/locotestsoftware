package de.blackforestsolutions.locotestsoftware.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.JourneyStatus;
import de.blackforestsolutions.datamodel.util.LocoJsonMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static de.blackforestsolutions.locotestsoftware.util.objectmothers.ApiTokenAndUrlInformationObjectMother.getAirportsFinderTokenAndUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class RideShareControllerTest {

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_retrieveRideSharingJourneys_with_test_data() throws JsonProcessingException {
        String urlString = "http://localhost:8082/ride-shares/get/";
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Frankfurt");
        testData.setArrival("Berlin");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<ApiTokenAndUrlInformation> requestEntity = new HttpEntity(request);
        Map<UUID, JourneyStatus> result = getFlights(uri, requestEntity);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isGreaterThan(0);
    }


    @Test
    void test_retrieveRideSharingJourneys_with_reverse_test_data() throws JsonProcessingException {
        String urlString = "http://localhost:8082/ride-shares/get/";
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
        Map<UUID, JourneyStatus> result = getFlights(uri, requestEntity);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isGreaterThan(0);
    }

    private Map<UUID, JourneyStatus> getFlights(URI url, HttpEntity<ApiTokenAndUrlInformation> requestEntity) {
        return (Map<UUID, JourneyStatus>) restTemplate.postForEntity(url, requestEntity, Map.class).getBody();
    }
}
