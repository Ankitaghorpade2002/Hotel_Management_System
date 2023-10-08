package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.models.Booking;
import com.booking.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	

	public void addBooking(Booking booking) {
		bookingRepository.insert(booking);
	}

	public List<Booking> getAllBookings() {
		List<Booking> list1 = new ArrayList<>();
		list1=bookingRepository.findAll();
		return list1;
	}

	public void updateBooking(Booking booking, int bookingId) {
		bookingRepository.save(booking);
	}

	public void deleteBooking(int bookingId) {
		bookingRepository.deleteById(bookingId);
	}

	public Optional<Booking> getBookingById(int bookingId) {
		return bookingRepository.findById(bookingId);
	}
}
