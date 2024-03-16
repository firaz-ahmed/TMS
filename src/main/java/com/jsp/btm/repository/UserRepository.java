package com.jsp.btm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.btm.entity.Role;
import com.jsp.btm.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByUserEmail(String userEmail);
	
	@Query("select u from User u where u.role=?1")
	List<User> findAll(Role employee);
	
	User findUserByEmailAndPassword(String userEmail, String userPassword);
	
	@Query("SELECT u FROM User u WHERE u.role = 1?")
	Optional<User> findUserByRole(Role manager);
}
