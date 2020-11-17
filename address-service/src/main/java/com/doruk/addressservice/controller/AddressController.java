package com.doruk.addressservice.controller;

import com.doruk.addressservice.events.SimpleSourceBean;
import com.doruk.addressservice.models.AddAddressRequest;
import com.doruk.addressservice.models.UpdateAddressRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddressController {

    private final AddressService addressService;
    private final SimpleSourceBean simpleSourceBean;

    public AddressController(AddressService addressService,SimpleSourceBean simpleSourceBean) {
        this.addressService = addressService;
        this.simpleSourceBean = simpleSourceBean;
    }

    @GetMapping(value = "/v1/address/{id}")
    public ResponseEntity<Object> getAddressInformation(@PathVariable String id){
        return ResponseEntity.ok(addressService.getAddressInformation(id));
    }

    @PostMapping(value = "/v1/address")
    public ResponseEntity<Object> addAddressInformation(@RequestBody AddAddressRequest addAddressRequest){
        addressService.addAddressInformation(addAddressRequest);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/v1/address")
    public ResponseEntity<Object> updateAddressInformation(@RequestBody UpdateAddressRequest updateAddressRequest){
        addressService.updateAddressInformation(updateAddressRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/v1/address/{id}")
    public ResponseEntity<Object> deleteAddressInformation(@PathVariable String id){
        addressService.deleteAddressInformation(id);
        simpleSourceBean.publishAddressChange("DELETE",id);
        return ResponseEntity.noContent().build();
    }

}
