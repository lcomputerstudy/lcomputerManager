package com.lcomputerManager.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcomputerManager.test.config.JwtUtils;
import com.lcomputerManager.test.domain.Student;
import com.lcomputerManager.test.domain.UserInfo;
import com.lcomputerManager.test.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
		@GetMapping("/studentlist")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public ResponseEntity<?>  StudentList(HttpServletRequest request) {
			logger.info(request.toString());
			List<Student> StudentList = userService.ReadStudentList();
		
			logger.info(StudentList.toString());
			  return new ResponseEntity<>(StudentList, HttpStatus.OK);
		}
		
		@GetMapping("/attendancelist")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public ResponseEntity<?>  AttendanceList(HttpServletRequest request) {
			logger.info(request.toString());
			 List<Map<String,String>> AttendanceList = userService.ReadAttendance();
			logger.info(AttendanceList.toString());
			  return new ResponseEntity<>(AttendanceList, HttpStatus.OK);
		}
		
		@GetMapping("/studenttuition")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public ResponseEntity<?>  StudentTuition(HttpServletRequest request) {
			logger.info(request.toString());
			 List<Map<String,String>> StudentTuitionList = userService.ReadStudentTuition();
			logger.info(StudentTuitionList.toString());
			  return new ResponseEntity<>(StudentTuitionList, HttpStatus.OK);
		}
		
		@GetMapping("/studentseat")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public ResponseEntity<?>  StudentSeat(HttpServletRequest request) {
			logger.info(request.toString());
			 List<Map<String,String>> StudentTuitionList = userService.ReadStudentTuition();
			logger.info(StudentTuitionList.toString());
			  return new ResponseEntity<>(StudentTuitionList, HttpStatus.OK);
		}
}
