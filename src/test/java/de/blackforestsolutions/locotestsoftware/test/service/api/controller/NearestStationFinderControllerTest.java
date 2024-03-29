package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class NearestStationFinderControllerTest {

    @Value("${loco.nearest.station.controller.url}")
    private String locoNearestControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_retrieveNearestAirportTravelPoints_with_test_data() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveNearestAirportTravelPoints(requestEntity);
        List<TravelPoint> resultMapped = locoJsonMapper.mapJsonToTravelPointList(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(0);
    }


    @Test
    void test_retrieveNearestAirportTravelPoints_with_reverse_test_data() throws JsonProcessingException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrlReverse();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<String> result = retrieveNearestAirportTravelPoints(requestEntity);
        List<TravelPoint> resultMapped = locoJsonMapper.mapJsonToTravelPointList(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(resultMapped).isNotNull();
        //assertThat(resultMapped).isNotEmpty();
        //assertThat(resultMapped.size()).isGreaterThan(0);
    }

    private ResponseEntity<String> retrieveNearestAirportTravelPoints(HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(locoNearestControllerUrl, requestEntity, String.class);
    }

}
