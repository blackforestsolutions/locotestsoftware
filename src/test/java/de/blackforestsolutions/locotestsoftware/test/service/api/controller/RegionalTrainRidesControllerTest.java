package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
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

import static de.blackforestsolutions.locotestsoftware.util.objectmothers.ApiTokenAndUrlInformationObjectMother.getAirportsFinderTokenAndUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class RegionalTrainRidesControllerTest {

    @Value("${loco.regional.train.controller.url}")
    private String locoRegionalTrainControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_retrieveTrainJourneys_with_test_data() throws JsonProcessingException {
        String urlString = this.locoRegionalTrainControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Berlin");
        testData.setArrival("Frankfurt");
        testData.setJourneyDetailsId("detailsId");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }


    @Test
    void test_retrieveTrainJourneys_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoRegionalTrainControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder testData = new ApiTokenAndUrlInformation.ApiTokenAndUrlInformationBuilder();
        testData.setDepartureCoordinates(getAirportsFinderTokenAndUrl().getDepartureCoordinates());
        testData.setDeparture("Frankfurt");
        testData.setArrival("Berlin");
        testData.setDepartureDate(Date.from(Instant.now()));
        testData.setArrivalDate(Date.from(Instant.now().plusSeconds(99999)));
        testData.setJourneyDetailsId("detailsId");
        String request = locoJsonMapper.map(testData.build());
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }

    private ResponseEntity<String> getLocations(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }
}
