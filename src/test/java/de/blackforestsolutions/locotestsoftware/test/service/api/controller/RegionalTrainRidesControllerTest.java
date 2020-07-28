package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

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
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlInformation();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        Map<UUID, Journey> resultMapped = new ObjectMapper().readValue(result.getBody(), HashMap.class);

        assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(1);
    }


    @Test
    void test_retrieveTrainJourneys_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoRegionalTrainControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlInformationReverse();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        Map<UUID, Journey> resultMapped = new ObjectMapper().readValue(result.getBody(), HashMap.class);

        assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(1);
    }

    private ResponseEntity<String> getLocations(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }
}
