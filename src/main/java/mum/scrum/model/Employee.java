package mum.scrum.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
    @GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private String phoneNumber;
	private String email;
	@Column(unique = true)
	private String userId;
	private String password;
	private Boolean enabled;
	
	@NotNull(message="Employee role can not be null")
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy="employee", orphanRemoval=true)
	private List<EmployeeRole> employeeRoles;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<EmployeeRole> getEmployeeRoles() {
		return employeeRoles;
	}
	public void setEmployeeRoles(List<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", userId=" + userId
				+ ", password=" + password + ", enabled=" + enabled + ", employeeRoles=" + employeeRoles + ", status="
				+ status + "]";
	}
	
	
	
}
