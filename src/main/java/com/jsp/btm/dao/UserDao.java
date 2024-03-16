package com.jsp.btm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.btm.entity.Role;
import com.jsp.btm.entity.User;
import com.jsp.btm.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findById(int userId) {
		return userRepository.findById(userId);
	}
	
	public List<User> findAllEmployee(Role role) {
		return userRepository.findAll(role);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findByEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}
	
	public User findByEmailAndPassword(String userEmail, String userPassword) {
		return userRepository.findUserByEmailAndPassword(userEmail, userPassword);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public Optional<User> findUserByRole(Role manager) {
		return userRepository.findUserByRole(manager);
	}
}
