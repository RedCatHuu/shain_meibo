package com.example.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserForm {
	private String id;	
	private String name;
	private String password;
	private LocalDate birthday;
	private String gender;
	private LocalDate createdate;
	private LocalDate updatedate;
	private LocalDate update_date;

}
