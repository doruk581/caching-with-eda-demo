package com.doruk.customerservice.domain;

import com.doruk.customerservice.infrastructure.AddressDto;

public interface AddressService {

    AddressDto getAddressInformation(final String id);
}
