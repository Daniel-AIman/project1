package com.a.ezn.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.a.ezn.BoardVO;

@Repository
public class BoardRepository {
	
	@Autowired
	JdbcTemplate template;
	
	public List<BoardVO> getAllData() {
		String sql = "select * from sampleTB";
		return template.query(sql, new BeanPropertyRowMapper<>(BoardVO.class));
	}
	
	public BoardVO selectOne(int sno) {
		
		String sql = "select*from sampleTB where sno = ?";
		return template.queryForObject(sql, new Object[] {sno}, new BeanPropertyRowMapper<>(BoardVO.class));
	}
	
	public int insertOne(BoardVO vo) {
		String sql = "insert into sampleTB(title, body, writer, rdate)";
		sql+="values(?,?,?, now())";
		int result = template.update(sql, vo.getTitle(), vo.getBody(), vo.getWriter());
		return result;
	}
}
