package com.doruk.customerservice.domain;

import com.doruk.customerservice.controller.CustomerService;
import com.doruk.customerservice.infrastructure.AddressDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final AddressService addressService;

    public CustomerServiceImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public void process(String id) {
        final AddressDto addressDto = addressService.getAddressInformation(id);
        final Address address =
            Address.builder()
                .country(addressDto.getCountry())
                .zipCode(addressDto.getZipCode()).town(addressDto.getTown()).build();
        final CustomerInformation customerInformation =
            CustomerInformation.builder().address(address).identityInformation(id).build();

        log.info("Customer information: " + customerInformation.toString());
    }
}
