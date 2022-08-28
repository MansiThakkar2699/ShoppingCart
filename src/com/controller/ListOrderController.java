package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartBean;
import com.bean.OrderBean;
import com.bean.UserBean;
import com.dao.CartDao;
import com.dao.OrderDao;

/**
 * Servlet implementation class ListOrderController
 */
@WebServlet("/ListOrderController")
public class ListOrderController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<OrderBean> obean = new ArrayList<OrderBean>();
		OrderDao odao = new OrderDao();
		OrderBean ob = new OrderBean();
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("userBean");
		ob.setUser_id(ubean.getId());
		obean = odao.listOrder(ubean.getId());
		request.setAttribute("obean",obean);
		RequestDispatcher rd = request.getRequestDispatcher("ListOrder.jsp");
		rd.forward(request, response);
	}
}