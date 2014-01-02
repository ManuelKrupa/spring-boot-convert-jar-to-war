package demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long id;
	
	@Column(name="USER_LOGIN")
	private String login;
	
	@Column(name="USER_PWD")
	private String password;
	
	@Column(name="USER_1ST_NAME")
	private String firstName;
	
	@Column(name="USER_LAST_NAME")
	private String lastName;
	
	@ManyToMany
	@JoinTable(
		      name="USER_ROLE",
		      joinColumns={@JoinColumn(name="ASS_USER_ID", referencedColumnName="USER_ID")},
		      inverseJoinColumns={@JoinColumn(name="ASS_ROLE_ID", referencedColumnName="ROLE_ID")})
	private List<Role> roles;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
