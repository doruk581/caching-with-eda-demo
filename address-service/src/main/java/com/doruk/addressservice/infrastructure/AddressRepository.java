package com.doruk.addressservice.infrastructure;

import com.doruk.addressservice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {

}
