package com.example.course.Repositories;

import com.example.course.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(int rating);

    List<Course> findByBookingsCustomerName(String name);
}
