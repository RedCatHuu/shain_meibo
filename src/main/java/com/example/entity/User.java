package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "T_SYAIN")
public class User {
	
	// 自動採番
	@Id
	private String id;	
	private String name;
	private String password;
	private LocalDate birthday;
	private String gender;
	private LocalDate createdate;
	private LocalDate updatedate;
	private LocalDate update_date;
	
	public String showGender() {
		if(this.gender.equals("1")) {
			return "男";
		}else {
			return "女";
		}
	}

}
//
//create table T_SYAIN(
//		  id VARCHAR(10) PRIMARY KEY NOT NULL,
//		  name VARCHAR(40) NOT NULL,
//		  password VARCHAR(30) NOT NULL,
//		  birthday DATE,
//		  gender char(1),
//		  createdate TIMESTAMP NOT NULL,
//		  updatedate TIMESTAMP,
//		  update_date TIMESTAMP
//		);


//INSERT INTO T_SYAIN( ID, NAME, PASSWORD, BIRTHDAY, GENDER, CREATEDATE, UPDATEDATE, UPDATE_DATE)
//VALUES('1', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('2', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('3', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('4', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('5', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('6', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('7', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('8', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('9', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('10', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('11', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('12', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01'),
//('13', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01');
