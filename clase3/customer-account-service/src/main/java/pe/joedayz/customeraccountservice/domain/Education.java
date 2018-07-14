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
@Table(name = "rsmortgage_education")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Education {

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
	private boolean isCurrentSchool;
	
	@Column(nullable = false)
	private boolean didGraduate;
	
	@Column(nullable = false)
	private float cumulativeGpa;
	
	@Column(nullable = false)
	private String schoolName;
	
	@OneToOne
	@JoinColumn(name="degree_type_id")
	private DegreeType degreeType;
	
	@Column(nullable = false)
	private String 	schoolAdminPerson;
	
	@Column(nullable = false)
	private String schoolAdminPhone;
	
	@Column(nullable = false)
	private String schoolAdminEmail;
	
	@Column(nullable = false)
	private String schoolAdminFax;
	
	@Column(nullable = false)
	private String schoolAddressLine1;
	
	@Column(nullable = false)
	private String schoolAddressLine2;
	
	@Column(nullable = false)
	private String schoolAddressCity;
	
	@Column(nullable = false)
	private String schoolAddressState;
	
	@Column(nullable = false)
	private String schoolAddressCountry;
	
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

	public boolean isCurrentSchool() {
		return isCurrentSchool;
	}

	public void setCurrentSchool(boolean isCurrentSchool) {
		this.isCurrentSchool = isCurrentSchool;
	}

	public boolean isDidGraduate() {
		return didGraduate;
	}

	public void setDidGraduate(boolean didGraduate) {
		this.didGraduate = didGraduate;
	}

	public float getCumulativeGpa() {
		return cumulativeGpa;
	}

	public void setCumulativeGpa(float cumulativeGpa) {
		this.cumulativeGpa = cumulativeGpa;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public DegreeType getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(DegreeType degreeType) {
		this.degreeType = degreeType;
	}

	public String getSchoolAdminPerson() {
		return schoolAdminPerson;
	}

	public void setSchoolAdminPerson(String schoolAdminPerson) {
		this.schoolAdminPerson = schoolAdminPerson;
	}

	public String getSchoolAdminPhone() {
		return schoolAdminPhone;
	}

	public void setSchoolAdminPhone(String schoolAdminPhone) {
		this.schoolAdminPhone = schoolAdminPhone;
	}

	public String getSchoolAdminEmail() {
		return schoolAdminEmail;
	}

	public void setSchoolAdminEmail(String schoolAdminEmail) {
		this.schoolAdminEmail = schoolAdminEmail;
	}

	public String getSchoolAdminFax() {
		return schoolAdminFax;
	}

	public void setSchoolAdminFax(String schoolAdminFax) {
		this.schoolAdminFax = schoolAdminFax;
	}

	public String getSchoolAddressLine1() {
		return schoolAddressLine1;
	}

	public void setSchoolAddressLine1(String schoolAddressLine1) {
		this.schoolAddressLine1 = schoolAddressLine1;
	}

	public String getSchoolAddressLine2() {
		return schoolAddressLine2;
	}

	public void setSchoolAddressLine2(String schoolAddressLine2) {
		this.schoolAddressLine2 = schoolAddressLine2;
	}

	public String getSchoolAddressCity() {
		return schoolAddressCity;
	}

	public void setSchoolAddressCity(String schoolAddressCity) {
		this.schoolAddressCity = schoolAddressCity;
	}

	public String getSchoolAddressState() {
		return schoolAddressState;
	}

	public void setSchoolAddressState(String schoolAddressState) {
		this.schoolAddressState = schoolAddressState;
	}

	public String getSchoolAddressCountry() {
		return schoolAddressCountry;
	}

	public void setSchoolAddressCountry(String schoolAddressCountry) {
		this.schoolAddressCountry = schoolAddressCountry;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", fromDate=" + fromDate + ", dateTo=" + dateTo + ", isCurrentSchool="
				+ isCurrentSchool + ", didGraduate=" + didGraduate + ", cumulativeGpa=" + cumulativeGpa
				+ ", schoolName=" + schoolName + ", degreeType=" + degreeType + ", schoolAdminPerson="
				+ schoolAdminPerson + ", schoolAdminPhone=" + schoolAdminPhone + ", schoolAdminEmail="
				+ schoolAdminEmail + ", schoolAdminFax=" + schoolAdminFax + ", schoolAddressLine1=" + schoolAddressLine1
				+ ", schoolAddressLine2=" + schoolAddressLine2 + ", schoolAddressCity=" + schoolAddressCity
				+ ", schoolAddressState=" + schoolAddressState + ", schoolAddressCountry=" + schoolAddressCountry + "]";
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
		Education other = (Education) obj;
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
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		return true;
	}
	
	public Education(){
		
	}

	public Education(long id, Date fromDate, Date dateTo, boolean isCurrentSchool, boolean didGraduate,
			float cumulativeGpa, String schoolName, DegreeType degreeType, String schoolAdminPerson,
			String schoolAdminPhone, String schoolAdminEmail, String schoolAdminFax, String schoolAddressLine1,
			String schoolAddressLine2, String schoolAddressCity, String schoolAddressState, String schoolAddressCountry,
			Customer customer) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.dateTo = dateTo;
		this.isCurrentSchool = isCurrentSchool;
		this.didGraduate = didGraduate;
		this.cumulativeGpa = cumulativeGpa;
		this.schoolName = schoolName;
		this.degreeType = degreeType;
		this.schoolAdminPerson = schoolAdminPerson;
		this.schoolAdminPhone = schoolAdminPhone;
		this.schoolAdminEmail = schoolAdminEmail;
		this.schoolAdminFax = schoolAdminFax;
		this.schoolAddressLine1 = schoolAddressLine1;
		this.schoolAddressLine2 = schoolAddressLine2;
		this.schoolAddressCity = schoolAddressCity;
		this.schoolAddressState = schoolAddressState;
		this.schoolAddressCountry = schoolAddressCountry;
		this.customer = customer;
	}
	
	
}
