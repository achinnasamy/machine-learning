package com.dmac.entity.user;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	
	private int 			id;	 
	  
	private String 			uuid				=	"uuid";
	  
	private String 			username			=	"";
	  
	private String 			email				=	"";
	  
	private String 			cryptedPassword		=	"";
	  
	private String 			salt				=	"";
	
	private String			firstName			=	"";
	
	private String 			lastName			=	"";
	
	private Date			createdAt			=	null;
	
	private Date 			updatedAt			=	null;
	
	private String			userType			=	"U";
	
	private String			userGroup			=	"";
	
	private String 			active				=	"";
	
	private int				addedByUserID		=	0;
	
	private String			addressOne			=	"";
	
	private String			addressTwo			=	"";
	
	private String			city				=	"";
	
	private String			state				=	"";
	
	private String			country				=	"";
	
	private String			postalCode			=	"";
	
	private String			securityQuestion	=	"";
	
	private String			securityAnswer		=	"";
	
	private String			timeZone			=	"";
	
	private String			personalPhone		=	"";
	
	private String			workPhone			=	"";
	
	private String			personalFax			=	"";
	
	private String			workFax				=	"";
	
	private String			comments			=	"";
	
	
	

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "crypted_password")
	public String getCryptedPassword() {
		return cryptedPassword;
	}

	public void setCryptedPassword(String cryptedPassword) {
		this.cryptedPassword = cryptedPassword;
	}

	@Column(name = "salt")
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "updated_at")
	public Date getUpdatedAt() {
		return updatedAt;
	}

	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "user_type")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "user_group")
	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	@Column(name = "active")
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(name = "added_by_user_id")
	public int getAddedByUserID() {
		return addedByUserID;
	}

	public void setAddedByUserID(int addedByUserID) {
		this.addedByUserID = addedByUserID;
	}

	@Column(name = "address_one")
	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	@Column(name = "address_two")
	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "postalcode")
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "security_question")
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	@Column(name = "security_answer")
	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	@Column(name = "timezone")
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Column(name = "personal_phone")
	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	
	@Column(name = "work_phone")
	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@Column(name = "personal_fax")
	public String getPersonalFax() {
		return personalFax;
	}

	public void setPersonalFax(String personalFax) {
		this.personalFax = personalFax;
	}

	@Column(name = "work_fax")
	public String getWorkFax() {
		return workFax;
	}

	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}

	@Column(name = "comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	    
	  
	
	  
}
