package com.doruk.addressservice;

import com.doruk.addressservice.controller.AddressService;
import com.doruk.addressservice.domain.AddressServiceImpl;
import com.doruk.addressservice.events.SimpleSourceBean;
import com.doruk.addressservice.infrastructure.AddressRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableBinding(Source.class)
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}

	@Bean
	AddressService addressService(AddressRepository addressRepository){
		return new AddressServiceImpl(addressRepository);
	}

}
