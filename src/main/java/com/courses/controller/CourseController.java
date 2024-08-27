package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.entity.Course;
import com.courses.service.CourseServiceImpl;


@RestController
@RequestMapping("/api/course")
@CrossOrigin("*")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseService;

	@PostMapping("/")
	public ResponseEntity<?>  addCourse(@RequestBody Course course){
		this.courseService.addCourse(course);
		
		return ResponseEntity.ok("successfully added  course");
	}
	
	@GetMapping("/")
	public ResponseEntity<?>  getAllCourse(){
		List<Course> courses = this.courseService.getAllCourses();
		return ResponseEntity.ok(courses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id){
	return ResponseEntity.ok(this.courseService.getCourseById(id));
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteCourseById(@PathVariable Long id){
 
		Course course = this.courseService.deleteCourseById(id);
		if(course !=null) {
			return ResponseEntity.ok(course);
		}else {
			return new ResponseEntity<>("cannot find id",HttpStatus.NOT_FOUND);

		}
	}
 
}

