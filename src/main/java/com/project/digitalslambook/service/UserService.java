package com.project.digitalslambook.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalslambook.entity.User;
import com.project.digitalslambook.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public List<User> addAllUsers(List<User> u) {
		return userRepository.saveAll(u);
	}

	public List<User> sortUserByAge(int sortby) {
		List<User> users = userRepository.findAll();
		Collections.sort(users);
		if(sortby == 1) {
			Collections.reverse(users);
		} 
		return users;
	}

}
