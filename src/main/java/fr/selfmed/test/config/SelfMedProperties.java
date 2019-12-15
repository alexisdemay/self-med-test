package fr.selfmed.test.config;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Getter
@ConfigurationProperties(prefix = SelfMedConstants.SPRING_SELF_MED_PROPERTIES_SUFFIX)
public class SelfMedProperties {

    private final External external;

    public SelfMedProperties() {
        this.external = new External();
    }

    @PostConstruct
    public void print() {
        log.info("Self-med application properties has been loaded");
    }

    @Data
    public static class External {
        private String baseUrl;
        private String contextPath;
    }

}
