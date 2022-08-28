package com.controller;

import java.io.IOException;

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
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int proid =Integer.parseInt(request.getParameter("proid"));
		CartBean cbean = new CartBean();
		cbean.setProid(proid);
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("userBean");
		cbean.setId(ubean.getId());
		CartDao cdao = new CartDao();
		cdao.AddProduct(cbean);
		RequestDispatcher rd = request.getRequestDispatcher("ListCartController");
		rd.forward(request, response);
	}
}