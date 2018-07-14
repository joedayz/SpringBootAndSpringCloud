package pe.joedayz.customeraccountservice.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_customer")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String socialSecurityNumber;

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}


	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "dob", unique = true, nullable = false, length = 10)
	private Date dateOfBirth;
	
	@Column(nullable = false)
	private double totalLoanAmount;

	@Column(nullable = false)
	private int bonusPoints;

	@Temporal(TemporalType.DATE)
	@Column(name = "customer_since", unique = true, nullable = false, length = 10)
	private Date memberSince;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Address> addresses = new HashSet<Address>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Account> accounts = new HashSet<Account>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Contact> contacts = new HashSet<Contact>();

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Education> education = new HashSet<Education>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Employment> employment = new HashSet<Employment>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Investment> investments = new HashSet<Investment>();

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @JsonManagedReference
	private Set<Liability> liabilities = new HashSet<Liability>();


	@Column()
	private int rating;


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", totalLoanAmount=" + totalLoanAmount + ", bonusPoints=" + bonusPoints
				+ ", memberSince=" + memberSince + ", addresses=" + addresses + ", accounts=" + accounts + ", contacts="
				+ contacts + ", education=" + education + ", employment=" + employment + ", investments=" + investments
				+ ", liabilities=" + liabilities + ", rating=" + rating + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((memberSince == null) ? 0 : memberSince.hashCode());
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
		Customer other = (Customer) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (memberSince == null) {
			if (other.memberSince != null)
				return false;
		} else if (!memberSince.equals(other.memberSince))
			return false;
		return true;
	}


	public Customer(){
		
	}
	public Customer(long id, String firstName, String lastName, Date dateOfBirth, double totalLoanAmount,
			int bonusPoints, Date memberSince, Set<Address> addresses, Set<Account> accounts, Set<Contact> contacts,
			Set<Education> education, Set<Employment> employment, Set<Investment> investments,
			Set<Liability> liabilities, int rating) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.totalLoanAmount = totalLoanAmount;
		this.bonusPoints = bonusPoints;
		this.memberSince = memberSince;
		this.addresses = addresses;
		this.accounts = accounts;
		this.contacts = contacts;
		this.education = education;
		this.employment = employment;
		this.investments = investments;
		this.liabilities = liabilities;
		this.rating = rating;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public double getTotalLoanAmount() {
		return totalLoanAmount;
	}


	public void setTotalLoanAmount(double totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}


	public int getBonusPoints() {
		return bonusPoints;
	}


	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}


	public Date getMemberSince() {
		return memberSince;
	}


	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}


	public Set<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}


	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}


	public Set<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}


	public Set<Education> getEducation() {
		return education;
	}


	public void setEducation(Set<Education> education) {
		this.education = education;
	}


	public Set<Employment> getEmployment() {
		return employment;
	}


	public void setEmployment(Set<Employment> employment) {
		this.employment = employment;
	}


	public Set<Investment> getInvestments() {
		return investments;
	}


	public void setInvestments(Set<Investment> investments) {
		this.investments = investments;
	}


	public Set<Liability> getLiabilities() {
		return liabilities;
	}


	public void setLiabilities(Set<Liability> liabilities) {
		this.liabilities = liabilities;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

	
}
