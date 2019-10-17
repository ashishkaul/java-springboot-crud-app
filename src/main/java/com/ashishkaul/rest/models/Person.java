package com.ashishkaul.rest.models;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name ="persons")
@Component
public class Person{
	
	private long _id;
	@SerializedName("firstName")
	private String _firstName;
	@SerializedName("lastName")
	private String _lastName;
	@SerializedName("email")
	private String _email;
	
	public Person() {
		
	}
	public Person(String firstName, String lastName, String email) {
		this._firstName = firstName;
		this._lastName = lastName;
		this._email = email;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return this._id;
	}
	public void setId(long id) {
		this._id = id;
	}
	
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return this._firstName;
    }
    public void setFirstName(String firstName) {
        this._firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return this._lastName;
    }
    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmail() {
        return this._email;
    }
    public void setEmail(String email) {
        this._email = email;
    }
//	private String[] Hobbys;
//	private Address address;
//	private int age;
//	String profession;	
}
