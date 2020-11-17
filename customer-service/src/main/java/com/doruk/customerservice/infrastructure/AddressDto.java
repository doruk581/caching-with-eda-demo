package com.doruk.customerservice.infrastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String country;
    private String town;
    private String zipCode;
}
