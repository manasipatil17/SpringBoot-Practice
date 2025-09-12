package com.myGarageHub.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServiceBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate bookingDate;
	 @Enumerated(EnumType.STRING)
	    private BookingStatus status;

	    @ManyToOne
	    @JoinColumn(name = "vehicle_id")
	    private Vehicle vehicle;

	    public enum BookingStatus {
	        PENDING, IN_PROGRESS, COMPLETED
	    }

		public ServiceBooking() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ServiceBooking(long id, LocalDate bookingDate, BookingStatus status, Vehicle vehicle) {
			super();
			this.id = id;
			this.bookingDate = bookingDate;
			this.status = status;
			this.vehicle = vehicle;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public LocalDate getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDate bookingDate) {
			this.bookingDate = bookingDate;
		}

		public BookingStatus getStatus() {
			return status;
		}

		public void setStatus(BookingStatus status) {
			this.status = status;
		}

		public Vehicle getVehicle() {
			return vehicle;
		}

		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}

		@Override
		public String toString() {
			return "ServiceBooking [id=" + id + ", bookingDate=" + bookingDate + ", status=" + status + ", vehicle="
					+ vehicle + "]";
		}

}
