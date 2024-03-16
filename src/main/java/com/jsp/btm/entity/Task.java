package com.jsp.btm.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	private String taskDescription;
	private String status;
	private LocalDateTime createdDateTime;
	private LocalDateTime completedDateTime;
	
	@ManyToOne
	private User user;
}
