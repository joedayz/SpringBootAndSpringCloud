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
@Table(name = "rsmortgage_account_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String accountTypeName;
	
	@Column(nullable = false)
	private String accountTypeDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public String getAccountTypeDescription() {
		return accountTypeDescription;
	}

	public void setAccountTypeDescription(String accountTypeDescription) {
		this.accountTypeDescription = accountTypeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountTypeDescription == null) ? 0 : accountTypeDescription.hashCode());
		result = prime * result + ((accountTypeName == null) ? 0 : accountTypeName.hashCode());
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
		AccountType other = (AccountType) obj;
		if (accountTypeDescription == null) {
			if (other.accountTypeDescription != null)
				return false;
		} else if (!accountTypeDescription.equals(other.accountTypeDescription))
			return false;
		if (accountTypeName == null) {
			if (other.accountTypeName != null)
				return false;
		} else if (!accountTypeName.equals(other.accountTypeName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", accountTypeName=" + accountTypeName + ", accountTypeDescription="
				+ accountTypeDescription + "]";
	}

	public AccountType(){
		
	}
	
	public AccountType(long id, String accountTypeName, String accountTypeDescription) {
		super();
		this.id = id;
		this.accountTypeName = accountTypeName;
		this.accountTypeDescription = accountTypeDescription;
	}

}
