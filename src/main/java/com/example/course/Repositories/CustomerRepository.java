package com.example.course.Repositories;

import com.example.course.Models.Course;
import com.example.course.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

    List<Customer> findByBookingsIgnoreCaseCourseName(String courseName);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);

    List<Customer> findByAgeAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String town, String courseName);
}
