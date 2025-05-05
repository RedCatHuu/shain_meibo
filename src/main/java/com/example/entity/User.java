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
//VALUES('1', 'First Test', 'pass1', '2000-04-01', '1', '2025-04-01', '2025-05-01', '2025-06-01');
