package com.example.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.form.UserForm;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Controller
public class UserController {
	
	//インスタンスのインジェクション
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	
	//ホーム画面かつ社員一覧画面
	@GetMapping("/")
	public String getUsers(Model model) {
		
		//ユーザーを一括取得
		List<User> users = userRepository.findAll();
		
//		System.out.println(users);
		
		//取得したリストをテンプレートに渡す
		model.addAttribute("users", users);
		
		//テンプレート"users"を返す
		return "users";
	}
	
	// 社員登録画面
	@GetMapping("/new")
	public String post(Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		
		return "new";
	}
	
	// 社員登録処理画面
	@PostMapping("/new")
	// 新規userの情報がuserFormに渡される
	public String registerUser(UserForm userForm) {
		User user = new User();
		user.setId(userService.makeUserId());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		user.setBirthday(userForm.getBirthday());
		user.setGender(userForm.getGender());
		user.setCreatedate(userService.getLocalDate());
		
		// データベースに保存
		userRepository.save(user);
		
		return "/registered";
//		return "redirect:/users";
		
		
	}
	
	// 社員登録完了後画面
	@GetMapping("/registered")
	public String registerd() {
		return "registered";
		
	}
	
	
}
