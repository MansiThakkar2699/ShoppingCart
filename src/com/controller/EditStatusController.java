package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StatusBean;
import com.dao.StatusDao;

/**
 * Servlet implementation class EditStatusController
 */
@WebServlet("/EditStatusController")
public class EditStatusController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		StatusDao sdao= new StatusDao();
		StatusBean sbean = sdao.getDataByPk(s_id);
		request.setAttribute("sbean",sbean);
		RequestDispatcher rd=request.getRequestDispatcher("EditStatus.jsp");
		rd.forward(request, response);
	}
}