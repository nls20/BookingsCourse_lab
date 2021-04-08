package com.example.course;

import com.example.course.Models.Booking;
import com.example.course.Models.Course;
import com.example.course.Models.Customer;
import com.example.course.Repositories.BookingRepository;
import com.example.course.Repositories.CourseRepository;
import com.example.course.Repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void setUp () {
		Course python = new Course("Python", "Edinburgh", 3);
		Course javascript = new Course("Javascript", "Glasgow", 5);
		Course java = new Course("Java", "Stirling", 4);

		Customer nicola = new Customer("Nicola", "Edinburgh", 21);
		Customer andrew = new Customer("Andrew", "Stirling", 29);

		Booking pythonBooking = new Booking("8/4/2021", python, nicola);
		Booking javaBooking = new Booking("2/4/2021", java, andrew);
		Booking javascriptBooking = new Booking("3/7/2021", javascript, andrew);

	}

	@Test public void canFindCourseByRating() {
		assertEquals(1, courseRepository.findByRating(5).size());
	}

	@Test public void canFindAllBookingsCustomerName() {
		assertEquals(1, courseRepository.findByBookingsCustomerName("Nicola").size());
	}

	@Test public void canFindByBookingsCourseName(){
		assertEquals(1, customerRepository.findByBookingsIgnoreCaseCourseName("Python").size());
	}

	@Test public void canFindBookingsByDate () {
		assertEquals(1, bookingRepository.findByDate("8/4/2021").size());
	}

	@Test public void canFindCustomerByTownAndCourseName () {
		assertEquals(1, customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Edinburgh", "Python").size());
	}

	@Test public void canFindCustomerByTownAndCourseNameAndAge () {
		assertEquals(1, customerRepository.findByAgeAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(21, "Edinburgh", "Python").size());
	}

}
