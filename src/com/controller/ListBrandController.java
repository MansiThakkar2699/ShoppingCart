package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BrandBean;
import com.dao.BrandDao;

/**
 * Servlet implementation class ListBrandController
 */
@WebServlet("/ListBrandController")
public class ListBrandController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BrandDao dao=new BrandDao();
		ArrayList<BrandBean> brandList;
		brandList =dao.listBrand();
		request.setAttribute("brandList",brandList);
		RequestDispatcher rd=request.getRequestDispatcher("ListBrand.jsp");
		rd.forward(request, response);
	}
}