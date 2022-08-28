package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.bean.ProductBean;
import com.dao.CategoryDao;
import com.dao.ProductDao;

/**
 * Servlet implementation class UserHomeController
 */
@WebServlet("/UserHomeController")
public class UserHomeController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDao pdao = new ProductDao();
		ArrayList<ProductBean> productList=new ArrayList<ProductBean>();
		productList=pdao.listProduct();
		request.setAttribute("productList",productList);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}
}