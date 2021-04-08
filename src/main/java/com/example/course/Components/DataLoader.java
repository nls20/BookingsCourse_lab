package com.example.course.Components;

import com.example.course.Models.Booking;
import com.example.course.Models.Course;
import com.example.course.Models.Customer;
import com.example.course.Repositories.BookingRepository;
import com.example.course.Repositories.CourseRepository;
import com.example.course.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Course python = new Course("Python", "Edinburgh", 3);
        Course javascript = new Course("Javascript", "Glasgow", 5);
        Course java = new Course("Java", "Stirling", 4);
        courseRepository.save(python);
        courseRepository.save(java);
        courseRepository.save(javascript);

        Customer nicola = new Customer("Nicola", "Edinburgh", 21);
        Customer andrew = new Customer("Andrew", "Stirling", 29);
        customerRepository.save(nicola);
        customerRepository.save(andrew);

        Booking pythonBooking = new Booking("8/4/2021", python, nicola);
        Booking javaBooking = new Booking("2/4/2021", java, andrew);
        Booking javascriptBooking = new Booking("3/7/2021", javascript, andrew);
        bookingRepository.save(pythonBooking);
        bookingRepository.save(javaBooking);
        bookingRepository.save(javascriptBooking);
    }
}
