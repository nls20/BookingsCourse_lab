package com.example.course.Repositories;

import com.example.course.Models.Booking;
import com.example.course.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking>findByDate (String date);
}
