package com.project.digitalslambook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.digitalslambook.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
