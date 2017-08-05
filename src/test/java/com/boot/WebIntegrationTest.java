package com.boot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@org.springframework.boot.test.WebIntegrationTest
public class WebIntegrationTest {

    @Test
    public void testListAll() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(responseEntity.getBody());
        assertThat(responseJson.isMissingNode(), equalTo(false));
        assertThat(responseJson.toString().length(), greaterThan(2));
    }

    @Test
    public void testGet() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks/999999", String.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(responseEntity.getBody(), nullValue());

    }

}
