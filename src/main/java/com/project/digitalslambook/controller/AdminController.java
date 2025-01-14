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
	
	@GetMapping(path = "/findadmins/{byage}")
	protected List<Admin> findAdminByAge(@PathVariable int byage) {
		 List<Admin> admins = adminService.findAdminByAge(byage);
		 if(admins != null) {
			 return admins;
		 } 
		 return null;
	}
	
	@PutMapping(path = "/updateadmin")
	protected Admin updateAdmin(@RequestBody Admin admin, @RequestParam int id) {
	    return adminService.updateAdmin(admin, id);
	}
	
	@DeleteMapping(path = "/deleteadmin")
	protected String deleteAdmin(@RequestParam int id) {
		Admin deletedAdmin = adminService.deleteAdmin(id);
		if(deletedAdmin != null) {
			return "Admin is deleted!!";
		} else {
			return "Invalid admin id";
		}
	}

}
