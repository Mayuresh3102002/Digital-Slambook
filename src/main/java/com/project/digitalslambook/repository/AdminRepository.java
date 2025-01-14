package com.project.digitalslambook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.digitalslambook.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	List<Admin> findByAge(int byage);
	
	Admin findById(int adminid);
	
}
