package com.mit.service.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.mit.dto.ClasificationTypeInputDTO;
import com.mit.dto.CustomerDetailsInputDTO;
import com.mit.dto.CustomerDetailsResponseDTO;
import com.mit.dto.TypeValue;
import com.mit.entity.CustomerClassification;
import com.mit.entity.CustomerDetails;
import com.mit.entity.CustomerName;
import com.mit.entity.CustomerSignin;
import com.mit.exception.BusinessException;

@Component
public class CustomerServiceHelper {

	public CustomerClassification generateUserObjForCreate(ClasificationTypeInputDTO clasificationTypeCreateDTO) {
		CustomerClassification classification = new CustomerClassification();
		classification.setCustomerClassificationType(clasificationTypeCreateDTO.getCustomerClassificationType());
		classification
				.setCustomerClassificationTypeValue(clasificationTypeCreateDTO.getCustomerClassificationTypeValue());
		classification.setCRUDValue('C');

		setAuditLog(classification);
		return classification;
	}

	private void setAuditLog(CustomerClassification classification) {
		classification.setEffectiveDate(new Date(System.currentTimeMillis()));
		classification.setAcceptanceTimestamp(new Timestamp(System.currentTimeMillis()));
		classification.setAcceptanceTimestampUTCoffset(new Timestamp(System.currentTimeMillis()));
		classification.setHostTimestamp(new Timestamp(System.currentTimeMillis()));
		classification.setLocalTimestamp(new Timestamp(System.currentTimeMillis()));
		classification.setUserID("MIT Student");
		classification.setWorkstationID("MIT Workstation");
		classification.setProgramID("ProgramId");
		UUID uuid = UUID.randomUUID();
		classification.setUuid(uuid.toString());
	}

	public CustomerClassification generateUserObjForUpdate(CustomerClassification existingRecord,
			ClasificationTypeInputDTO clasificationTypeInputDTO) {
		if (clasificationTypeInputDTO.getCustomerClassificationType() != null) {
			existingRecord.setCustomerClassificationType(clasificationTypeInputDTO.getCustomerClassificationType());
		}
		if (clasificationTypeInputDTO.getCustomerClassificationTypeValue() != null) {
			existingRecord
					.setCustomerClassificationTypeValue(clasificationTypeInputDTO.getCustomerClassificationTypeValue());
		}
		existingRecord.setCRUDValue('U');
		setAuditLog(existingRecord);
		return existingRecord;
	}

	public CustomerDetails generateCustomerDetailsObjectForCreate(CustomerDetailsInputDTO customerDetailsInputDTO) {
		CustomerDetails customerDetails = new CustomerDetails();
		String cstmrName = "";
		customerDetails.setCustomerType(customerDetailsInputDTO.getCustomerType());
		for (TypeValue customerName : customerDetailsInputDTO.getCustomerName()) {
			cstmrName = cstmrName + customerName.getValue() + " ";
		}
		customerDetails.setCustomerFullName(cstmrName);
		customerDetails.setCustomerDOB(customerDetailsInputDTO.getCustomerDOB());
		customerDetails.setCustomerCountryOrigin(customerDetailsInputDTO.getCustomerCountryOrigin());
		customerDetails.setCustomerGender(customerDetailsInputDTO.getCustomerGender());
		customerDetails.setCustomerPreferredLanguage(customerDetailsInputDTO.getCustomerPreferredLanguage());
		customerDetails.setCustomerStatus(customerDetailsInputDTO.getCustomerStatus());
		customerDetails.setCRUDValue('C');
		setAuditLogForCustomerDetails(customerDetails);
		List<CustomerName> customerNames = setCustomerNames(customerDetailsInputDTO);
		customerDetails.setCustName(customerNames);
		return customerDetails;
	}

	private List<CustomerName> setCustomerNames(CustomerDetailsInputDTO customerDetailsInputDTO) {
		List<CustomerName> custNames = new ArrayList<>();
		for (TypeValue cstmrName : customerDetailsInputDTO.getCustomerName()) {
			CustomerName custName = new CustomerName();
			custName.setCustomerNameComponentType(cstmrName.getType());
			custName.setCustomerNameComponentValue(cstmrName.getValue());
			setAuditDetailsForCustomerNames(custName);
			custNames.add(custName);
		}
		return custNames;
	}

	private void setCustomerNamesForUpdate(CustomerDetails customerDetails,
			CustomerDetailsInputDTO customerDetailsInputDTO) {
		int count = 0;
		if (null != customerDetailsInputDTO.getCustomerName() && !customerDetailsInputDTO.getCustomerName().isEmpty()) {
			for (TypeValue cstmrName : customerDetailsInputDTO.getCustomerName()) {
				for (int i = 0; i < customerDetails.getCustName().size(); i++) {
					if (cstmrName.getType()
							.equals(customerDetails.getCustName().get(i).getCustomerNameComponentType())) {
						customerDetails.getCustName().get(i).setCustomerNameComponentValue(cstmrName.getValue());
						setAuditDetailsForCustomerNames(customerDetails.getCustName().get(i));
						customerDetails.getCustName().get(i).setCRUDValue('U');
						count++;
					}
				}
			}
		}
		if (null != customerDetailsInputDTO.getCustomerName() && count != customerDetailsInputDTO.getCustomerName().size()) {
			throw new BusinessException("nametypenotvalid");
		}
	}

