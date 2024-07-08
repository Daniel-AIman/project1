package frontproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import frontproject.vo.SampleTBVO;

public class SampleTBDAO {

	private final String url = "jdbc:mysql://localhost:3306/javaspringclass"; 
	private final String user = "javaspringclass";
	private final String password = "1234";
	
	public List<SampleTBVO> selectList(){//ctrl + shift + o
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from sampleTB";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			List<SampleTBVO> slist = new ArrayList<SampleTBVO>();
			
			while(rs.next()) {
				SampleTBVO svo = new SampleTBVO();
				svo.setSno(rs.getInt("sno"));
				svo.setTitle(rs.getString("title"));
				svo.setWriter(rs.getString("writer"));
				svo.setRdate(rs.getString("rdate"));
				svo.setBody(rs.getString("body"));
				
				slist.add(svo);
			}
			
			return slist;
			
		}catch(Exception e) {
			e.printStackTrace();
//			return null; 캐치에 걸림
		}finally {
			try { //컴파일러 예외처리 때문에 추가로 try-catch 작성
				if(conn != null) conn.close();
				if(psmt != null) psmt.close();
				if(rs != null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public SampleTBVO selectOne(int sno) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from sampleTB where sno=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,sno);
			rs = psmt.executeQuery();
			
			SampleTBVO svo = null;
			if(rs.next()) {
				svo = new SampleTBVO();
				svo.setSno(rs.getInt("sno"));
				svo.setTitle(rs.getString("title"));
				svo.setWriter(rs.getString("writer"));
				svo.setRdate(rs.getString("rdate"));
				svo.setBody(rs.getString("body"));
			}
			return svo;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { //컴파일러 예외처리 때문에 추가로 try-catch 작성
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public int update(SampleTBVO svo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = " update sampleTB   "
					   + "    set title  = ? "
					   + "      , writer = ? "
					   + "      , body   = ? "
					   + "  where sno    = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getTitle());
			psmt.setString(2, svo.getWriter());
			psmt.setString(3, svo.getBody());
			psmt.setInt(4,svo.getSno());
			
			int result =psmt.executeUpdate();
			
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return 0;
	}
	
	
	public int insert(SampleTBVO svo) {//메서드를 추가하면 된다.
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
			String sql = "insert into sampleTB(title,body,writer,rdate)values(?,?,?,now())";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getTitle());
			psmt.setString(2, svo.getBody());
			psmt.setString(3, svo.getWriter());
			
			int result = psmt.executeUpdate();
			
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}