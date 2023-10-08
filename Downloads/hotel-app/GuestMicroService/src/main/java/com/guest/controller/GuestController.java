package com.guest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guest.Exception.InvalidGuestException;
import com.guest.models.Guest;
import com.guest.service.GuestService;
import com.guest.service.JwtService;
import com.guest.service.SequenceGeneratorservice;

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/guests")
@RestController
public class GuestController {
	

	@Autowired
    GuestService serv;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authmanager;
    
    @Autowired
	private SequenceGeneratorservice sequenceGeneratorservice;

    @GetMapping("/getallusers")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Guest> getAllUsers() throws InvalidGuestException {
    	
        return serv.getAllGuests();
    }

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public String addUser(@RequestBody Guest guest) throws InvalidGuestException {
    	guest.setGuestId(sequenceGeneratorservice.getSequenceNumber(Guest.SEQUENCE_NAME));
         serv.addGuest(guest);
         return "Guest Added to Database";
    }



    @GetMapping("/viewByEmailId/{emailId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public Guest viewByEmailId(@PathVariable String emailId) throws InvalidGuestException {
        return serv.viewByEmailId(emailId);
    }

    @DeleteMapping("/deleteUser/{profileId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String deleteUser(@PathVariable int profileId) throws InvalidGuestException {
        return serv.deleteGuests(profileId);
    }
    
    @GetMapping("/role/{emailId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String getUserRole(@PathVariable("emailId") String emailId) {
        return serv.getUserRole(emailId);
    }
    
    @PostMapping("/login")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> loginUser(@RequestBody Guest guest) {
        String emailId = guest.getGuestEmailId();
        String password = guest.getGuestpassword();

        try {
            // Attempt authentication
            Authentication authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(emailId, password));

            // Authentication successful
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(emailId); // Pass UserDetails to include authority information

            // Return the JWT token in the response header
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Authorization", "Bearer " + token);
            return ResponseEntity.ok().headers(responseHeaders).body(token);
        } catch (AuthenticationException e) {
            // Authentication failed, handle the exception
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
    }
}
