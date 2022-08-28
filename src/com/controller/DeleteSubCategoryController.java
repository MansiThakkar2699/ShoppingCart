package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

/**
 * Servlet implementation class DeleteSubCategoryController
 */
@WebServlet("/DeleteSubCategoryController")
public class DeleteSubCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int subcat_id=Integer.parseInt(request.getParameter("subcat_id"));
		SubCategoryBean sbean=new SubCategoryBean();
		sbean.setSubcat_id(subcat_id);
		SubCategoryDao dao=new SubCategoryDao();
		try {
			dao.deleteSubCategory(sbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ListSubCategoryController");
		rd.forward(request, response);
	}
}