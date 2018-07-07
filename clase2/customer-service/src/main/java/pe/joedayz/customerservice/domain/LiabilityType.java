package pe.joedayz.customerservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "rsmortgage_liability_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LiabilityType {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@Column(nullable = false)
private String liabilityTypeName;
@Column(nullable = false)
private String liabilityTypeDescription;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getLiabilityTypeName() {
	return liabilityTypeName;
}
public void setLiabilityTypeName(String liabilityTypeName) {
	this.liabilityTypeName = liabilityTypeName;
}
public String getLiabilityTypeDescription() {
	return liabilityTypeDescription;
}
public void setLiabilityTypeDescription(String liabilityTypeDescription) {
	this.liabilityTypeDescription = liabilityTypeDescription;
}
@Override
public String toString() {
	return "LiabilityType [id=" + id + ", liabilityTypeName=" + liabilityTypeName + ", liabilityTypeDescription="
			+ liabilityTypeDescription + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((liabilityTypeDescription == null) ? 0 : liabilityTypeDescription.hashCode());
	result = prime * result + ((liabilityTypeName == null) ? 0 : liabilityTypeName.hashCode());
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
	LiabilityType other = (LiabilityType) obj;
	if (id != other.id)
		return false;
	if (liabilityTypeDescription == null) {
		if (other.liabilityTypeDescription != null)
			return false;
	} else if (!liabilityTypeDescription.equals(other.liabilityTypeDescription))
		return false;
	if (liabilityTypeName == null) {
		if (other.liabilityTypeName != null)
			return false;
	} else if (!liabilityTypeName.equals(other.liabilityTypeName))
		return false;
	return true;
}

public LiabilityType(){
	
}

public LiabilityType(long id, String liabilityTypeName, String liabilityTypeDescription) {
	super();
	this.id = id;
	this.liabilityTypeName = liabilityTypeName;
	this.liabilityTypeDescription = liabilityTypeDescription;
}


}
