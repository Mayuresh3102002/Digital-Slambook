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

	public List<Admin> findAdminByAge(int byage) {
		return adminRepository.findByAge(byage);
	}

	public Admin updateAdmin(Admin adminDetails, int id) {
	    Admin existingAdmin = findAdminById(id);
	    if (existingAdmin != null) {
	        existingAdmin.setName(adminDetails.getName());
	        existingAdmin.setAge(adminDetails.getAge());
	        existingAdmin.setMobile(adminDetails.getMobile());
	        existingAdmin.setAbout(adminDetails.getAbout());
	        existingAdmin.setAmbition(adminDetails.getAmbition());
	        existingAdmin.setApprating(adminDetails.getApprating());
	        return adminRepository.save(existingAdmin);
	    }
	    return null; 
	}

	public Admin deleteAdmin(int id) {
		Admin admin = adminRepository.findById(id);
		if(admin != null) {
			adminRepository.delete(admin);
		} 
		return admin;
	}

	public Admin findAdminById(int adminId) {
		Admin admin =  adminRepository.findById(adminId);
		if(admin != null)
			return admin;
		else
			return null;
	}

}
