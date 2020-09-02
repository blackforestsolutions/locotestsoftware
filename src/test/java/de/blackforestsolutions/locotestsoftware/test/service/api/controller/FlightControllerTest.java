package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.Journey;
import de.blackforestsolutions.datamodel.util.LocoJsonMapper;
import de.blackforestsolutions.locotestsoftware.util.objectmothers.ApiTokenAndUrlInformationObjectMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerTest {

    @Value("${loco.flight.controller.url}")
    private String locoFlightControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_retrieveFlightJourneys_with_test_data_with_british_airway_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getBritishAirwaysTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveFlightJourneys(requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveFlightJourneys_with_test_data_with_lufthansa_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getLufthansaTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveFlightJourneys(requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }


    @Test
    void test_retrieveFlightJourneys_with_reverse_test_data_with_british_airway_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getBritishAirwaysTokenAndUrlReverse();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveFlightJourneys(requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveFlightJourneys_with_reverse_test_data_with_lufthansa_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getLufthansaTokenAndUrlReverse();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveFlightJourneys(requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    private ResponseEntity<String> retrieveFlightJourneys(HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(locoFlightControllerUrl, requestEntity, String.class);
    }

}
