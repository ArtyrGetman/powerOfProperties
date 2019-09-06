package com.vault.demo.vault;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
public class VaultApplication implements CommandLineRunner {

    private final SecurityProperties securityProperties;

    @Value("${app.test-config.password}")
    String password;
    @Value("#{'${app.test-config.roles}'.split(',')}")
    List<String> roles;

    public static void main(String[] args) {
        SpringApplication.run(VaultApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("----------------------------------------");
        log.info("   Configuration properties");
        log.info("        username is {}", securityProperties.getUsername());
        log.info("        password is {}", securityProperties.getPassword());
        log.info("        url is {}", securityProperties.getUrl());
        log.info(securityProperties.getRoles());
        log.info(securityProperties.getUrlPossibleType());
        log.info("----------------------------------------");
        log.info("");
        log.info("----------------------------------------");
        log.info("   Configuration with @Value annotations");
        log.info("         password  {}", password);
        log.info("         roles  {}", roles);
        log.info("----------------------------------------");
    }

}
