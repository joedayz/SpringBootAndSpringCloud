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
@Table(name = "rsmortgage_investment_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InvestmentType {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@Column(nullable = false)
private String invetmentTypeName;
@Column(nullable = false)
private String investmentTypeDescription;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getInvetmentTypeName() {
	return invetmentTypeName;
}
public void setInvetmentTypeName(String invetmentTypeName) {
	this.invetmentTypeName = invetmentTypeName;
}
public String getInvestmentTypeDescription() {
	return investmentTypeDescription;
}
public void setInvestmentTypeDescription(String investmentTypeDescription) {
	this.investmentTypeDescription = investmentTypeDescription;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((investmentTypeDescription == null) ? 0 : investmentTypeDescription.hashCode());
	result = prime * result + ((invetmentTypeName == null) ? 0 : invetmentTypeName.hashCode());
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
	InvestmentType other = (InvestmentType) obj;
	if (id != other.id)
		return false;
	if (investmentTypeDescription == null) {
		if (other.investmentTypeDescription != null)
			return false;
	} else if (!investmentTypeDescription.equals(other.investmentTypeDescription))
		return false;
	if (invetmentTypeName == null) {
		if (other.invetmentTypeName != null)
			return false;
	} else if (!invetmentTypeName.equals(other.invetmentTypeName))
		return false;
	return true;
}

public InvestmentType(){

}

public InvestmentType(long id, String invetmentTypeName, String investmentTypeDescription) {
	super();
	this.id = id;
	this.invetmentTypeName = invetmentTypeName;
	this.investmentTypeDescription = investmentTypeDescription;
}
@Override
public String toString() {
	return "InvestmentType [id=" + id + ", invetmentTypeName=" + invetmentTypeName + ", investmentTypeDescription="
			+ investmentTypeDescription + "]";
}


}
