package frontproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontproject.dao.SampleTBDAO;
import frontproject.vo.SampleTBVO;

/*
 frontcontroller는 모든 가상경로를 제일 먼저 받아 역할에 맞는 컨트롤러로 요청을 분기하는 처리를 한다.
*/

public class FrontController extends HttpServlet {

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getRequestURI(); // 전체 url(도메인제외)
		String contextPath = request.getContextPath(); // 프로젝트 path

		String command = requestURL.substring(contextPath.length() + 1); // 프로젝트 path를 제외한 uri  /까지 잘라내
		String[] uris = command.split("/");
		if (uris[0].equals("sampleTB")) {

			 SampleTBController sampleTBController = new SampleTBController();
			  
			 sampleTBController.getAction(request, response, uris);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURL = request.getRequestURI(); // 전체 url(도메인제외)
		String contextPath = request.getContextPath(); // 프로젝트 path

		String command = requestURL.substring(contextPath.length() + 1); // 프로젝트 path를 제외한 uri  /까지 잘라내
		String[] uris = command.split("/");
		if (uris[0].equals("sampleTB")) {

			 SampleTBController sampleTBController = new SampleTBController();
			  
			 sampleTBController.postAction(request, response, uris);

		}
	}
}
