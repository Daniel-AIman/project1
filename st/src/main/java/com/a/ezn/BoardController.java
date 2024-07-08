package com.a.ezn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.ezn.repo.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardRepository repository;
	
	/*@Autowired
	@Qualifier("board1")
	BoardVO board;*/
	/*@Autowired
	JdbcTemplate template;*/
	
	@RequestMapping(value="/board.do", method=RequestMethod.GET)
	public String board(Model model, HttpServletRequest request, BoardVO vo) {
		
		/*String sql = "select * from sampleTB";
		List<BoardVO> slist = template.query(sql, new BeanPropertyRowMapper<>(BoardVO.class));*/
		
		List<BoardVO> slist = repository.getAllData();
		
		model.addAttribute("vo", slist);
		
		return "board";	
	}
	
	@RequestMapping(value="/post.do", method=RequestMethod.GET)
	public String view(@RequestParam(name="sno", defaultValue="0") int sno, Model model) {
		
		BoardVO vo = repository.selectOne(sno);
		model.addAttribute("vo", vo);
		
		return "view";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String write() {
		
		return "write";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String writeOk(BoardVO vo) {
		
		int result = repository.insertOne(vo);
		if(result > 0) {
			return "redirect:/board/post.do";
		}else {
			return "redirect:/board/board.do";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/board.do", method=RequestMethod.POST)
	public String postBoard() {
		System.out.println("게시글 작성 sql 실행");
		return "a";
	}

	@ResponseBody
	@RequestMapping(value="/board.do", method=RequestMethod.PUT)
	public String putBoard() {
		System.out.println("게시글 수정 sql 실행");
		return "b";
	}
	
	@ResponseBody
	@RequestMapping(value="/board.do", method=RequestMethod.DELETE)
	public String deleteBoard() {
		System.out.println("게시글 삭제");
		return "c";
	}
}
