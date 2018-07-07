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
@Table(name = "rsmortgage_investment")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Investment {

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
	@JoinColumn(name="investment_type_id")
	private InvestmentType investmentType;
	
	@Column(nullable = false)
	private double currentValue;
	
	@Column(nullable = false)
	private double investedValue;
	
	@Column(nullable = false)
	private float monthlyIncome;
	
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

	public InvestmentType getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(InvestmentType investmentType) {
		this.investmentType = investmentType;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public double getInvestedValue() {
		return investedValue;
	}

	public void setInvestedValue(double investedValue) {
		this.investedValue = investedValue;
	}

	public float getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(float monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
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
		temp = Double.doubleToLongBits(currentValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateMaturing == null) ? 0 : dateMaturing.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		temp = Double.doubleToLongBits(investedValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(monthlyIncome);
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
		Investment other = (Investment) obj;
		if (Double.doubleToLongBits(currentValue) != Double.doubleToLongBits(other.currentValue))
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
		if (Double.doubleToLongBits(investedValue) != Double.doubleToLongBits(other.investedValue))
			return false;
		if (Float.floatToIntBits(monthlyIncome) != Float.floatToIntBits(other.monthlyIncome))
			return false;
		return true;
	}

	public Investment(){
		
	}
	
	public Investment(long id, Date fromDate, Date dateMaturing, InvestmentType investmentType, double currentValue,
			double investedValue, float monthlyIncome, Customer customer) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.dateMaturing = dateMaturing;
		this.investmentType = investmentType;
		this.currentValue = currentValue;
		this.investedValue = investedValue;
		this.monthlyIncome = monthlyIncome;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Investment [id=" + id + ", fromDate=" + fromDate + ", dateMaturing=" + dateMaturing + ", currentValue="
				+ currentValue + ", investedValue=" + investedValue + ", monthlyIncome=" + monthlyIncome + ", customer="
				+ customer + "]";
	}
	
	
}
