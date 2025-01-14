package com.project.digitalslambook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalslambook.entity.User;
import com.project.digitalslambook.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/addusers")
	protected User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PostMapping(path = "addallusers")
	protected List<User> addAllUsers(@RequestBody List<User> u) {
		return userService.addAllUsers(u);
	}

	@GetMapping(path = "/findusers")
	protected List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping(path = "/findusers/sort/{sortby}")
	protected List<User> sortUserByAge(@PathVariable int sortby) {
		return userService.sortUserByAge(sortby);
	}

	@DeleteMapping(path = "/deleteuser")
	protected String deleteUser(@RequestParam int id) {
		User deleteUser = userService.deleteUser(id);
		if (deleteUser != null)
			return "User is deleted";
		else
			return "user not found";

	}

	@PutMapping(path = "/updateuser")
	protected User updateUser(@RequestBody User user, @RequestParam int id) {
		return userService.updatedUser(user, id);
	}
}
