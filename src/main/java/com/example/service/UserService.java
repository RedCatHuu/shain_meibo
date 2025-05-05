package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	// インスタンスのインジェクション
	@Autowired
	private UserRepository userRepository;
	
	public String makeUserId() {
		List<User> users = userRepository.findAll();
		String result = "";
		String id = Integer.toString(users.size() + 1);
		
		result += LocalDate.now().getYear();
		return result;
		
	}
	

}
