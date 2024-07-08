package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FrontListener implements ServletContextListener {


    public FrontListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("front 프로젝트 종료");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("front 프로젝트 실행");
    }
	
}
