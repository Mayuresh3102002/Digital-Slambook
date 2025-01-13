package com.project.digitalslambook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalslambook.entity.Admin;
import com.project.digitalslambook.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/adddetails")
	protected Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@GetMapping(path = "/findadmins")
	protected Object findAllAdmins() {
		List<Admin> admins = adminService.findAllAdmins();
		if(admins != null) {
			return admins;
		} else {
			return "User not found!";
		}
	}

}
