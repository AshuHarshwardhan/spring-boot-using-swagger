package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.exception.runtime.UserNotFoundException;
import com.example.demo.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="userprofile", description="Operations pertaining to user profile in e-commerce application")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@ApiOperation(value = "Retrieve list of available users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping("/users")
	public ResponseEntity<List<User>> retrieveAllUsers() {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@ApiOperation(value = "Retrieve a user with an ID",response = User.class)
	@GetMapping("/users/{id}")
	public ResponseEntity<User> retrieveUser(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
	}

	@ApiOperation(value = "Create a user")
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update a user")
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User oldUser = userData.get();
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());
			oldUser.setUserName(user.getUserName());
			oldUser.setAge(user.getAge());
			oldUser.setEmail(user.getEmail());
			oldUser.setMarried(user.isMarried());
			
			return new ResponseEntity<>(userRepository.save(oldUser), HttpStatus.OK);
		} else {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
	}
	
	@ApiOperation(value = "Delete a user")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
	}
}
