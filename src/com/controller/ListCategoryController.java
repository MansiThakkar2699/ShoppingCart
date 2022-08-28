package com.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.CategoryBean;
import com.bean.RoleBean;
import com.dao.CategoryDao;
import com.dao.RoleDao;

/**
 * Servlet implementation class ListCategoryController
 */
@WebServlet("/ListCategoryController")
public class ListCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CategoryDao categoryDao=new CategoryDao();
		ArrayList<CategoryBean> categoryList;
		try {
			categoryList = categoryDao.listCategory();
			request.setAttribute("categoryList",categoryList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ListCategory.jsp");
		rd.forward(request, response);
	}
}