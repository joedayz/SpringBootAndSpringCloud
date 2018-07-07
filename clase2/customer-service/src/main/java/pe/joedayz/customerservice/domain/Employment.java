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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private String employerHRPerson;
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
		result = prime * result + ((employerAddressCity == null) ? 0 : employerAddressCity.hashCode());
		result = prime * result + ((employerAddressCountry == null) ? 0 : employerAddressCountry.hashCode());
		result = prime * result + ((employerAddressLine1 == null) ? 0 : employerAddressLine1.hashCode());
		result = prime * result + ((employerAddressLine2 == null) ? 0 : employerAddressLine2.hashCode());
		result = prime * result + ((employerAddressState == null) ? 0 : employerAddressState.hashCode());
		result = prime * result + ((employerHREmail == null) ? 0 : employerHREmail.hashCode());
		result = prime * result + ((employerHRFax == null) ? 0 : employerHRFax.hashCode());
		result = prime * result + ((employerHRPerson == null) ? 0 : employerHRPerson.hashCode());
		result = prime * result + ((employerHRPhone == null) ? 0 : employerHRPhone.hashCode());
		result = prime * result + ((employerName == null) ? 0 : employerName.hashCode());
		result = prime * result + ((employmentType == null) ? 0 : employmentType.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + Float.floatToIntBits(grossSalary);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isCurrentEmployer ? 1231 : 1237);
		result = prime * result + ((jobDescription == null) ? 0 : jobDescription.hashCode());
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + Float.floatToIntBits(netSalary);
		result = prime * result + Float.floatToIntBits(numYears);
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
		if (employerAddressCity == null) {
			if (other.employerAddressCity != null)
				return false;
		} else if (!employerAddressCity.equals(other.employerAddressCity))
			return false;
		if (employerAddressCountry == null) {
			if (other.employerAddressCountry != null)
				return false;
		} else if (!employerAddressCountry.equals(other.employerAddressCountry))
			return false;
		if (employerAddressLine1 == null) {
			if (other.employerAddressLine1 != null)
				return false;
		} else if (!employerAddressLine1.equals(other.employerAddressLine1))
			return false;
		if (employerAddressLine2 == null) {
			if (other.employerAddressLine2 != null)
				return false;
		} else if (!employerAddressLine2.equals(other.employerAddressLine2))
			return false;
		if (employerAddressState == null) {
			if (other.employerAddressState != null)
				return false;
		} else if (!employerAddressState.equals(other.employerAddressState))
			return false;
		if (employerHREmail == null) {
			if (other.employerHREmail != null)
				return false;
		} else if (!employerHREmail.equals(other.employerHREmail))
			return false;
		if (employerHRFax == null) {
			if (other.employerHRFax != null)
				return false;
		} else if (!employerHRFax.equals(other.employerHRFax))
			return false;
		if (employerHRPerson == null) {
			if (other.employerHRPerson != null)
				return false;
		} else if (!employerHRPerson.equals(other.employerHRPerson))
			return false;
		if (employerHRPhone == null) {
			if (other.employerHRPhone != null)
				return false;
		} else if (!employerHRPhone.equals(other.employerHRPhone))
			return false;
		if (employerName == null) {
			if (other.employerName != null)
				return false;
		} else if (!employerName.equals(other.employerName))
			return false;
		if (employmentType == null) {
			if (other.employmentType != null)
				return false;
		} else if (!employmentType.equals(other.employmentType))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (Float.floatToIntBits(grossSalary) != Float.floatToIntBits(other.grossSalary))
			return false;
		if (id != other.id)
			return false;
		if (isCurrentEmployer != other.isCurrentEmployer)
			return false;
		if (jobDescription == null) {
			if (other.jobDescription != null)
				return false;
		} else if (!jobDescription.equals(other.jobDescription))
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (Float.floatToIntBits(netSalary) != Float.floatToIntBits(other.netSalary))
			return false;
		if (Float.floatToIntBits(numYears) != Float.floatToIntBits(other.numYears))
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

	
}
