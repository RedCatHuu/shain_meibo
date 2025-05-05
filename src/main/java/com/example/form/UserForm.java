package com.example.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserForm {
	private String id;	
	private String name;
	private String password;
	private LocalDate birthday;
	// new.htmlのラジオボタンで男が初期選択されている状態にするため初期化
	private String gender = "1";
	private LocalDate createdate;
	private LocalDate updatedate;
	private LocalDate update_date;

}
