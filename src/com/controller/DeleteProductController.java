package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int proid=Integer.parseInt(request.getParameter("proid"));
		ProductBean pbean=new ProductBean();
		pbean.setProid(proid);
		ProductDao pdao=new ProductDao();
		pdao.deleteProduct(pbean);
		RequestDispatcher rd=request.getRequestDispatcher("ListProductController");
		rd.forward(request, response);
	}
}