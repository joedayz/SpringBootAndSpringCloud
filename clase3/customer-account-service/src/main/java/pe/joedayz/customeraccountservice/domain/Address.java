package pe.joedayz.customeraccountservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rsmortgage_address")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String streetAddress;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String zipCode;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private boolean isCurrentAddress;

	@Column(nullable = false)
	private boolean isMailingAddress;

	@Column(nullable = false)
	private boolean isBillingAddress;

	@Column(nullable = false)
	private boolean isPermanentResidence;
	
	@Column(nullable = false)
	private boolean isInvestmentProperty;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference
	Customer customer;

	public Address() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isCurrentAddress() {
		return isCurrentAddress;
	}

	public void setCurrentAddress(boolean isCurrentAddress) {
		this.isCurrentAddress = isCurrentAddress;
	}

	public boolean isMailingAddress() {
		return isMailingAddress;
	}

	public void setMailingAddress(boolean isMailingAddress) {
		this.isMailingAddress = isMailingAddress;
	}

	public boolean isBillingAddress() {
		return isBillingAddress;
	}

	public void setBillingAddress(boolean isBillingAddress) {
		this.isBillingAddress = isBillingAddress;
	}

	public boolean isPermanentResidence() {
		return isPermanentResidence;
	}

	public void setPermanentResidence(boolean isPermanentResidence) {
		this.isPermanentResidence = isPermanentResidence;
	}

	public boolean isInvestmentProperty() {
		return isInvestmentProperty;
	}

	public void setInvestmentProperty(boolean isInvestmentProperty) {
		this.isInvestmentProperty = isInvestmentProperty;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress=" + streetAddress + ", state=" + state + ", city=" + city
				+ ", zipCode=" + zipCode + ", country=" + country + ", isCurrentAddress=" + isCurrentAddress
				+ ", isMailingAddress=" + isMailingAddress + ", isBillingAddress=" + isBillingAddress
				+ ", isPermanentResidence=" + isPermanentResidence + ", isInvestmentProperty=" + isInvestmentProperty
				+ ", customer=" + customer + "]";
	}

	public Address(long id, String streetAddress, String state, String city, String zipCode, String country,
			boolean isCurrentAddress, boolean isMailingAddress, boolean isBillingAddress, boolean isPermanentResidence,
			boolean isInvestmentProperty, Customer customer) {
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.isCurrentAddress = isCurrentAddress;
		this.isMailingAddress = isMailingAddress;
		this.isBillingAddress = isBillingAddress;
		this.isPermanentResidence = isPermanentResidence;
		this.isInvestmentProperty = isInvestmentProperty;
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	

	

}
