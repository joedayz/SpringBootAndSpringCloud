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
@Table(name = "rsmortgage_employment")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_from", unique = true, nullable = false, length = 10)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_to", unique = true, nullable = false, length = 10)
	private Date dateTo;

	@Column(nullable = false)
	private float numYears;

	@Column(nullable = false)
	private float grossSalary;

	@Column(nullable = false)
	private float netSalary;

	@Column(nullable = false)
	private boolean isCurrentEmployer;

	@Column(nullable = false)
	private String jobTitle;

	@Column(nullable = false)
	private String jobDescription;

	@Column(nullable = false)
	private String employerName;
	
	@Column(nullable = false)
	private String employmentType;
	
	@Column(nullable = false)
	private String 	employerHRPerson;
	
	@Column(nullable = false)
	private String employerHRPhone;
	
	@Column(nullable = false)
	private String employerHREmail;
	
	@Column(nullable = false)
	private String employerHRFax;
	
	@Column(nullable = false)
	private String employerAddressLine1;
	
	@Column(nullable = false)
	private String employerAddressLine2;
	
	@Column(nullable = false)
	private String employerAddressCity;
	
	@Column(nullable = false)
	private String employerAddressState;
	
	@Column(nullable = false)
	private String employerAddressCountry;
	
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

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public float getNumYears() {
		return numYears;
	}

	public void setNumYears(float numYears) {
		this.numYears = numYears;
	}

	public float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public float getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}

	public boolean isCurrentEmployer() {
		return isCurrentEmployer;
	}

	public void setCurrentEmployer(boolean isCurrentEmployer) {
		this.isCurrentEmployer = isCurrentEmployer;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getEmployerHRPerson() {
		return employerHRPerson;
	}

	public void setEmployerHRPerson(String employerHRPerson) {
		this.employerHRPerson = employerHRPerson;
	}

	public String getEmployerHRPhone() {
		return employerHRPhone;
	}

	public void setEmployerHRPhone(String employerHRPhone) {
		this.employerHRPhone = employerHRPhone;
	}

	public String getEmployerHREmail() {
		return employerHREmail;
	}

	public void setEmployerHREmail(String employerHREmail) {
		this.employerHREmail = employerHREmail;
	}

	public String getEmployerHRFax() {
		return employerHRFax;
	}

	public void setEmployerHRFax(String employerHRFax) {
		this.employerHRFax = employerHRFax;
	}

	public String getEmployerAddressLine1() {
		return employerAddressLine1;
	}

	public void setEmployerAddressLine1(String employerAddressLine1) {
		this.employerAddressLine1 = employerAddressLine1;
	}

	public String getEmployerAddressLine2() {
		return employerAddressLine2;
	}

	public void setEmployerAddressLine2(String employerAddressLine2) {
		this.employerAddressLine2 = employerAddressLine2;
	}

	public String getEmployerAddressCity() {
		return employerAddressCity;
	}

	public void setEmployerAddressCity(String employerAddressCity) {
		this.employerAddressCity = employerAddressCity;
	}

	public String getEmployerAddressState() {
		return employerAddressState;
	}

	public void setEmployerAddressState(String employerAddressState) {
		this.employerAddressState = employerAddressState;
	}

	public String getEmployerAddressCountry() {
		return employerAddressCountry;
	}

	public void setEmployerAddressCountry(String employerAddressCountry) {
		this.employerAddressCountry = employerAddressCountry;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Employment [id=" + id + ", fromDate=" + fromDate + ", dateTo=" + dateTo + ", numYears=" + numYears
				+ ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + ", isCurrentEmployer="
				+ isCurrentEmployer + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", employerName=" + employerName + ", employmentType=" + employmentType + ", employerHRPerson="
				+ employerHRPerson + ", employerHRPhone=" + employerHRPhone + ", employerHREmail=" + employerHREmail
				+ ", employerHRFax=" + employerHRFax + ", employerAddressLine1=" + employerAddressLine1
				+ ", employerAddressLine2=" + employerAddressLine2 + ", employerAddressCity=" + employerAddressCity
				+ ", employerAddressState=" + employerAddressState + ", employerAddressCountry="
				+ employerAddressCountry + ", customer=" + customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
		result = prime * result + ((employerName == null) ? 0 : employerName.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
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
		Employment other = (Employment) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dateTo == null) {
			if (other.dateTo != null)
				return false;
		} else if (!dateTo.equals(other.dateTo))
			return false;
		if (employerName == null) {
			if (other.employerName != null)
				return false;
		} else if (!employerName.equals(other.employerName))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		return true;
	}

	public Employment(){
		
	}
	
	public Employment(long id, Date fromDate, Date dateTo, float numYears, float grossSalary, float netSalary,
			boolean isCurrentEmployer, String jobTitle, String jobDescription, String employerName,
			String employmentType, String employerHRPerson, String employerHRPhone, String employerHREmail,
			String employerHRFax, String employerAddressLine1, String employerAddressLine2, String employerAddressCity,
			String employerAddressState, String employerAddressCountry, Customer customer) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.dateTo = dateTo;
		this.numYears = numYears;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
		this.isCurrentEmployer = isCurrentEmployer;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.employerName = employerName;
		this.employmentType = employmentType;
		this.employerHRPerson = employerHRPerson;
		this.employerHRPhone = employerHRPhone;
		this.employerHREmail = employerHREmail;
		this.employerHRFax = employerHRFax;
		this.employerAddressLine1 = employerAddressLine1;
		this.employerAddressLine2 = employerAddressLine2;
		this.employerAddressCity = employerAddressCity;
		this.employerAddressState = employerAddressState;
		this.employerAddressCountry = employerAddressCountry;
		this.customer = customer;
	}

	
}
