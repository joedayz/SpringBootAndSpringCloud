package pe.joedayz.customerservice.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_user")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String userName;

	@Temporal(TemporalType.DATE)
	@Column(name = "user_since", unique = true, nullable = false, length = 10)
	private Date user_since;

	@OneToOne
	@JoinColumn(name="id")
	private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUser_since() {
		return user_since;
	}

	public void setUser_since(Date user_since) {
		this.user_since = user_since;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", user_since=" + user_since + ", customer=" + customer
				+ ", getId()=" + getId() + ", getUserName()=" + getUserName() + ", getUser_since()=" + getUser_since()
				+ ", getCustomer()=" + getCustomer() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public User(){
		
	}
	
	public User(long id, String userName, Date user_since, Customer customer) {
		super();
		this.id = id;
		this.userName = userName;
		this.user_since = user_since;
		this.customer = customer;
	}
	
	
}
