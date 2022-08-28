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
 * Servlet implementation class DeleteStatusController
 */
@WebServlet("/DeleteStatusController")
public class DeleteStatusController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		StatusBean sbean=new StatusBean();
		sbean.setS_id(s_id);
		StatusDao sdao=new StatusDao();
		sdao.deleteStatus(sbean);
		RequestDispatcher rd=request.getRequestDispatcher("ListStatusController");
		rd.forward(request, response);
	}
}