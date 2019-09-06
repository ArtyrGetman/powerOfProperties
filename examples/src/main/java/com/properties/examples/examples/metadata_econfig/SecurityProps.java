package com.properties.examples.examples.metadata_econfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@ConfigurationProperties("my.app.security")
public class SecurityProps {

    private String url = "https://myapp.security.com";

    private String password;

    @Deprecated(forRemoval = true, since = "must be deleted 25.05.2019")
    private String login;

    /**
     * status for activation - possible variable:
     * -enable
     * -disable
     */
    private String activationStatus;

    private final Map<UrlType, String> urlTypes = new HashMap<>();
}
