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

import com.bean.SubCategoryBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;

/**
 * Servlet implementation class ListSubCategoryController
 */
@WebServlet("/ListSubCategoryController")
public class ListSubCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		SubCategoryDao dao=new SubCategoryDao();
		ArrayList<SubCategoryBean> subcategorylist= new ArrayList<SubCategoryBean>();
		try {
			subcategorylist=dao.listSubCategory();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("subcategoryList",subcategorylist);
		RequestDispatcher rd=request.getRequestDispatcher("ListSubCategory.jsp");
		rd.forward(request, response);
	}
}