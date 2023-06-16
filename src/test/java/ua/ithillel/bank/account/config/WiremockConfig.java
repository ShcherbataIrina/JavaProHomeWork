package ua.ithillel.bank.account.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WiremockConfig {

    private final static WireMockServer wireMockServer = new WireMockServer(8089);
    //  public final static WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());

    @Bean
    public WireMockServer wireMockServer() {
        return wireMockServer;
    }

    @PostConstruct
    public void startWireMockServer() {
        wireMockServer.start();
    }

    @PreDestroy
    public void stopWireMockServer() {
        wireMockServer.stop();
    }

}
