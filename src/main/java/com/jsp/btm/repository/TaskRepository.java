package com.jsp.btm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.btm.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
