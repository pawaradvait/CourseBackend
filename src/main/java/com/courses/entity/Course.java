package com.courses.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="course_title")
	private String title;
	
	@Column(name="course_code")
	private String courseCode;
	
	@Column(length=300, name="course_description")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="course")
	@JsonIgnore
	private List<CourseInstance> courseInstance = new ArrayList<>();
}
