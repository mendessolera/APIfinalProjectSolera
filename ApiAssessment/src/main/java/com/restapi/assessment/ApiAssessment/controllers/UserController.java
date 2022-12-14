package com.restapi.assessment.ApiAssessment.controllers;

import com.restapi.assessment.ApiAssessment.models.DCUser;
import com.restapi.assessment.ApiAssessment.services.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<DCUser> listOfUsers() {
		return userService.findAll();
	}

	@GetMapping("/users/{userID}")
	public ResponseEntity<?> searchSpecificUser(@PathVariable int userID) {
		Optional<DCUser> user = null;
		Map<String, Object> response = new HashMap<>();

		try {
			user = userService.findById(userID);
		} catch (DataAccessException e) {
			response.put("ERROR", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (user.isPresent() == false) {
			response.put("MESSAGE", "userID: ".concat(String.valueOf((userID)).concat(" DOESN'T EXIST.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<DCUser>>(user, HttpStatus.OK);

	}

	@PostMapping("/users")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> addNewDCUser(@Validated @RequestBody DCUser dcUser) {
		Map<String, Object> response = new HashMap<>();
		try {
			userService.save(dcUser);
			response.put("MESSAGE", "USER SUCCESSFULLY CREATED");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("ERROR", "USER WITH THAT EMAIL ALREADY EXISTS");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/users/{userID}")
	public ResponseEntity<?> deleteSpecificUser(@PathVariable int userID) {

		Map<String, Object> response = new HashMap<>();

		try {
			userService.delete(userID);
		} catch (DataAccessException e) {
			response.put("ERROR", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("MESSAGE", "User: ".concat(String.valueOf((userID)).concat(" ELIMINATED WITH SUCCESS.")));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
