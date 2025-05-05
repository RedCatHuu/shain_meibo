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
	
	//　社員ID生成機能
	public String makeUserId() {
		
		// 変数初期化
		String result = "";
		String id = "";
		
		// T_SYAINテーブルのレコードを全件取得し、その数に1を足す。
		List<User> users = userRepository.findAll();		
		id = Integer.toString(users.size() + 1);
		
		// idが3桁以外の場合、左に0を詰める
		if(id.length() == 1) {
			id = "00" + id;
		}else if(id.length() == 2) {
			id = "0" + id;
		}
		
		result += LocalDate.now().getYear() + id;
		return result;
		
	}
	
	// 日付取得機能
	public LocalDate getLocalDate() {
		return LocalDate.now();
	}
	

}
