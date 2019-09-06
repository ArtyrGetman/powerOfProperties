package com.vault.demo.vault;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("app.test-config")
@Component
public class SecurityProperties {

    private String url = "https://myapp.security.test.com";
    private String username;
    private String password;
    private List<String> roles;

    public final Map<String, String> urlPossibleType = new HashMap<>();
}
