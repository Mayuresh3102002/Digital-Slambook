package com.project.digitalslambook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalslambook.entity.Admin;
import com.project.digitalslambook.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> findAllAdmins() {
		return adminRepository.findAll();
	}

}
