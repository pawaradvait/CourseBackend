package com.courses.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.courses.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

	
	@Query("select c from Course c where c.id =:id")
	Course findCourseById(Long id);
	
	
	
}
