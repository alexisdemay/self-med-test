package fr.selfmed.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TransactionsControllerTest extends AbstractControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetSelfMedOutput() {
        String body = this.restTemplate.getForObject("/api/v1/output?inputFormat=xml&outputFormat=self_med", String.class);
        assertThat(body).isEqualTo(getExpectedSelfMedOutput());
    }

    @Test
    public void testGetJsonOutput() {
        String body = this.restTemplate.getForObject("/api/v1/output?inputFormat=xml&outputFormat=json", String.class);
        assertThat(body).isEqualTo(getExpectedJsonOutput());
    }

}
