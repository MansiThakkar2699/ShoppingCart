package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;
import com.dao.SignUpDao;

/**
 * Servlet implementation class AdminHomeController
 */
@WebServlet("/AdminHomeController")
public class AdminHomeController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		SignUpDao sdao = new SignUpDao();
		OrderDao odao = new OrderDao();
		int user = sdao.CountUser();
		request.setAttribute("user", user);
		int order = odao.CountOrder();
		request.setAttribute("order", order);
		int admin = sdao.AdminCount();
		request.setAttribute("admin", admin);
		int pendingorder = odao.PendingOrder();
		request.setAttribute("pendingorder", pendingorder);
		RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
		rd.forward(request, response);
	}
}