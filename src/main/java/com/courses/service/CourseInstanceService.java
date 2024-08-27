package com.courses.service;

import java.util.List;

import com.courses.entity.Course;
import com.courses.entity.CourseInstance;

public interface CourseInstanceService {

	void addCourseInstance(CourseInstance courseInstance);
	List<CourseInstance> getAllCourseInstance();
   List<Course>  getCoursesByInstanceYearandId(int year,Long id);
    CourseInstance deleteInstanceById(Long id);
    int deleteInstanceByCourseIdyearAnddelivery(Long cid,int year,int delivery);
 List<CourseInstance> getCourseInstanceByCidYearDelivery(Long cid,int year,int delivery);
}
