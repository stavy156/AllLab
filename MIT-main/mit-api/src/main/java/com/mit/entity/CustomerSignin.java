package com.mit.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "CSTMR_SIGNIN")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerSignin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_IDFR")
	private Long Id;
	
	@OneToOne
	@JoinColumn(name="CSTID_IDFR", nullable = false)
	CustomerDetails customerDetails;
	
	@Column(name = "USR_USRNAME")
	private String username;
	@Column(name = "USR_PASSWORD")
	private String password;
	@Column(name = "USR_EFCTV_DT")
	private Date effectiveDate;
	@Column(name = "USR_CRUD_VALUE")
	private char CRUDValue;
	@Column(name = "USR_USER_ID")
	private String userID;
	@Column(name = "USR_WS_ID")
	private String workstationID;
	@Column(name = "USR_PRGM_ID")
	private String ProgramID;
	@Column(name = "USR_HOST_TS")
	private Timestamp hostTimestamp;
	@Column(name = "USR_LOCAL_TS")
	private Timestamp localTimestamp;
	@Column(name = "USR_ACPT_TS")
	private Timestamp acceptanceTimestamp;
	@Column(name = "USR_ACPT_TS_UTC_OFST")
	private Timestamp acceptanceTimestampUTCoffset;
	@Column(name = "USR_UUID")
	private String uuid;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	
	
}
