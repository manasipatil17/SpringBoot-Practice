package com.myGarageHub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myGarageHub.entity.ServiceBooking;
import com.myGarageHub.repository.ServiceBookingRepository;

@Service
public class ServiceBookingService {
	private final ServiceBookingRepository bookingRepo;

    public ServiceBookingService(ServiceBookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public ServiceBooking bookService(ServiceBooking booking) {
        booking.setStatus(ServiceBooking.BookingStatus.PENDING);
        return bookingRepo.save(booking);
    }

    public List<ServiceBooking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public ServiceBooking updateBookingStatus(Long id, ServiceBooking.BookingStatus status) {
        ServiceBooking booking = bookingRepo.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatus(status);
            return bookingRepo.save(booking);
        }
        return null;
    }
}
