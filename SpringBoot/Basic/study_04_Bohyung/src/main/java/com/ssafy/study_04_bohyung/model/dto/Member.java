package com.ssafy.study_04_bohyung.model.dto;

public class Member {
	private int id;
	private String name;
	private String jumin;
	private int age;
	private String phone;
	private String address;
	private String profile_image;
	
	public Member() {
		
	}

	public Member(String name, String jumin, int age, String phone) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.age = age;
		this.phone = phone;
	}

	public Member(String name, String jumin, int age, String phone, String address, String profile_image) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.profile_image = profile_image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", jumin=" + jumin + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + ", profile_image=" + profile_image + "]";
	}
	
	
	
	
}
