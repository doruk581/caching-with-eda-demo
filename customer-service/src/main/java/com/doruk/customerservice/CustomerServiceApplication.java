package com.doruk.customerservice;

import com.doruk.customerservice.controller.CustomerService;
import com.doruk.customerservice.domain.AddressService;
import com.doruk.customerservice.domain.CustomerServiceImpl;
import com.doruk.customerservice.infrastructure.AddressServiceConfiguration;
import com.doruk.customerservice.infrastructure.AddressServiceGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CustomerService customerService(AddressService addressService){
		return new CustomerServiceImpl(addressService);
	}

	@Bean
	AddressService addressService(RestTemplate restTemplate, AddressServiceConfiguration configuration){
		return new AddressServiceGateway(restTemplate,configuration);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
