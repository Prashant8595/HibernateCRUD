package com.crud.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int age;

    private String name;
    private String email;
    private String degignation;
	public Employee(int id, int age, String name, String email, String degignation) {
		
		this.id = id;
		this.age = age;
		this.name = name;
		this.email = email;
		this.degignation = degignation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegignation() {
		return degignation;
	}
	public void setDegignation(String degignation) {
		this.degignation = degignation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + ", email=" + email + ", degignation="
				+ degignation + "]";
	}
	public Employee() {
		super();
	}
    
	

}
