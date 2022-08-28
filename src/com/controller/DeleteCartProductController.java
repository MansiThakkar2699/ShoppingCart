package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDao;

/**
 * Servlet implementation class DeleteCartProductController
 */
@WebServlet("/DeleteCartProductController")
public class DeleteCartProductController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int catid = Integer.parseInt(request.getParameter("cartid"));
		CartDao cdao =new CartDao();
		cdao.DeleteProduct(catid);
		RequestDispatcher rd = request.getRequestDispatcher("ListCartController");
		rd.forward(request, response);
	}
}