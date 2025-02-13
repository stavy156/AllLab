package com.mit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mit.dao.CustomerClasificationRepository;
import com.mit.dao.CustomerDetailsRepository;
import com.mit.dao.CustomerSigninRepository;
import com.mit.dto.CustomerDetailsInputDTO;
import com.mit.dto.CustomerDetailsResponseDTO;
import com.mit.dto.UserLoginDTO;
import com.mit.entity.CustomerDetails;
import com.mit.entity.CustomerSignin;
import com.mit.service.CustomerService;
import com.mit.service.helper.CustomerServiceHelper;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	CustomerClasificationRepository customerClasificationRepository;
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	@Autowired
	CustomerServiceHelper customerServiceHelper;
	@Autowired
	CustomerSigninRepository customerSigninRepository;


	@Override
	public CustomerDetails addCustomerDetails(CustomerDetailsInputDTO customerDetailsInputDTO) {
		CustomerDetails customerDetails = customerServiceHelper
				.generateCustomerDetailsObjectForCreate(customerDetailsInputDTO);
		customerDetails = customerDetailsRepository.save(customerDetails);
		return customerDetails;
	}

	@Override
	public CustomerDetailsResponseDTO getCustomerDetails(Long id) {
		CustomerDetails customerDetails = customerDetailsRepository.findBycustomerIdentifier(id);
		CustomerDetailsResponseDTO customerDetailsResponseDTO = customerServiceHelper.generateCustomerDetailsObjectForGet(customerDetails);
		return customerDetailsResponseDTO;
	}

	@Override
	public void deleteCustomerDetails(Long id) {
		customerDetailsRepository.deleteById(id);
	}

	@Override
	public void updateCustomerDetails(Long id, CustomerDetailsInputDTO customerDetailsUpdateDTO) {
		CustomerDetails exsistingDetails = customerDetailsRepository.findBycustomerIdentifier(id);
		exsistingDetails = customerServiceHelper.generateCustomerDetailsObjectForUpdate(exsistingDetails,
				customerDetailsUpdateDTO);
		customerDetailsRepository.save(exsistingDetails);

	}

	@Override
	public CustomerDetails getUserLoginResponse(UserLoginDTO userLoginDTO) {
		CustomerSignin customerSignin =  customerSigninRepository.findByUsernameAndPassword(userLoginDTO.getusername(),userLoginDTO.getpassword());
		customerServiceHelper.validateCredentials(customerSignin);
		CustomerDetails customerDetails = customerSignin.getCustomerDetails();
		return customerDetails;
	}
	
	@Override
	public List<CustomerDetailsResponseDTO> getCustomers(String custType) {
		List<CustomerDetails> customerDetails = new ArrayList<>();
		if(custType.equals("includeAll")) {
			customerDetails = customerDetailsRepository.findAll();
		}else {
			customerDetails = customerDetailsRepository.getCustomerByType(custType);
		}
		
		List<CustomerDetailsResponseDTO> customerDetailsResponseDTOList=new ArrayList<>();
		for(CustomerDetails cust:customerDetails) {
			CustomerDetailsResponseDTO customerDetailsResponseDTO = customerServiceHelper.generateCustomerDetailsObjectForGet(cust);
			customerDetailsResponseDTOList.add(customerDetailsResponseDTO);
		}
		return customerDetailsResponseDTOList;
	}

}
