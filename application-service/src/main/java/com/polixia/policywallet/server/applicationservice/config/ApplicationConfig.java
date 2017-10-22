package com.polixia.policywallet.server.applicationservice.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.yml")
public class ApplicationConfig {
    private static final String HYSTRIX_COMMAND_KEY = "EventKeY";

    @Resource
    private Environment env;

    @Bean
    public HystrixCommand.Setter hystrixConfig() {
        HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory
                .asKey(HYSTRIX_COMMAND_KEY));
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionTimeoutInMilliseconds(Integer.parseInt(env.getRequiredProperty("hystrix.timeout")));
        config.andCommandPropertiesDefaults(commandProperties);
        return config;
    }
}
