package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.bean.SubCategoryBean;
import com.dao.ProductDao;
import com.dao.SubCategoryDao;

/**
 * Servlet implementation class EditProductController
 */
@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int proid=Integer.parseInt(request.getParameter("proid"));
		ProductDao pdao =new ProductDao(); 
		ProductBean pbean=pdao.getDataByPk(proid);
		request.setAttribute("pbean",pbean);
		RequestDispatcher rd=request.getRequestDispatcher("EditProduct.jsp");
		rd.forward(request, response);
	}
}