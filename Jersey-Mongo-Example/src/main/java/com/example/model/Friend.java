package com.example.model;

import org.bson.types.ObjectId;

public class Friend {
	
	private ObjectId  id;
	private String firstName;
	private String lastName;
	
	public Friend() {}

	public Friend(ObjectId id, String firstName, String lastName) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Friend(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	@Override
	public String toString() {
		return "Friend [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
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
}
