package com.example.course.Controllers;

import com.example.course.Models.Course;
import com.example.course.Models.Customer;
import com.example.course.Repositories.CourseRepository;
import com.example.course.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (courseName != null && age != null && town != null) {
            return new ResponseEntity<>(customerRepository.findByAgeAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, courseName), HttpStatus.OK);
        }
        if (courseName != null && town != null) {
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsIgnoreCaseCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}

