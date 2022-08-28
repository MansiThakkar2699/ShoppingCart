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
import com.bean.UserBean;
import com.dao.CartDao;

/**
 * Servlet implementation class ListCartController
 */
@WebServlet("/ListCartController")
public class ListCartController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("ListCartController");
		CartDao cdao = new CartDao();
		CartBean cbean = new CartBean();
		ArrayList<CartBean> cartList = new ArrayList<CartBean>();
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("userBean");
		cbean.setId(ubean.getId());
		cartList = cdao.listCart(ubean.getId());
		request.setAttribute("cartList",cartList);
		RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
		rd.forward(request, response);
	}
}