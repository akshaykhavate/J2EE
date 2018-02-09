package com.akshay.app.regpage;

public class User {
	private int Id;
	private String Name;
	private String Phone;
	private String Email;
	private String Gender;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public String setName(String name) {
		return Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public String setPhone(String phone) {
		return Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public String setEmail(String email) {
		return Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public String setGender(String gender) {
		return Gender = gender;
	}

	@Override
	public String toString() {
		return "User [Email=" + Email + ", Gender=" + Gender + ", Id=" + Id + ", Name=" + Name + ", Phone=" + Phone
				+ "]";
	}
	
}
