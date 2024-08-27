package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.entity.Course;
import com.courses.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public void addCourse(Course course) {
   this.courseRepo.save(course);
		
	}

	@Override
	public List<Course> getAllCourses() {
		return this.courseRepo.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		// TODO Auto-generated method stub
		Course course = this.courseRepo.findCourseById(id);
		return course;
	}

	@Override
	public Course deleteCourseById(Long id) {
		Course course = this.courseRepo.findCourseById(id);

if(course !=null) {
	this.courseRepo.deleteById(id);
	return course;
}
		
		
		return null;
	}

}
