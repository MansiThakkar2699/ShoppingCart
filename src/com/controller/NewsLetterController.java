package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.NewsLetterBean;
import com.dao.NewsLetterDao;

/**
 * Servlet implementation class NewsLetterController
 */
@WebServlet("/NewsLetterController")
public class NewsLetterController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		NewsLetterBean nbean = new NewsLetterBean();
		NewsLetterDao ndao = new NewsLetterDao();
		nbean.setEmail(email);
		ndao.insertEmail(nbean);
	}
}