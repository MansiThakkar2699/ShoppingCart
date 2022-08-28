package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BrandBean;
import com.dao.BrandDao;

/**
 * Servlet implementation class EditBrandController
 */
@WebServlet("/EditBrandController")
public class EditBrandController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int brand_id=Integer.parseInt(request.getParameter("brand_id"));
		BrandDao dao=new BrandDao();
		BrandBean b=dao.getDataByPk(brand_id);
		request.setAttribute("b",b);
		RequestDispatcher rd=request.getRequestDispatcher("EditBrand.jsp");
		rd.forward(request, response);
	}
}