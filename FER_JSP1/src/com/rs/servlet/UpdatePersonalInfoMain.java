package com.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.bean.Address;
import com.rs.bean.PersonalInfo;
import com.rs.bean.User;
import com.rs.fer.util.HTMLUtil;
import com.rs.service.FERService;
import com.rs.service.FERServiceImpl;

public class UpdatePersonalInfoMain extends HttpServlet {

	/*@Override
	public void init(ServletConfig config) throws ServletException {
		String configValue = config.getInitParameter("ConfigKey");
		String contextValue = config.getServletContext().getInitParameter("ContextKey");

		System.out.println("UpdatePersonalInfo.init(): ConfigValue: " + configValue + " and ContextValue: " + contextValue);
	}*/
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService service=new FERServiceImpl();
		HttpSession session=request.getSession();
		PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
		PrintWriter out=response.getWriter();
		
		boolean updateFlag=service.updatePersonalInfo(personalinfo.getUser(), personalinfo.getAddress());
		
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		
		if(updateFlag){
			out.println("Update Successfully");
		}else{
			out.println("Unable To Update");
		}
		 
		HTMLUtil.displayFooter(out);
	}


	

}
