package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.TravelPoint;
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
import java.util.LinkedHashSet;

@SpringBootTest
@AutoConfigureMockMvc
public class NearestStationFinderControllerTest {

    @Value("${loco.nearest.station.controller.url}")
    private String locoNearestControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    // todo problem is that before  sending a request we have to get de gps coordinates of the wanted location
    @Test
    void test_retrieveAirportsFinderTravelPoints_with_test_data() throws JsonProcessingException {
        String urlString = this.locoNearestControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlInformation();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        LinkedHashSet<TravelPoint> resultMapped = new ObjectMapper().readValue(result.getBody(), LinkedHashSet.class);

        //assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(1);
    }


    @Test
    void test_retrieveAirportsFinderTravelPoints_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoNearestControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlInformationReverse();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> result = getLocations(uri, requestEntity);

        LinkedHashSet<TravelPoint> resultMapped = new ObjectMapper().readValue(result.getBody(), LinkedHashSet.class);

        //assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(1);
    }

    private ResponseEntity<String> getLocations(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, String.class);
    }

}
