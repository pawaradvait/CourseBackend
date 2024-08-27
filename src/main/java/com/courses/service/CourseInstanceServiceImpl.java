package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.entity.Course;
import com.courses.entity.CourseInstance;
import com.courses.repo.CourseInstanceRepo;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService{
 
	@Autowired
	private CourseInstanceRepo courseInstanceRepo;
 
	@Override
	public void addCourseInstance(CourseInstance courseInstance) {
 
		this.courseInstanceRepo.save(courseInstance);
		
	}

	@Override
	public List<CourseInstance> getAllCourseInstance() {
		// TODO Auto-generated method stub
		return this.courseInstanceRepo.findAll();
	}

	@Override
	public List<Course> getCoursesByInstanceYearandId(int year, Long id) {
		 
		
		
		return this.courseInstanceRepo.getCoursesByInstanceYearAndId(year, id);
	}

	@Override
	public CourseInstance deleteInstanceById(Long id) {
		CourseInstance  ci = this.courseInstanceRepo.findById(id).get();
		if(ci !=null) {
		this.courseInstanceRepo.deleteById(id);
		return ci;
		}
		return null; 
		
	}

	@Override
	public int deleteInstanceByCourseIdyearAnddelivery(Long cid, int year, int delivery) {
		// TODO Auto-generated method stub
		return this.courseInstanceRepo.deleteInstanceByCourseIdyearAnddelivery(cid, year, delivery);
	}

	@Override
	public List<CourseInstance> getCourseInstanceByCidYearDelivery(Long cid, int year, int delivery) {
		
		return this.courseInstanceRepo.getCourseInstanceByCidYearDelivery(cid, year, delivery);
	}
	
	

}
