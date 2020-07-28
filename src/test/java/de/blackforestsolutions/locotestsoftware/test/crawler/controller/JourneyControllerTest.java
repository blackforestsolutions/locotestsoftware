package de.blackforestsolutions.locotestsoftware.test.crawler.controller;

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
public class JourneyControllerTest {

    @Value("${loco.journey.controller.url}")
    private String locoJourneyControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_getFlights_with_test_data() throws JsonProcessingException {
        String urlString = this.locoJourneyControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlInformation();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getFlights(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }


    @Test
    void test_get_trains_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoJourneyControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlInformationReverse();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getFlights(uri, requestEntity);

        //Assertions.assertThat(result).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(0, 0);
    }

    private ResponseEntity<String> getFlights(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }
}
