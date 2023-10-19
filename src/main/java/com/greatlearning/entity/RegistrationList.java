package com.greatlearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registrationlist")
public class RegistrationList {
	@Id
	@Column(name = "studentid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;

	@NotEmpty(message = "First name field cannot be empty")
	@Column(name = "firstname")
	private String firstName;

	@NotEmpty(message = "Last name field cannot be empty")
	@Column(name = "lastname")
	private String lastName;

	@NotEmpty(message = "Course field cannot be empty")
	@Column(name = "course")
	private String course;

	@NotEmpty(message = "Country field cannot be empty")
	@Column(name = "country")
	private String country;

}
