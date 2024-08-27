package com.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.courses.entity.CourseInstance;
import com.courses.service.CourseInstanceServiceImpl;

@RestController
@RequestMapping("/api/instance")
@CrossOrigin("*")
public class CourseInstanceController {

	@Autowired
	private CourseInstanceServiceImpl courseInstanceServiceImpl;

	
	@PostMapping("/")
	public ResponseEntity<?> addCourseInstance(@RequestBody CourseInstance courseInstance){
		this.courseInstanceServiceImpl.addCourseInstance(courseInstance);
		return  ResponseEntity.ok("saved successfully courseinstance");
	}
	
	@GetMapping("/")
	public ResponseEntity<?>  getAllCourseInstance(){
		return ResponseEntity.ok(this.courseInstanceServiceImpl.getAllCourseInstance());
	}
	
@GetMapping("/{year}/{id}")
	public ResponseEntity<?> getCourseByInstanceYearandId(@PathVariable int year, @PathVariable Long id){
		
		return ResponseEntity.ok(this.courseInstanceServiceImpl.getCoursesByInstanceYearandId(year, id));
	}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteInstanceOne(@PathVariable Long id){
	
	CourseInstance ci = this.courseInstanceServiceImpl.deleteInstanceById(id);
	if(ci !=null) {
		return ResponseEntity.ok("successfully deleted");
	}else {
		return new ResponseEntity<>("can't find id",HttpStatus.NOT_FOUND);
	}
}


@DeleteMapping("/{year}/{delivery}/{courseid}")
public ResponseEntity<?> deleteInstanceBycIDYearDelivery(@PathVariable int year,@PathVariable int delivery,@PathVariable Long courseid){
	int i = this.courseInstanceServiceImpl.deleteInstanceByCourseIdyearAnddelivery(courseid, year, delivery);
	return ResponseEntity.ok("deleted.."+i);
	
}

@GetMapping("/{year}/{delivery}/{cid}")
public ResponseEntity<?> getInstanceByCIdYearDelivery(@PathVariable Long cid,@PathVariable int year,@PathVariable int delivery){
	
	return ResponseEntity.ok(this.courseInstanceServiceImpl.getCourseInstanceByCidYearDelivery(cid, year, delivery));
}
 
}
