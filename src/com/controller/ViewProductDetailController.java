package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

/**
 * Servlet implementation class ViewProductDetailController
 */
@WebServlet("/ViewProductDetailController")
public class ViewProductDetailController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int proid = Integer.parseInt(request.getParameter("proid"));
		ProductDao pdao = new ProductDao();
		ArrayList<ProductBean> product = new ArrayList<ProductBean>();
		product = pdao.getProductDetails(proid);
		request.setAttribute("product",product);
		RequestDispatcher rd = request.getRequestDispatcher("ViewProductDetails.jsp");
		rd.forward(request, response);
	}
}