package com.example.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	// ログイン画面
	@GetMapping("/login")
	public String login(Model model) {
		
		UserForm form = new UserForm();
		model.addAttribute("form", form);
		
		return "login";		
	}
	
	// ログイン機能
	@PostMapping("/login")
	public String authenticate(UserForm form) {
		
		boolean authenticated = userService.authenticate(form.getId(), form.getPassword());
		if(authenticated) {
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}
	
	// 社員一覧画面
	@GetMapping("/")
	public String getUsers(Model model) {
		
		//ユーザーを一括取得
		List<User> users = userService.allEmp();
		
		//取得したリストをテンプレートに渡す
		model.addAttribute("users", users);
		
		// 検索用モデル
		model.addAttribute("userForm", new UserForm());
		
		//テンプレート"users"を返す
		return "users";
	}
	
	// 社員一覧画面の検索機能
	@PostMapping("/search")
	public String search(Model model, UserForm form) {
		
		List<User> users = userService.searchByName(form.getName());
		model.addAttribute("users", users);
		
		// 検索履歴残るように修正
		model.addAttribute("userForm", form);
		
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
	// viewで入力された新規userの情報がuserFormに渡される
	public ModelAndView registerUser(UserForm userForm) {
		
		User user = new User();
		user.setId(userService.makeUserId());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		user.setBirthday(userForm.getBirthday());
		user.setGender(userForm.getGender());
		user.setCreatedate(userService.getLocalDate());
		
		// データベースに保存
		userService.save(user);
		// 登録完了画面に渡すためのモデルの作成 modelクラスを使用しても同じ
		ModelAndView mod = new ModelAndView();
		// どのviewに渡すか
		mod.setViewName("registered");
		// ("viewでの名前", 渡すインスタンス)
		mod.addObject("user", user);		
				
		return mod;		
		
	}
	
	// 社員登録完了後画面
	@GetMapping("/registered")
	public String registerd() {
		return "registered";
		
	}
	
	// 更新画面
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable String id, Model model) {
		
		User user = userService.findById(id);
		model.addAttribute("user", user);
		
		return "/edit";
	}
	
	// 更新処理
	@PostMapping("/update")
	// 新規userの情報がuserFormに渡される
	public String updateUser(User updatedUser, Model model) {
		
		// userのidを取得し、編集前のuserに編集後の情報を代入
		String id = updatedUser.getId();
		User user = userService.findById(id);
		
		user.setName(updatedUser.getName());
		user.setPassword(updatedUser.getPassword());
		user.setBirthday(updatedUser.getBirthday());
		user.setGender(updatedUser.getGender());
		user.setUpdatedate(userService.getLocalDate());
		
		// データベースに保存
		userRepository.save(user);
		
		model.addAttribute("user", user);
				
		return "updatedUser";		
		
	}
	
	@PostMapping("/delete")
	public String deleteUser(User user) {
		
		User targetUser = userService.findById(user.getId());
		targetUser.setUpdate_date(userService.getLocalDate());
		userService.save(targetUser);
		
		return "redirect:/";
	}
	
}
