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
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
>>>>>>> b00a2f7dd9957f4f2b2bb05bb210e757b1345829
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> search(@PathVariable int userID) {
        Optional <DCUser> user = null;
        Map<String, Object> response = new HashMap<>();

        try {
            user = userService.findById(userID);
        } catch (DataAccessException e) {
            response.put("ERROR", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (user.isPresent() == false){
            response.put("MESSAGE", "userID: ".concat(String.valueOf((userID)).concat(" DOESN'T EXIST.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
        return new ResponseEntity<Optional<DCUser>>(user, HttpStatus.OK);
<<<<<<< HEAD
}
    
    @DeleteMapping("/users/{userID}")
	public ResponseEntity<?> delete(@PathVariable int userID) {

		Map<String, Object> response = new HashMap<>();

		try {
			userService.delete(userID);
		} catch (DataAccessException e) {
			response.put("ERROR", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("MESSAGE","User: ".concat(String.valueOf((userID)).concat(" ELIMINATED WITH SUCCESS.")));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
=======
    }

    @PostMapping("/users")
    public ResponseEntity<?> addNewDCUser(@Validated @RequestBody DCUser dcUser){
        DCUser usernew = null;
        Map<String, Object> response = new HashMap<>();
        try{
            usernew = userService.save(dcUser);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }catch (DataAccessException e){
            response.put("ERROR", "User Already Exists");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

>>>>>>> b00a2f7dd9957f4f2b2bb05bb210e757b1345829


}
