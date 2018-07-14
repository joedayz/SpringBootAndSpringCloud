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
@Table(name = "rsmortgage_liability")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Liability {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_from", unique = true, nullable = false, length = 10)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "maturity_date", unique = true, nullable = false, length = 10)
	private Date dateMaturing;
	
	@OneToOne
	@JoinColumn(name="liability_type_id")
	private LiabilityType investmentType;

	@Column(nullable = false)
	private double originalTotalLiability;

	@Column(nullable = false)
	private double currentTotalLiability;

	@Column(nullable = false)
	private String 	paymentFrequency;
	
	@Column(nullable = false)
	private float 	periodEMI;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference
	Customer customer;
	
	public Liability(){
		
	}

	public long getId() {
		return id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getDateMaturing() {
		return dateMaturing;
	}

	public void setDateMaturing(Date dateMaturing) {
		this.dateMaturing = dateMaturing;
	}

	public LiabilityType getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(LiabilityType investmentType) {
		this.investmentType = investmentType;
	}

	public double getOriginalTotalLiability() {
		return originalTotalLiability;
	}

	public void setOriginalTotalLiability(double originalTotalLiability) {
		this.originalTotalLiability = originalTotalLiability;
	}

	public double getCurrentTotalLiability() {
		return currentTotalLiability;
	}

	public void setCurrentTotalLiability(double currentTotalLiability) {
		this.currentTotalLiability = currentTotalLiability;
	}

	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public float getPeriodEMI() {
		return periodEMI;
	}

	public void setPeriodEMI(float periodEMI) {
		this.periodEMI = periodEMI;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Liability [id=" + id + ", fromDate=" + fromDate + ", dateMaturing=" + dateMaturing + ", investmentType="
				+ investmentType + ", originalTotalLiability=" + originalTotalLiability + ", currentTotalLiability="
				+ currentTotalLiability + ", paymentFrequency=" + paymentFrequency + ", periodEMI=" + periodEMI
				+ ", customer=" + customer + "]";
	}

	public Liability(long id, Date fromDate, Date dateMaturing, LiabilityType investmentType,
			double originalTotalLiability, double currentTotalLiability, String paymentFrequency, float periodEMI,
			Customer customer) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.dateMaturing = dateMaturing;
		this.investmentType = investmentType;
		this.originalTotalLiability = originalTotalLiability;
		this.currentTotalLiability = currentTotalLiability;
		this.paymentFrequency = paymentFrequency;
		this.periodEMI = periodEMI;
		this.customer = customer;
	}

	
	
}
