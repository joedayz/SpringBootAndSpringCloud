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
@Table(name = "rsmortgage_degree_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DegreeType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String degreeTypeName;

	@Column(nullable = false)
	private String degreeTypeDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDegreeTypeName() {
		return degreeTypeName;
	}

	public void setDegreeTypeName(String degreeTypeName) {
		this.degreeTypeName = degreeTypeName;
	}

	public String getDegreeTypeDescription() {
		return degreeTypeDescription;
	}

	public void setDegreeTypeDescription(String degreeTypeDescription) {
		this.degreeTypeDescription = degreeTypeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((degreeTypeDescription == null) ? 0 : degreeTypeDescription.hashCode());
		result = prime * result + ((degreeTypeName == null) ? 0 : degreeTypeName.hashCode());
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
		DegreeType other = (DegreeType) obj;
		if (degreeTypeDescription == null) {
			if (other.degreeTypeDescription != null)
				return false;
		} else if (!degreeTypeDescription.equals(other.degreeTypeDescription))
			return false;
		if (degreeTypeName == null) {
			if (other.degreeTypeName != null)
				return false;
		} else if (!degreeTypeName.equals(other.degreeTypeName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public DegreeType(){
		
	}
	
	public DegreeType(long id, String degreeTypeName, String degreeTypeDescription) {
		super();
		this.id = id;
		this.degreeTypeName = degreeTypeName;
		this.degreeTypeDescription = degreeTypeDescription;
	}

}
