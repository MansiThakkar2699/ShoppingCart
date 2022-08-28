package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BrandBean;
import com.bean.CategoryBean;
import com.dao.BrandDao;
import com.dao.CategoryDao;

/**
 * Servlet implementation class UpdateBrandController
 */
@WebServlet("/UpdateBrandController")
public class UpdateBrandController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String brand_name=request.getParameter("brand_name");
		String brand_site=request.getParameter("brand_site");
		int brand_id=Integer.parseInt(request.getParameter("brand_id"));
		BrandBean b=new BrandBean();
		b.setBrand_id(brand_id);
		b.setBrand_name(brand_name);
		b.setBrand_site(brand_site);
		BrandDao dao=new BrandDao();
		dao.UpadateBrand(b);
		RequestDispatcher rd=request.getRequestDispatcher("ListBrandController");
		rd.forward(request, response);
	}
}