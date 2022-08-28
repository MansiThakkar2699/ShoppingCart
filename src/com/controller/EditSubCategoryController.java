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
 * Servlet implementation class EditSubCategoryController
 */
@WebServlet("/EditSubCategoryController")
public class EditSubCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int subcat_id=Integer.parseInt(request.getParameter("subcat_id"));
		SubCategoryDao dao = new SubCategoryDao();
		SubCategoryBean sbean=dao.getDataByPk(subcat_id);
		request.setAttribute("sbean",sbean);
		RequestDispatcher rd=request.getRequestDispatcher("EditSubCategory.jsp");
		rd.forward(request, response);
	}
}