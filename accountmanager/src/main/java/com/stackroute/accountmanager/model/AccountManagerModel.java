package com.stackroute.accountmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class AccountManagerModel {

    @Id
    private String userId;
    private String userPassword;
    private String firstName;
    private String lastName;
    private String userRole;
    private Date userAddedDate;
    
    
	public AccountManagerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountManagerModel(String userId, String userPassword, String firstName, String lastName, String userRole,
			Date userAddedDate) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.userAddedDate = userAddedDate;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Date getUserAddedDate() {
		return userAddedDate;
	}
	public void setUserAddedDate(Date userAddedDate) {
		this.userAddedDate = userAddedDate;
	}

	@Override
	public String toString() {
		return "AccountManagerModel [userId=" + userId + ", userPassword=" + userPassword + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userRole=" + userRole + ", userAddedDate=" + userAddedDate + "]";
	}
	
    
}
