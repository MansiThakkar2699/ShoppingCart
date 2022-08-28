package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;

/**
 * Servlet implementation class UpdateSubCategoryController
 */
@WebServlet("/UpdateSubCategoryController")
public class UpdateSubCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String subcat_name=request.getParameter("subcat_name");
		int subcat_id=Integer.parseInt(request.getParameter("subcat_id"));
		int cat_id = Integer.parseInt(request.getParameter("cat_id"));
		String cat_name=request.getParameter("cat_name");
		SubCategoryBean sbean=new SubCategoryBean();
		sbean.setSubcat_id(subcat_id);
		sbean.setSubcat_name(subcat_name);
		sbean.setCat_name(cat_name);
		sbean.setCat_id(cat_id);
		SubCategoryDao dao=new SubCategoryDao();
		dao.UpadateSubCategory(sbean);
		RequestDispatcher rd=request.getRequestDispatcher("ListSubCategoryController");
		rd.forward(request, response);
	}
}