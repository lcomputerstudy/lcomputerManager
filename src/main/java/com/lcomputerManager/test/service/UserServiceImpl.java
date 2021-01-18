package com.lcomputerManager.test.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lcomputerManager.test.domain.Student;
import com.lcomputerManager.test.domain.User;
import com.lcomputerManager.test.domain.UserInfo;
import com.lcomputerManager.test.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println(username);
		User user = userMapper.readUser(username);
		user.setAuthorities(getAuthorities(username));	
		return user;
	}


	@Override
	public User readUser(String username) {
		return userMapper.readUser(username);
	}


	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		List<GrantedAuthority> authorities = userMapper.readAuthorities(username);
		return authorities;
	}

	 @Override
	   public void createUser(User user) {
	      userMapper.createUser(user);
	   }

	@Override
	public void createAuthority(User user) {
		userMapper.createAuthority(user);
	}
	
	@Override
	public List<UserInfo>read_user_list() {
		return userMapper.read_user_list();
	}
	
	
	//유저읽기 새로고침
		public UserInfo readUser_refresh(String username) {
			return userMapper.readUser_refresh(username);
		}
		
		//학생 명단 불러오기
		public List<Student> ReadStudentList() {
			return userMapper.ReadStudentList();
		}
		
		//출석부 불러오기
		public List<Map<String,String>> ReadAttendance() {
			return userMapper.ReadAttendance();
		}
		
		  //수강료 불러오기
	   	public List<Map<String,String>> ReadStudentTuition() {
	   		return userMapper.ReadStudentTuition();
	   	}
	   	
	   	public List<Map<String,String>> ReadStudentName() {
	   		return userMapper.ReadStudentName();
	   	}

}
