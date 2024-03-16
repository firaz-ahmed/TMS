package com.jsp.btm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.btm.entity.User;
import com.jsp.btm.exception.InvalidVersionException;
import com.jsp.btm.service.UserService;
import com.jsp.btm.util.ResponseStructure;

@RestController
@RequestMapping("/api/version/{version}/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@PathVariable String version, @RequestBody User user, @RequestParam int managerId) {
		if(version.equals("1.0.0")) {
			return userService.saveUser(user, managerId);
		}
		throw new InvalidVersionException("Provide a valid version");
	}
	
	@PostMapping("/createManager")
	public ResponseEntity<ResponseStructure<Object>> createManager(@PathVariable String version) {
		if(version.equals("1.0.0")) {
			return userService.saveManager();
		}
		throw new InvalidVersionException("Provide a valid version");
	}
}
