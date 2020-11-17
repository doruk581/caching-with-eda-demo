package com.doruk.addressservice.models;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddressRequest {
    private String id;
    private String country;
    private String town;
    private String zipCode;
}
