package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.CategoryBean;
import com.dao.CategoryDao;
/**
 * Servlet implementation class EditCategoryController
 */
@WebServlet("/EditCategoryController")
public class EditCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cat_id=Integer.parseInt(request.getParameter("cat_id"));
		CategoryDao dao=new CategoryDao();
		CategoryBean bean=dao.getDataByPk(cat_id);
		request.setAttribute("bean", bean);
		RequestDispatcher rd=request.getRequestDispatcher("EditCategory.jsp");
		rd.forward(request, response);
	}
}