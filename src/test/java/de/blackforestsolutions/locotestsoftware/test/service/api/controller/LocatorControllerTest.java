package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
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

@SpringBootTest
@AutoConfigureMockMvc
public class LocatorControllerTest {

    @Value("${loco.locator.controller.url}")
    private String locoLocatorControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();


    @Test
    void test_retrieveLocatorJourneys_test_data() throws JsonProcessingException {
        String urlString = this.locoLocatorControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getSearchChTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Coordinates resultMapped = new ObjectMapper().readValue(result.getBody(), Coordinates.class);

        //assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(1);
    }


    @Test
    void test_retrieveLocatorJourneys_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoLocatorControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getSearchChReverseTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        //Coordinates resultMapped = new ObjectMapper().readValue(result.getBody(), Coordinates.class);

        //assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(1);
    }

    private ResponseEntity<String> getLocations(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }
}
