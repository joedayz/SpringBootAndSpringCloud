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
	private String schoolAdminPerson;
	
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", fromDate=" + fromDate + ", dateTo=" + dateTo + ", isCurrentSchool="
				+ isCurrentSchool + ", didGraduate=" + didGraduate + ", cumulativeGpa=" + cumulativeGpa
				+ ", schoolName=" + schoolName + ", degreeType=" + degreeType + ", schoolAdminPerson="
				+ schoolAdminPerson + ", schoolAdminPhone=" + schoolAdminPhone + ", schoolAdminEmail="
				+ schoolAdminEmail + ", schoolAdminFax=" + schoolAdminFax + ", schoolAddressLine1=" + schoolAddressLine1
				+ ", schoolAddressLine2=" + schoolAddressLine2 + ", schoolAddressCity=" + schoolAddressCity
				+ ", schoolAddressState=" + schoolAddressState + ", schoolAddressCountry=" + schoolAddressCountry
				+ ", customer=" + customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cumulativeGpa);
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
		result = prime * result + ((degreeType == null) ? 0 : degreeType.hashCode());
		result = prime * result + (didGraduate ? 1231 : 1237);
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isCurrentSchool ? 1231 : 1237);
		result = prime * result + ((schoolAddressCity == null) ? 0 : schoolAddressCity.hashCode());
		result = prime * result + ((schoolAddressCountry == null) ? 0 : schoolAddressCountry.hashCode());
		result = prime * result + ((schoolAddressLine1 == null) ? 0 : schoolAddressLine1.hashCode());
		result = prime * result + ((schoolAddressLine2 == null) ? 0 : schoolAddressLine2.hashCode());
		result = prime * result + ((schoolAddressState == null) ? 0 : schoolAddressState.hashCode());
		result = prime * result + ((schoolAdminEmail == null) ? 0 : schoolAdminEmail.hashCode());
		result = prime * result + ((schoolAdminFax == null) ? 0 : schoolAdminFax.hashCode());
		result = prime * result + ((schoolAdminPerson == null) ? 0 : schoolAdminPerson.hashCode());
		result = prime * result + ((schoolAdminPhone == null) ? 0 : schoolAdminPhone.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
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
		if (Float.floatToIntBits(cumulativeGpa) != Float.floatToIntBits(other.cumulativeGpa))
			return false;
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
		if (degreeType == null) {
			if (other.degreeType != null)
				return false;
		} else if (!degreeType.equals(other.degreeType))
			return false;
		if (didGraduate != other.didGraduate)
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (id != other.id)
			return false;
		if (isCurrentSchool != other.isCurrentSchool)
			return false;
		if (schoolAddressCity == null) {
			if (other.schoolAddressCity != null)
				return false;
		} else if (!schoolAddressCity.equals(other.schoolAddressCity))
			return false;
		if (schoolAddressCountry == null) {
			if (other.schoolAddressCountry != null)
				return false;
		} else if (!schoolAddressCountry.equals(other.schoolAddressCountry))
			return false;
		if (schoolAddressLine1 == null) {
			if (other.schoolAddressLine1 != null)
				return false;
		} else if (!schoolAddressLine1.equals(other.schoolAddressLine1))
			return false;
		if (schoolAddressLine2 == null) {
			if (other.schoolAddressLine2 != null)
				return false;
		} else if (!schoolAddressLine2.equals(other.schoolAddressLine2))
			return false;
		if (schoolAddressState == null) {
			if (other.schoolAddressState != null)
				return false;
		} else if (!schoolAddressState.equals(other.schoolAddressState))
			return false;
		if (schoolAdminEmail == null) {
			if (other.schoolAdminEmail != null)
				return false;
		} else if (!schoolAdminEmail.equals(other.schoolAdminEmail))
			return false;
		if (schoolAdminFax == null) {
			if (other.schoolAdminFax != null)
				return false;
		} else if (!schoolAdminFax.equals(other.schoolAdminFax))
			return false;
		if (schoolAdminPerson == null) {
			if (other.schoolAdminPerson != null)
				return false;
		} else if (!schoolAdminPerson.equals(other.schoolAdminPerson))
			return false;
		if (schoolAdminPhone == null) {
			if (other.schoolAdminPhone != null)
				return false;
		} else if (!schoolAdminPhone.equals(other.schoolAdminPhone))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
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
