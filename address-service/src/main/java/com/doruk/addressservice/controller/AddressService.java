package com.doruk.addressservice.controller;

import com.doruk.addressservice.models.AddAddressRequest;
import com.doruk.addressservice.models.AddressResponse;
import com.doruk.addressservice.models.UpdateAddressRequest;

public interface AddressService {
AddressResponse getAddressInformation(final String id);
void addAddressInformation(final AddAddressRequest addAddressRequest);
void updateAddressInformation(final UpdateAddressRequest updateAddressRequest);
void deleteAddressInformation(final String id);
}
