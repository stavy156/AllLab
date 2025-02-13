package com.mit.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "CUST_DTL")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerid_seq")
	@SequenceGenerator(name="customerid_seq",sequenceName = "customer_id_seq", initialValue = 100000 , allocationSize = 10)
	@Column(name = "CSTID_IDFR")
	private Long customerIdentifier;
	@Column(name = "CUST_TYPE")
	private String customerType;
	@Column(name = "CUST_FULL_NAME")
	private String customerFullName;
	@Column(name = "CUST_DOB")
	private Date customerDOB;
	@Column(name = "CUST_STATUS")
	private String customerStatus;
	@Column(name = "CUST_GENDR")
	private String customerGender;
	@Column(name = "CUST_PRFRD_LNG")
	private String customerPreferredLanguage;
	@Column(name = "CUST_CNTRY_ORGTN")
	private String customerCountryOrigin;
	@Column(name = "CUST_EFCTV_DT")
	private Date effectiveDate;
	@Column(name = "CUST_CRUD_VALUE")
	private char CRUDValue;
	@Column(name = "CUST_USER_ID")
	private String userID;
	@Column(name = "CUST_WS_ID")
	private String workstationID;
	@Column(name = "CUST_PRGM_ID")
	private String ProgramID;
	@Column(name = "CUST_HOST_TS")
	private Timestamp hostTimestamp;
	@Column(name = "CUST_LOCAL_TS")
	private Timestamp localTimestamp;
	@Column(name = "CUST_ACPT_TS")
	private Timestamp acceptanceTimestamp;
	@Column(name = "CUST_ACPT_TS_UTC_OFST")
	private Timestamp acceptanceTimestampUTCoffset;
	@Column(name = "CUST_UUID")
	private String uuid;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_CSTID_IDFR",referencedColumnName = "CSTID_IDFR")
	private List<CustomerName> custName;

	public List<CustomerName> getCustName() {
		return custName;
	}
	public void setCustName(List<CustomerName> custName) {
		this.custName = custName;
	}
	public Long getCustomerIdentifier() {
		return customerIdentifier;
	}
	public void setCustomerIdentifier(Long customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerPreferredLanguage() {
		return customerPreferredLanguage;
	}
	public void setCustomerPreferredLanguage(String customerPreferredLanguage) {
		this.customerPreferredLanguage = customerPreferredLanguage;
	}
	public String getCustomerCountryOrigin() {
		return customerCountryOrigin;
	}
	public void setCustomerCountryOrigin(String customerCountryOrigin) {
		this.customerCountryOrigin = customerCountryOrigin;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public char getCRUDValue() {
		return CRUDValue;
	}
	public void setCRUDValue(char cRUDValue) {
		CRUDValue = cRUDValue;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getWorkstationID() {
		return workstationID;
	}
	public void setWorkstationID(String workstationID) {
		this.workstationID = workstationID;
	}
	public String getProgramID() {
		return ProgramID;
	}
	public void setProgramID(String programID) {
		ProgramID = programID;
	}
	public Timestamp getHostTimestamp() {
		return hostTimestamp;
	}
	public void setHostTimestamp(Timestamp hostTimestamp) {
		this.hostTimestamp = hostTimestamp;
	}
	public Timestamp getLocalTimestamp() {
		return localTimestamp;
	}
	public void setLocalTimestamp(Timestamp localTimestamp) {
		this.localTimestamp = localTimestamp;
	}
	public Timestamp getAcceptanceTimestamp() {
		return acceptanceTimestamp;
	}
	public void setAcceptanceTimestamp(Timestamp acceptanceTimestamp) {
		this.acceptanceTimestamp = acceptanceTimestamp;
	}
	public Timestamp getAcceptanceTimestampUTCoffset() {
		return acceptanceTimestampUTCoffset;
	}
	public void setAcceptanceTimestampUTCoffset(Timestamp acceptanceTimestampUTCoffset) {
		this.acceptanceTimestampUTCoffset = acceptanceTimestampUTCoffset;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
