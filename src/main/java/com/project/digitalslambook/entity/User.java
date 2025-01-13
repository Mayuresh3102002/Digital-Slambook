package com.project.digitalslambook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String name;
	private int age;
	private long mobile;
	
	@Column(length = 1000)
	private String ambition;
	
	@Column(length = 1000)
	private String about;
	
	@Column(length = 1000)
	private String apprating;

	@Override
	public int compareTo(User o) {
		if(this.age > o.age) {
			return 1;
		} else if(this.age < o.age){
			return -1;
		} else {
			return 0;
		}
	}

}
