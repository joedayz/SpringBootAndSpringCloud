package com.rollingstone.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_contact")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name="contact_type_id")
	private ContactType contactType;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created", unique = true, nullable = false, length = 10)
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference
	Customer customer;
	
	@Column(nullable = true)
	private String emailAddress;
	
	@Column(nullable = true)
	private String phoneNumber;
	
	@Column(nullable = true)
	private String twitterHandles;
	
	@Column(nullable = true)
	private String faceBookId;

	public Contact(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTwitterHandles() {
		return twitterHandles;
	}

	public void setTwitterHandles(String twitterHandles) {
		this.twitterHandles = twitterHandles;
	}

	public String getFaceBookId() {
		return faceBookId;
	}

	public void setFaceBookId(String faceBookId) {
		this.faceBookId = faceBookId;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactType=" + contactType + ", dateCreated=" + dateCreated + ", customer="
				+ customer + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", twitterHandles="
				+ twitterHandles + ", faceBookId=" + faceBookId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((faceBookId == null) ? 0 : faceBookId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((twitterHandles == null) ? 0 : twitterHandles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactType == null) {
			if (other.contactType != null)
				return false;
		} else if (!contactType.equals(other.contactType))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (faceBookId == null) {
			if (other.faceBookId != null)
				return false;
		} else if (!faceBookId.equals(other.faceBookId))
			return false;
		if (id != other.id)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (twitterHandles == null) {
			if (other.twitterHandles != null)
				return false;
		} else if (!twitterHandles.equals(other.twitterHandles))
			return false;
		return true;
	}

	
	
	public Contact(long id, ContactType contactType, Date dateCreated, Customer customer, String emailAddress,
			String phoneNumber, String twitterHandles, String faceBookId) {
		super();
		this.id = id;
		this.contactType = contactType;
		this.dateCreated = dateCreated;
		this.customer = customer;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.twitterHandles = twitterHandles;
		this.faceBookId = faceBookId;
	}
	
	
	

}
