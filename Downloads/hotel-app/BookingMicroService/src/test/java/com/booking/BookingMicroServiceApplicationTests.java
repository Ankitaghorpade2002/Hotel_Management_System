package com.booking;

import org.springframework.boot.test.context.SpringBootTest;
import com.booking.controller.BookingController;
import com.booking.models.Booking;
import com.booking.service.BookingService;
import com.booking.service.SequenceGeneratorservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class BookingMicroServiceApplicationTests {
	
	@Mock
    private BookingService bookingService;

    @Mock
    private SequenceGeneratorservice sequenceGeneratorservice;

    @InjectMocks
    private BookingController bookingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void addBooking_ValidBooking_ReturnsCreatedStatus() {
        Booking booking = new Booking();
        booking.setBookingId(1);
        when(sequenceGeneratorservice.getSequenceNumber(anyString())).thenReturn(1);
        doNothing().when(bookingService).addBooking(booking);

        ResponseEntity<Void> response = bookingController.addBooking(booking);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(sequenceGeneratorservice, times(1)).getSequenceNumber(anyString());
        verify(bookingService, times(1)).addBooking(booking);
    }

    @Test
    void updateBooking_ValidBookingAndId_ReturnsAcceptedStatus() {
        Booking booking = new Booking();
        int bookingId = 1;
        doNothing().when(bookingService).updateBooking(booking, bookingId);

        ResponseEntity<Void> response = bookingController.updateBooking(booking, bookingId);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(bookingService, times(1)).updateBooking(booking, bookingId);
    }
    
    @Test
    void deleteBooking_ValidId_ReturnsNoContentStatus() {
        int bookingId = 1;
        doNothing().when(bookingService).deleteBooking(bookingId);

        ResponseEntity<Void> response = bookingController.deleteBooking(bookingId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(bookingService, times(1)).deleteBooking(bookingId);
    }
    
    @Test
    void getAllBookings_BookingsExist_ReturnsListOfBookings() {
        Booking booking1 = new Booking();
        booking1.setBookingId(1);
        Booking booking2 = new Booking();
        booking2.setBookingId(2);
        List<Booking> bookingList = Arrays.asList(booking1, booking2);
        when(bookingService.getAllBookings()).thenReturn(bookingList);

        ResponseEntity<List<Booking>> response = bookingController.getAllBookings();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookingList, response.getBody());
        verify(bookingService, times(1)).getAllBookings();
    }
    
//    @Test
//    void getAllBookings_NoBookingsExist_ReturnsNotFoundStatus() {
//        when(bookingService.getAllBookings()).thenReturn(Arrays.asList());
//
//        ResponseEntity<List<Booking>> response = bookingController.getAllBookings();
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals(0, response.getBody().size());
//        verify(bookingService, times(1)).getAllBookings();
//    }

    @Test
    void getBookingById_ValidId_ReturnsBooking() {
        int bookingId = 1;
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        Optional<Booking> bookingOptional = Optional.of(booking);
        when(bookingService.getBookingById(bookingId)).thenReturn(bookingOptional);
    }
}
	
