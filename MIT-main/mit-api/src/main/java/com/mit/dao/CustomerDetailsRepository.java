package com.mit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mit.entity.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long>  {
	
	CustomerDetails findBycustomerIdentifier(Long Id);
	
	@Query(value ="Select * from CUST_DTL where CUST_TYPE = :custType", nativeQuery = true)
	List<CustomerDetails> getCustomerByType(@Param("custType") String custType);
	
}
