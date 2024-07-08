package frontproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import frontproject.dao.SampleTBDAO;
import frontproject.vo.SampleTBVO;

public class SampleTBController {
	
	public void getAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//frontcontroller에서 sampleTB관련 모든 요청을 받아서 각 목적에 맞는 메서드를 분기하는 영역
		
		if(uris[1].equals("list.do")) {
			list(request,response);
		}else if(uris[1].equals("view.do")){
			view(request,response);
		}else if(uris[1].equals("modify.do")){
			modify(request,response);
		}else if(uris[1].equals("insert.do")){
			insert(request,response);
		}
	}
	public void postAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//post 요청에 대한 처리
		if(uris[1].equals("modify.do")) {
			modifyOk(request,response);
		}else if(uris[1].equals("insert.do")) {
			insertOk(request,response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SampleTBDAO sampleTBDao = new SampleTBDAO(); //ctrl shift o
		List<SampleTBVO> slist = sampleTBDao.selectList();
		
		request.setAttribute("slist", slist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/list.jsp");
		rd.forward(request, response);
	}
	
	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String snoParam = request.getParameter("sno");
		int sno = 0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}else {
			response.sendRedirect("list.do");
		}
		
		SampleTBDAO sampleTBDao = new SampleTBDAO(); 
		
		SampleTBVO svo = sampleTBDao.selectOne(sno);
		
		request.setAttribute("svo", svo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/view.jsp");
		rd.forward(request, response);
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String snoParam = request.getParameter("sno");
		int sno =0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}else {
			response.sendRedirect("list.do");
		}
			
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		
		SampleTBVO svo = sampleTBDao.selectOne(sno);
			
		request.setAttribute("svo",svo);
			
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modify.jsp");
		rd.forward(request, response);
	}
	
	private void modifyOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String snoParam = request.getParameter("sno");
		int sno =0;
		if(snoParam != null && !snoParam.equals("")) {
			sno = Integer.parseInt(snoParam);
		}
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");
		
		SampleTBVO svo = new SampleTBVO();
		svo.setSno(sno);
		svo.setTitle(title);
		svo.setWriter(writer);
		svo.setBody(body);
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		int result = sampleTBDao.update(svo);
		
		if(result>0) {
			//수정성공
			response.sendRedirect("view.do?sno="+sno);
		}else {
			//수정실패
			response.sendRedirect("modify.do?sno="+sno+"&msg=fail");
		}
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/insert.jsp");
		rd.forward(request, response);
	}
	
	private void insertOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		SampleTBVO svo = new SampleTBVO();
		svo.setTitle(request.getParameter("title"));
		svo.setWriter(request.getParameter("writer"));
		svo.setBody(request.getParameter("body"));
		
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		int result = sampleTBDao.insert(svo);
		
		response.sendRedirect("list.do");

	}
}

