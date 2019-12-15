package fr.selfmed.test.service.impl;

import fr.selfmed.test.config.ExternalConfig;
import fr.selfmed.test.parser.ParserFormat;
import fr.selfmed.test.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalServiceImpl implements ExternalService {

    private final WebClient client;

    @Autowired
    public ExternalServiceImpl(@Qualifier("externalApiClient") WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<String> getData(ParserFormat format) {
        return client.get()
                .uri(ExternalConfig.URI_RETRIEVE_DATA, format.toString())
                .exchange()
                .block()
                .bodyToMono(String.class);
    }

}
