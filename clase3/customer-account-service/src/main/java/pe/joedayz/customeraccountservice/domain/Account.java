package pe.joedayz.customeraccountservice.domain;

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
@Table(name = "rsmortgage_account")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name="account_type_id")
	private AccountType accountType;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created", unique = true, nullable = false, length = 10)
	private Date dateCreated;
	
	@Column(nullable = false)
	private double originalCreditAmount;
	
	@Column(nullable = false)
	private double balanceAmount;
	
	@Column(nullable = false)
	private boolean fullyPaid;
	
	@Column(nullable = false)
	private int term;
	
	@Column(nullable = false)
	private float rateOfInterest;
	
	@Column(nullable = false)
	private boolean escrowAttached;
	
	@Column(nullable = false)
	private boolean pmiAttached;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference
	Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getOriginalCreditAmount() {
		return originalCreditAmount;
	}

	public void setOriginalCreditAmount(double originalCreditAmount) {
		this.originalCreditAmount = originalCreditAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public boolean isFullyPaid() {
		return fullyPaid;
	}

	public void setFullyPaid(boolean fullyPaid) {
		this.fullyPaid = fullyPaid;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public boolean isEscrowAttached() {
		return escrowAttached;
	}

	public void setEscrowAttached(boolean escrowAttached) {
		this.escrowAttached = escrowAttached;
	}

	public boolean isPmiAttached() {
		return pmiAttached;
	}

	public void setPmiAttached(boolean pmiAttached) {
		this.pmiAttached = pmiAttached;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Account other = (Account) obj;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public Account(){
		
	}
	
	public Account(long id, AccountType accountType, Date dateCreated, double originalCreditAmount,
			double balanceAmount, boolean fullyPaid, int term, float rateOfInterest, boolean escrowAttached,
			boolean pmiAttached, Customer customer) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.dateCreated = dateCreated;
		this.originalCreditAmount = originalCreditAmount;
		this.balanceAmount = balanceAmount;
		this.fullyPaid = fullyPaid;
		this.term = term;
		this.rateOfInterest = rateOfInterest;
		this.escrowAttached = escrowAttached;
		this.pmiAttached = pmiAttached;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", dateCreated=" + dateCreated
				+ ", originalCreditAmount=" + originalCreditAmount + ", balanceAmount=" + balanceAmount + ", fullyPaid="
				+ fullyPaid + ", term=" + term + ", rateOfInterest=" + rateOfInterest + ", escrowAttached="
				+ escrowAttached + ", pmiAttached=" + pmiAttached + ", customer=" + customer + "]";
	}
	
	
}
