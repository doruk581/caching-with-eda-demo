package com.doruk.customerservice.infrastructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("address-service")
@Getter
@Setter
public class AddressServiceConfiguration {
    @Value("url")
    public String URL;
}
