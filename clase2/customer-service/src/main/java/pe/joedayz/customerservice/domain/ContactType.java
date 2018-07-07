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
@Table(name = "rsmortgage_contact_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String contactTypeName;
	@Column(nullable = false)
	private String contactTypeDescription;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContactTypeName() {
		return contactTypeName;
	}
	public void setContactTypeName(String contactTypeName) {
		this.contactTypeName = contactTypeName;
	}
	public String getContactTypeDescription() {
		return contactTypeDescription;
	}
	public void setContactTypeDescription(String contactTypeDescription) {
		this.contactTypeDescription = contactTypeDescription;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactTypeDescription == null) ? 0 : contactTypeDescription.hashCode());
		result = prime * result + ((contactTypeName == null) ? 0 : contactTypeName.hashCode());
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
		ContactType other = (ContactType) obj;
		if (contactTypeDescription == null) {
			if (other.contactTypeDescription != null)
				return false;
		} else if (!contactTypeDescription.equals(other.contactTypeDescription))
			return false;
		if (contactTypeName == null) {
			if (other.contactTypeName != null)
				return false;
		} else if (!contactTypeName.equals(other.contactTypeName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public ContactType(long id, String contactTypeName, String contactTypeDescription) {
		super();
		this.id = id;
		this.contactTypeName = contactTypeName;
		this.contactTypeDescription = contactTypeDescription;
	}
	
	public ContactType()
	{
		
	}
}
