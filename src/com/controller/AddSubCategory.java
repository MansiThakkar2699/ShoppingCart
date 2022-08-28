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
 * Servlet implementation class AddSubCategory
 */
@WebServlet("/AddSubCategory")
public class AddSubCategory extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String subcat_name=request.getParameter("subcat_name");
		int cat_id=Integer.parseInt(request.getParameter("cat_id"));
		SubCategoryBean sbean=new SubCategoryBean();
		sbean.setSubcat_name(subcat_name);
		sbean.setCat_id(cat_id);
		SubCategoryDao dao=new SubCategoryDao();
		try {
			dao.insertSubCategory(sbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ListSubCategoryController");
		rd.forward(request,response);
	}
}