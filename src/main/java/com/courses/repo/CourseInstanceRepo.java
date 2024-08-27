package com.courses.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.courses.entity.Course;
import com.courses.entity.CourseInstance;

import jakarta.transaction.Transactional;

public interface CourseInstanceRepo extends JpaRepository<CourseInstance, Long>{

	@Query("select c.course from CourseInstance c  where c.year =:year and c.delivery =:id")
	List<Course> getCoursesByInstanceYearAndId(int year,Long id);


    @Modifying
    @Transactional
	   @Query("DELETE from CourseInstance c where c.course.id = :courseId AND c.year = :year AND c.delivery = :delivery")
	   	int deleteInstanceByCourseIdyearAnddelivery(Long courseId,int year,int delivery);

 @Query("select c from CourseInstance c where c.course.id = :cid and c.year = :year and c.delivery = :delivery")
    List<CourseInstance> getCourseInstanceByCidYearDelivery(Long cid,int year,int delivery);
  
    
 
}
	