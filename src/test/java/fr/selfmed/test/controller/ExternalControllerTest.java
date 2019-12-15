package fr.selfmed.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ExternalControllerTest extends AbstractControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetXmlInput() {
        String body = this.restTemplate.getForObject("/api/input?format=xml", String.class);
        assertThat(body).isEqualTo(getXmlExpectedFormat());
    }

    @Test
    public void testGetJsonInput() {
        String body = this.restTemplate.getForObject("/api/input?format=json", String.class);
        assertThat(body).isEqualTo(getJsonExpectedFormat());
    }

}
