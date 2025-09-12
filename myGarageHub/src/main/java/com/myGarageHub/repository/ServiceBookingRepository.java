package com.myGarageHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myGarageHub.entity.ServiceBooking;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long>{

}
