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
class RegionalTrainRidesControllerTest {

    @Value("${loco.regional.train.controller.url}")
    private String locoRegionalTrainControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_retrieveTrainJourneys_with_test_data_with_vbb_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getVbbTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_reverse_test_data_with_vbb_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getVbbTokenAndUrlReversed();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_test_data_with_nahSh_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getNahShTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_reverse_test_data_with_nahSh_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getNahShTokenAndUrlReversed();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_test_data_with_rmv_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getRmvTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_reverse_test_data_with_rmv_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getRmvTokenAndUrlReversed();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_test_data_with_hvv_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getHvvTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    @Test
    void test_retrieveTrainJourneys_with_reverse_test_data_with_hvv_token() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getHvvTokenAndUrlReversed();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveTrainJourneys(locoRegionalTrainControllerUrl, requestEntity);
        Map<UUID, Journey> resultMapped = locoJsonMapper.mapJsonToJourneyMap(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped).isNotEmpty();
        assertThat(resultMapped.size()).isGreaterThan(0);
    }

    private ResponseEntity<String> retrieveTrainJourneys(String url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }
}
