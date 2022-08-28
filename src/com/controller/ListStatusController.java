package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StatusBean;
import com.dao.CategoryDao;
import com.dao.StatusDao;

/**
 * Servlet implementation class ListStatusController
 */
@WebServlet("/ListStatusController")
public class ListStatusController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StatusDao sdao=new StatusDao();
		ArrayList<StatusBean> statusList;
		statusList=sdao.listStatus();
		request.setAttribute("statusList",statusList);
		RequestDispatcher rd=request.getRequestDispatcher("ListStatus.jsp");
		rd.forward(request, response);
	}
}