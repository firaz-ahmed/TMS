package com.jsp.btm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.btm.dao.TaskDao;
import com.jsp.btm.dao.UserDao;
import com.jsp.btm.entity.Role;
import com.jsp.btm.entity.Task;
import com.jsp.btm.entity.User;
import com.jsp.btm.exception.TaskNotAssignedException;
import com.jsp.btm.exception.TaskNotFoundException;
import com.jsp.btm.exception.UserNotFoundException;
import com.jsp.btm.util.ResponseStructure;

@Service
public class TaskService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private TaskDao taskDao;

	public ResponseEntity<ResponseStructure<Task>> saveTask(int userId, Task task) {
		Optional<User> optional = userDao.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			if (user.getRole() == Role.EMPLOYEE) {
				if (user.getTasks() == null) {
					List<Task> tasks = new ArrayList<>();
					user.setTasks(tasks);
				}
				task.setUser(user);
				Task savedTask = taskDao.saveTask(task);
				user.getTasks().add(savedTask);
				userDao.saveUser(user);

//				List<Task> tasks = user.getTasks();
//				tasks.add(savedTask);
//				user.setTasks(tasks);
//				userDao.saveUser(user);
				
				ResponseStructure<Task> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("Created");
				responseStructure.setData(savedTask);
				
				return new ResponseEntity<ResponseStructure<Task>>(responseStructure, HttpStatus.CREATED);
			}
			throw new TaskNotAssignedException("User designation is not an employee");
		}
		throw new UserNotFoundException("User with the given UserId " + userId + " is not found");
	}

	public ResponseEntity<ResponseStructure<Task>> updateTask(int taskId, Task task) {
		Optional<Task> optional = taskDao.findById(taskId);
		if(optional.isPresent()) {
			task.setTaskId(taskId);
			Task modifiedTask = taskDao.saveTask(task);
			ResponseStructure<Task> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Modified");
			responseStructure.setData(modifiedTask);
			
			return new ResponseEntity<ResponseStructure<Task>>(responseStructure, HttpStatus.OK);
		}
		throw new TaskNotFoundException("Task with the given TaskId " +taskId+ " is not found");
	}

	public ResponseEntity<ResponseStructure<Task>> findTaskById(int taskId) {
		Optional<Task> optional = taskDao.findById(taskId);
		if (optional.isPresent()) {
			ResponseStructure<Task> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Task>>(responseStructure, HttpStatus.OK);
		}
		throw new TaskNotFoundException("Task with the given TaskId " + taskId + " is not found");
	}

	public ResponseEntity<ResponseStructure<List<Task>>> findAll() {
		ResponseStructure<List<Task>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(taskDao.findAll());
		
		return new ResponseEntity<ResponseStructure<List<Task>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Task>>> findAllByEmployeeId(int employeeId) {
		Optional<User> optional = userDao.findById(employeeId);
		if (optional.isPresent()) {
			ResponseStructure<List<Task>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(optional.get().getTasks());
			
			return new ResponseEntity<ResponseStructure<List<Task>>>(responseStructure, HttpStatus.OK);
		}
		throw new UserNotFoundException("User withe the given EmployeeId = " + employeeId + " is not found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteTaskById(int taskId) {
		Optional<Task> optional = taskDao.findById(taskId);
		if (optional.isPresent()) {
			taskDao.deleteTask(optional.get());
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Removed");
			responseStructure.setData("Removed");
			
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		throw new TaskNotFoundException("Task with the given TaskId " + taskId + " is not found");
	}
}
