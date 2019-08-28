package com.example.model;

public class Model {

	private String _id;
	private String firstName;
	private String lastName;
	
	public Model() {}

	public Model(String id, String firstName, String lastName) {
		_id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Model [Id=" + _id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		_id = id;
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
