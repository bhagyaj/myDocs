package com.polixia.policywallet.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Settings service main
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.polixia.policywallet")
@EnableResourceServer
public class SettingsServerMain {
    /**
     * This method will start a spring application
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SettingsServerMain.class, args);
    }
}
