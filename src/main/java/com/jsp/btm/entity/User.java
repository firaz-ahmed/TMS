package com.jsp.btm.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {
	
	public User() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	private String userEmail;
	private String userPassword;
	private long userPhoneNumber;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	private Role role;
	
	@OneToMany
	private List<Task> tasks;
}
