package fr.selfmed.test.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class ExternalConfig {

    public static final String URI_RETRIEVE_DATA = "/api/input?format={format}";

    private final SelfMedProperties selfMedProperties;

    @Autowired
    public ExternalConfig(SelfMedProperties selfMedProperties) {
        this.selfMedProperties = selfMedProperties;
    }

    @Bean
    @Qualifier("externalApiClient")
    public WebClient externalApiClient() {
        return WebClient.builder()
                .baseUrl(selfMedProperties.getExternal().getBaseUrl() + selfMedProperties
                        .getExternal().getContextPath())
                .filter(logRequest())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values
                            .forEach(value -> log.debug("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

}
