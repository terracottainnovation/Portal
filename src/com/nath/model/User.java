/**
 * 
 */
package com.nath.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ram
 *
 *  Refer http://www.techferry.com/articles/hibernate-jpa-annotations.html
 */
@Entity
@Table (name = "T_USER_NATH")
public class User {
	private long id;
	private String userLogin;
	private String password;
	private char[] userPassword;
	private String firstName;
	private String lastName;
	private String middleName;

	@Id
	@Column(name="USER_ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="USER_LOGIN")
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	
	@Column(name="USER_PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public char[] getUserPassword() {
		return getPassword().toCharArray();
	}
	public void setUserPassword(char[] userPassword) {
		setPassword(userPassword.toString());
	}
	@Column(name="USER_FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="USER_LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="USER_MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
}