	private void setAuditDetailsForCustomerNames(CustomerName firstName) {
		firstName.setEffectiveDate(new Date(System.currentTimeMillis()));
		firstName.setAcceptanceTimestamp(new Timestamp(System.currentTimeMillis()));
		firstName.setAcceptanceTimestampUTCoffset(new Timestamp(System.currentTimeMillis()));
		firstName.setHostTimestamp(new Timestamp(System.currentTimeMillis()));
		firstName.setLocalTimestamp(new Timestamp(System.currentTimeMillis()));
		firstName.setUserID("MIT Student");
		firstName.setWorkstationID("MIT Workstation");
		firstName.setProgramID("ProgramId");
		UUID uuid = UUID.randomUUID();
		firstName.setUuid(uuid.toString());
		firstName.setCRUDValue('C');
	}

	private void setAuditLogForCustomerDetails(CustomerDetails customerDetails) {
		customerDetails.setEffectiveDate(new Date(System.currentTimeMillis()));
		customerDetails.setAcceptanceTimestamp(new Timestamp(System.currentTimeMillis()));
		customerDetails.setAcceptanceTimestampUTCoffset(new Timestamp(System.currentTimeMillis()));
		customerDetails.setHostTimestamp(new Timestamp(System.currentTimeMillis()));
		customerDetails.setLocalTimestamp(new Timestamp(System.currentTimeMillis()));
		customerDetails.setUserID("MIT Student");
		customerDetails.setWorkstationID("MIT Workstation");
		customerDetails.setProgramID("ProgramId");
		UUID uuid = UUID.randomUUID();
		customerDetails.setUuid(uuid.toString());
	}

	public CustomerDetails generateCustomerDetailsObjectForUpdate(CustomerDetails exsistingDetails,
			CustomerDetailsInputDTO customerDetailsUpdateDTO) {
		if (customerDetailsUpdateDTO.getCustomerCountryOrigin() != null) {
			exsistingDetails.setCustomerCountryOrigin(customerDetailsUpdateDTO.getCustomerCountryOrigin());
		}
		if (customerDetailsUpdateDTO.getCustomerDOB() != null) {
			exsistingDetails.setCustomerDOB(customerDetailsUpdateDTO.getCustomerDOB());
		}
		String cstmrName = "";
		if (customerDetailsUpdateDTO.getCustomerName() != null) {
			for (TypeValue customerName : customerDetailsUpdateDTO.getCustomerName()) {
				cstmrName = cstmrName + customerName.getValue() + " ";
			}
		}
		exsistingDetails.setCustomerFullName(cstmrName);
		setCustomerNamesForUpdate(exsistingDetails, customerDetailsUpdateDTO);
		if (customerDetailsUpdateDTO.getCustomerGender() != null) {
			exsistingDetails.setCustomerGender(customerDetailsUpdateDTO.getCustomerGender());
		}
		if (customerDetailsUpdateDTO.getCustomerPreferredLanguage() != null) {
			exsistingDetails.setCustomerPreferredLanguage(customerDetailsUpdateDTO.getCustomerPreferredLanguage());
		}
		if (customerDetailsUpdateDTO.getCustomerStatus() != null) {
			exsistingDetails.setCustomerStatus(customerDetailsUpdateDTO.getCustomerStatus());
		}
		if (customerDetailsUpdateDTO.getCustomerType() != null) {
			exsistingDetails.setCustomerType(customerDetailsUpdateDTO.getCustomerType());
		}
		exsistingDetails.setCRUDValue('U');
		setAuditLogForCustomerDetails(exsistingDetails);
		return exsistingDetails;
	}

	public CustomerDetailsResponseDTO generateCustomerDetailsObjectForGet(CustomerDetails customerDetails) {
		CustomerDetailsResponseDTO customerDetailsResponseDTO = new CustomerDetailsResponseDTO();
		List<TypeValue> custNames = new ArrayList<>();
		for (CustomerName customerName : customerDetails.getCustName()) {
			TypeValue cstmrName = new TypeValue();
			cstmrName.setType(customerName.getCustomerNameComponentType());
			cstmrName.setValue(customerName.getCustomerNameComponentValue());
			custNames.add(cstmrName);
		}
		customerDetailsResponseDTO.setCustomerid(customerDetails.getCustomerIdentifier());
		customerDetailsResponseDTO.setCustomerName(custNames);
		customerDetailsResponseDTO.setCustomerCountryOrigin(customerDetails.getCustomerCountryOrigin());
		customerDetailsResponseDTO.setCustomerDOB(customerDetails.getCustomerDOB());
		customerDetailsResponseDTO.setCustomerGender(customerDetails.getCustomerGender());
		customerDetailsResponseDTO.setCustomerPreferredLanguage(customerDetails.getCustomerPreferredLanguage());
		customerDetailsResponseDTO.setCustomerStatus(customerDetails.getCustomerStatus());
		customerDetailsResponseDTO.setCustomerType(customerDetails.getCustomerType());
		return customerDetailsResponseDTO;
	}

	public void validateCredentials(CustomerSignin customerSignin) {
		if(customerSignin == null) {
			throw new BusinessException("invalidPassword"); 
		}
	}
}
