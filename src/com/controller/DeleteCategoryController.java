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
 * Servlet implementation class DeleteCategoryController
 */
@WebServlet("/DeleteCategoryController")
public class DeleteCategoryController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cat_id=Integer.parseInt(request.getParameter("cat_id"));
		CategoryBean categorybean=new CategoryBean();
		categorybean.setCat_id(cat_id);
		CategoryDao dao=new CategoryDao();
		dao.DeleteCategory(categorybean);
		RequestDispatcher rd=request.getRequestDispatcher("ListCategoryController");
		rd.forward(request, response);
	}
}