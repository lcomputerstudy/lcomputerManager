package com.lcomputerManager.test.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lcomputerManager.test.domain.Student;
import com.lcomputerManager.test.domain.User;
import com.lcomputerManager.test.domain.UserInfo;



public interface UserService extends UserDetailsService{
	//유저읽기
		public User readUser(String username);
	//유저읽기 새로고침
		public UserInfo readUser_refresh(String username);
	//유저권한읽기 새로고침
		//public List<GrantedAuthority>  readAuthorities_refresh(String username);
	//유저생성
		public void createUser(User user);

//	// 유저목록 불러오기
//	   public List<UserInfo> readUserList();
//	 //유저목록 권한 불러오기
//	 		public List<UserInfo>  readAuthorities_all();
	   public List<UserInfo>read_user_list();
	// 시큐리티 권한 얻기
	   	Collection<GrantedAuthority> getAuthorities(String username);

	// 권한 생성
	   	public void createAuthority(User user);
	   	
	 //학생명단 불러오기
	   	public List<Student> ReadStudentList();
	   	
	   //출석부 불러오기
	   	public List<Map<String,String>> ReadAttendance();
	   	
	    //수강료 불러오기
	   	public List<Map<String,String>> ReadStudentTuition();
	   	
	   	public List<Map<String,String>> ReadStudentName();

}
