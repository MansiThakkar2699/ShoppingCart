package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderDetailBean;
import com.dao.OrderDetailDao;
import com.sendgrid.Request;

/**
 * Servlet implementation class ListOrderDetailController
 */
@WebServlet("/ListOrderDetailController")
public class ListOrderDetailController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int oid = Integer.parseInt(request.getParameter("oid"));
		ArrayList<OrderDetailBean> odbean = new ArrayList<OrderDetailBean>();
		OrderDetailDao oddao = new OrderDetailDao();
		odbean = oddao.listOrderDetail(oid);
		request.setAttribute("odbean", odbean);
		RequestDispatcher rd = request.getRequestDispatcher("ListOrderDetail.jsp");
		rd.forward(request, response);
	}
}