package com.myGarageHub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myGarageHub.entity.ServiceBooking;
import com.myGarageHub.repository.ServiceBookingRepository;

@RestController
@RequestMapping("/bookings")
public class ServiceBookingController {
    private final ServiceBookingRepository bookingRepo;

    public ServiceBookingController(ServiceBookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @PostMapping
    public ServiceBooking bookService(@RequestBody ServiceBooking booking) {
        booking.setStatus(ServiceBooking.BookingStatus.PENDING);
        return bookingRepo.save(booking);
    }

    @GetMapping
    public List<ServiceBooking> getAllBookings() {
        return bookingRepo.findAll();
    }
}
