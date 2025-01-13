package com.project.digitalslambook.service;

import java.util.List;
import java.util.Optional;

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

	public Admin updateAdmin(Admin admin) {
		admin.setName(admin.getName());
		admin.setMobile(admin.getMobile());
		admin.setAbout(admin.getAbout());
		admin.setAge(admin.getAge());
		admin.setAmbition(admin.getAmbition());
		admin.setApprating(admin.getApprating());
		
		return adminRepository.save(admin);
	}

	public Admin deleteAdmin(int id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin != null) {
			adminRepository.deleteById(id);
		}
		return null;
	}

}
