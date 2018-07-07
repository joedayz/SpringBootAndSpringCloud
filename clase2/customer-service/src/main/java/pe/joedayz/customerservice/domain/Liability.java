package pe.joedayz.customerservice.domain;

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
	private LiabilityType liabilityType;
	@Column(nullable = false)
	private double originalTotalLiability;
	
	@Column(nullable = false)
	private double currentTotalLiability;
	@Column(nullable = false)
	private String paymentFrequency;
	@Column(nullable = false)
	private float periodEMI;
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
	
	public LiabilityType getLiabilityType() {
		return liabilityType;
	}
	public void setLiabilityType(LiabilityType liabilityType) {
		this.liabilityType = liabilityType;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(currentTotalLiability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateMaturing == null) ? 0 : dateMaturing.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		temp = Double.doubleToLongBits(originalTotalLiability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentFrequency == null) ? 0 : paymentFrequency.hashCode());
		result = prime * result + Float.floatToIntBits(periodEMI);
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
		Liability other = (Liability) obj;
		if (Double.doubleToLongBits(currentTotalLiability) != Double.doubleToLongBits(other.currentTotalLiability))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dateMaturing == null) {
			if (other.dateMaturing != null)
				return false;
		} else if (!dateMaturing.equals(other.dateMaturing))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(originalTotalLiability) != Double.doubleToLongBits(other.originalTotalLiability))
			return false;
		if (paymentFrequency == null) {
			if (other.paymentFrequency != null)
				return false;
		} else if (!paymentFrequency.equals(other.paymentFrequency))
			return false;
		if (Float.floatToIntBits(periodEMI) != Float.floatToIntBits(other.periodEMI))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Liability [id=" + id + ", fromDate=" + fromDate + ", dateMaturing=" + dateMaturing
				+ ", originalTotalLiability=" + originalTotalLiability + ", currentTotalLiability="
				+ currentTotalLiability + ", paymentFrequency=" + paymentFrequency + ", periodEMI=" + periodEMI
				+ ", customer=" + customer + "]";
	}
	
	public Liability(){
		
	}
	
	public Liability(long id, Date fromDate, Date dateMaturing, LiabilityType liabilityType,
			double originalTotalLiability, double currentTotalLiability, String paymentFrequency, float periodEMI,
			Customer customer) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.dateMaturing = dateMaturing;
		this.liabilityType = liabilityType;
		this.originalTotalLiability = originalTotalLiability;
		this.currentTotalLiability = currentTotalLiability;
		this.paymentFrequency = paymentFrequency;
		this.periodEMI = periodEMI;
		this.customer = customer;
	}
	
	
}
