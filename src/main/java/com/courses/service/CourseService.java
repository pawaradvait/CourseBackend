package com.courses.service;

import java.util.List;

import com.courses.entity.Course;

public interface CourseService {
 
	void addCourse(Course course);
	List<Course> getAllCourses();
	Course getCourseById(Long id);
	Course deleteCourseById(Long id);
}
