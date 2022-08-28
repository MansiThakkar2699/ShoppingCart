package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetSubcategoryViaCategory
 */
@WebServlet("/GetSubcategoryViaCategory")
public class GetSubcategoryViaCategory extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cat_id = Integer.parseInt(request.getParameter("cat_id"));
		SubCategoryDao sdao = new SubCategoryDao();
		ArrayList<SubCategoryBean> subcategory= sdao.getSubCategory(cat_id);
		String json = new Gson().toJson(subcategory);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}