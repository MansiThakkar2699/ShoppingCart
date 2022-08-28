package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StatusBean;
import com.dao.StatusDao;

/**
 * Servlet implementation class AddStatusController
 */
@WebServlet("/AddStatusController")
public class AddStatusController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String status=request.getParameter("status");
		StatusBean sbean=new StatusBean();
		sbean.setStatus(status);
		StatusDao sdao=new StatusDao();
		sdao.insertStatus(sbean);
		RequestDispatcher rd=request.getRequestDispatcher("ListStatusController");
		rd.forward(request, response);
	}
}