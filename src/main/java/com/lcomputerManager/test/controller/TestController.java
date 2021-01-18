package com.lcomputerManager.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.lcomputerManager.test.domain.Board;
//import com.lcomputerManager.test.service.BoardService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
//	@GetMapping("/user")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<?>  userAccess() {
//		List<Board> boardList = boardService.selectBoardList();
//		return ResponseEntity.ok(boardList);
//	}
	
//	@GetMapping("/admin")
//	@PreAuthorize("hasRole('Admin')")
//	public String adminAccess() {
//		return "Admin Content.";
//	}
//	
//	@GetMapping("/boardDetail")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<?>  boardDetail(@RequestParam int bId) {
//		
//		logger.info("///"+bId);
//		
//		Board board = boardService.selectBoardDetail(bId);
//		return ResponseEntity.ok(board);
//	}
//	
//	@DeleteMapping("/boardDelete/{bId}")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<?>  boardDelete(@PathVariable(value = "bId") int bId) {
//		
//		logger.info("delete"+bId);
//		boardService.deleteBoard(bId);
//	
//		return ResponseEntity.ok(bId);
//	}
//	

}