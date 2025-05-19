package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	// nameで検索するためのカスタムメソッド 以下リファレンスリンク
	// https://spring.pleiades.io/spring-data/jpa/reference/jpa/query-methods.html
	List<User> findByNameContaining(String name);
	
	// アクティブな社員一覧を取得
	// update_dateの"_"がスペースと認識されるため、
	// findByUpdate_dateNullではなく、クエリを書かないといけない
	@Query("SELECT u FROM User u WHERE u.update_date IS NULL")
	List<User> allEmp();
	
	
}
