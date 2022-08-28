package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BrandBean;
import com.dao.BrandDao;

/**
 * Servlet implementation class AddBrandController
 */
@WebServlet("/AddBrandController")
public class AddBrandController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String bname=request.getParameter("bname");
		String site=request.getParameter("site");
		BrandBean b=new BrandBean();
		b.setBrand_name(bname);
		b.setBrand_site(site);
		BrandDao dao=new BrandDao();
		try {
			dao.insertBrand(b);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ListBrandController");
		rd.forward(request, response);
	}
}