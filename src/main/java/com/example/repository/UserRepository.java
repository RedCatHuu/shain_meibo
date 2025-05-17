package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	// nameで検索するためのカスタムメソッド 以下リファレンスリンク
	// https://spring.pleiades.io/spring-data/jpa/reference/jpa/query-methods.html
	List<User> findByNameContaining(String name);
}
