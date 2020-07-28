package de.blackforestsolutions.locotestsoftware.test.service.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.blackforestsolutions.datamodel.ApiTokenAndUrlInformation;
import de.blackforestsolutions.datamodel.JourneyStatus;
import de.blackforestsolutions.datamodel.util.LocoJsonMapper;
import de.blackforestsolutions.locotestsoftware.util.objectmothers.ApiTokenAndUrlInformationObjectMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class RideShareControllerTest {

    @Value("${loco.ride.share.controller.url}")
    private String locoRideShareControllerUrl;

    private final LocoJsonMapper locoJsonMapper = new LocoJsonMapper();
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Test
    void test_retrieveRideSharingJourneys_with_test_data() throws JsonProcessingException {
        String urlString = this.locoRideShareControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getBbcTokenAndUrl();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        Map<UUID, JourneyStatus> result = getFlights(uri, requestEntity);

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isGreaterThan(1);
    }


    @Test
    void test_retrieveRideSharingJourneys_with_reverse_test_data() throws JsonProcessingException {
        String urlString = this.locoRideShareControllerUrl;
        URI uri = UriComponentsBuilder.fromUriString(urlString).build().toUri();
        ApiTokenAndUrlInformation testData = ApiTokenAndUrlInformationObjectMother.getBbcTokenAndUrlReversed();
        String request = locoJsonMapper.map(testData);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);
        Map<UUID, JourneyStatus> result = getFlights(uri, requestEntity);

        assertThat(result).isNotNull();
        //assertThat(result).isNotEmpty();
        //assertThat(result.size()).isGreaterThan(1);
    }

    private Map<UUID, JourneyStatus> getFlights(URI url, HttpEntity<String> requestEntity) {
        return restTemplate.postForEntity(url, requestEntity, Map.class).getBody();
    }
}
