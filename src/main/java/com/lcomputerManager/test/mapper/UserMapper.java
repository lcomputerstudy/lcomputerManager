package com.lcomputerManager.test.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.lcomputerManager.test.domain.Student;
import com.lcomputerManager.test.domain.User;
import com.lcomputerManager.test.domain.UserInfo;

@Mapper
public interface UserMapper {
	//유저읽기
		public User readUser(String username);
	//유저읽기 새로고침
		public UserInfo readUser_refresh(String username);

	 //유저생성
		public void createUser(User user);

		public List<UserInfo>read_user_list();

	 // 권한 읽기
		public List<GrantedAuthority> readAuthorities(String username);
	 // 권한 생성
		public void createAuthority(User user);
		
		//studentlist불러오기
		public List<Student> ReadStudentList();
		
		//attendance 불러오기
		public List<Map<String,String>> ReadAttendance();
		
		  //수강료 불러오기
	   	public List<Map<String,String>> ReadStudentTuition();
	   	
	   	public List<Map<String,String>> ReadStudentName();
}
