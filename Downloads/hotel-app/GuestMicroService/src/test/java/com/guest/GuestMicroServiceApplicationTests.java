package com.guest;

import com.guest.Exception.InvalidGuestException;
import com.guest.controller.GuestController;
import com.guest.models.Guest;
import com.guest.service.GuestService;
import com.guest.service.JwtService;
import com.guest.service.SequenceGeneratorservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class GuestMicroServiceApplicationTests {

	

	@Mock
    private GuestService guestService;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private SequenceGeneratorservice sequenceGeneratorservice;

    @InjectMocks
    private GuestController guestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	@Test
	void contextLoads() {
	}
	
	@Test
    void testGetAllUsers() throws InvalidGuestException {
        // Mock data
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        List<Guest> expectedGuests = Arrays.asList(guest1, guest2);

        // Mock service method
        when(guestService.getAllGuests()).thenReturn(expectedGuests);

        // Call the controller method
        List<Guest> actualGuests = guestController.getAllUsers();

        // Verify the result
        assertEquals(expectedGuests, actualGuests);
        verify(guestService, times(1)).getAllGuests();
    }
	
	@Test
    void testAddUser() throws InvalidGuestException {
        // Mock data
        Guest guest = new Guest();

        // Mock service method
        when(sequenceGeneratorservice.getSequenceNumber(any())).thenReturn(1);

        // Call the controller method
        String result = guestController.addUser(guest);

        // Verify the result
        assertEquals("Guest Added to Database", result);
        verify(guestService, times(1)).addGuest(guest);
    }
	
	@Test
    void testViewByEmailId() throws InvalidGuestException {
        // Mock data
        String emailId = "test@example.com";
        Guest expectedGuest = new Guest();

        // Mock service method
        when(guestService.viewByEmailId(emailId)).thenReturn(expectedGuest);

        // Call the controller method
        Guest actualGuest = guestController.viewByEmailId(emailId);

        // Verify the result
        assertEquals(expectedGuest, actualGuest);
        verify(guestService, times(1)).viewByEmailId(emailId);
    }
	
	@Test
    void testDeleteUser() throws InvalidGuestException {
        // Mock data
        int profileId = 1;
        String expectedResult = "Guest deleted successfully";

        // Mock service method
        when(guestService.deleteGuests(profileId)).thenReturn(expectedResult);

        // Call the controller method
        String actualResult = guestController.deleteUser(profileId);

        // Verify the result
        assertEquals(expectedResult, actualResult);
        verify(guestService, times(1)).deleteGuests(profileId);
    }
	
	@Test
    void testGetUserRole() {
        // Mock data
        String emailId = "test@example.com";
        String expectedRole = "ADMIN";

        // Mock service method
        when(guestService.getUserRole(emailId)).thenReturn(expectedRole);

        // Call the controller method
        String actualRole = guestController.getUserRole(emailId);

        // Verify the result
        assertEquals(expectedRole, actualRole);
        verify(guestService, times(1)).getUserRole(emailId);
    }
	

	
	@Test
    void testLoginUser_AuthenticationFailed() {
        // Mock data
        String emailId = "test@example.com";
        String password = "password";
        Guest guest = new Guest();
        guest.setGuestEmailId(emailId);
        guest.setGuestpassword(password);

        // Mock authentication exception
        AuthenticationException exception = mock(AuthenticationException.class);
        when(authenticationManager.authenticate(any())).thenThrow(exception);

        // Call the controller method
        ResponseEntity<String> response = guestController.loginUser(guest);

        // Verify the result
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Authentication failed: " + exception.getMessage(), response.getBody());
        verify(authenticationManager, times(1)).authenticate(any());
        verify(jwtService, times(0)).generateToken(any());
    }
}
