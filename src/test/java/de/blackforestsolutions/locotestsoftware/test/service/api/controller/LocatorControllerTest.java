package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

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

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class LocatorControllerTest {

    @Value("${loco.locator.controller.url}")
    private String locoLocatorControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();


    @Test
    void test_retrieveLocatorTravelPoint_with_departure() throws IOException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrl();
        String url = locoLocatorControllerUrl + "?address=" + testData.getDeparture();

        ResponseEntity<String> result = retrieveLocatorTravelPoint(url);
        TravelPoint resultMapped = locoJsonMapper.mapJsonToTravelPoint(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped.getStationName()).isNotEmpty();
    }


    @Test
    void test_retrieveLocatorTravelPoint_with_arrival() throws IOException {
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getApiTokenAndUrl();
        String url = locoLocatorControllerUrl + "?address=" + testData.getArrival();

        ResponseEntity<String> result = retrieveLocatorTravelPoint(url);
        TravelPoint resultMapped = locoJsonMapper.mapJsonToTravelPoint(result.getBody());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultMapped).isNotNull();
        assertThat(resultMapped.getStationName()).isNotEmpty();
    }

    private ResponseEntity<String> retrieveLocatorTravelPoint(String url) {
        return restTemplate.postForEntity(url, HttpEntity.EMPTY, String.class);
    }
}
