package com.company.services.web.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "email", unique = true)
	private String email;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Past
	@Column(name = "birthdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "employee_hobby",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "hobby_id") })
    private Set<Hobby> hobbies = new HashSet<>();

	public Employee() {}
	
	public Employee(Long id, @NotNull String email, @NotNull String name, @NotNull @Past Date birthDate,
			Set<Hobby> hobbies) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birthDate = birthDate;
		this.hobbies = hobbies;
	}

	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Set<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ","
				+ " name=" + name + ", birthDate=" + birthDate + ","
				+ " hobbies=" + hobbies + "]";
	}
	
	
	
	
}
