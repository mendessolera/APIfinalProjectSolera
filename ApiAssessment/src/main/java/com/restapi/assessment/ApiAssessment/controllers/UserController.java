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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            response.put("MESSAGE", "userID: ".concat(String.valueOf((userID)).concat(" doesn't exist.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
        return new ResponseEntity<Optional<DCUser>>(user, HttpStatus.OK);
}


}
