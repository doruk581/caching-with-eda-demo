package com.doruk.customerservice.infrastructure;

import com.doruk.customerservice.domain.AddressService;
import org.springframework.web.client.RestTemplate;

public class AddressServiceGateway implements AddressService {

    private final RestTemplate restTemplate;
    private final AddressServiceConfiguration addressServiceConfiguration;

    public AddressServiceGateway(RestTemplate restTemplate,
        AddressServiceConfiguration addressServiceConfiguration) {
        this.restTemplate = restTemplate;
        this.addressServiceConfiguration = addressServiceConfiguration;
    }

    @Override
    public AddressDto getAddressInformation(String id) {
        return restTemplate.getForObject(getAddressServiceUrl(id),AddressDto.class);
    }

    private String getAddressServiceUrl(String id){
        return this.addressServiceConfiguration.getURL() + "/address/" + id;
    }
}
