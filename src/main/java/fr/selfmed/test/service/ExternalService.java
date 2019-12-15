package fr.selfmed.test.service;

import fr.selfmed.test.parser.ParserFormat;
import reactor.core.publisher.Mono;

public interface ExternalService {

    Mono<String> getData(ParserFormat format);

}
