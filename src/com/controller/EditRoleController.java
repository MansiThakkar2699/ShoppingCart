package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RoleBean;
import com.dao.RoleDao;

public class EditRoleController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int role_id=Integer.parseInt(request.getParameter("role_id"));
		RoleDao roleDao=new RoleDao();
		RoleBean roleBean=roleDao.getDataByPk(role_id);
		request.setAttribute("roleBean", roleBean);
		RequestDispatcher rd=request.getRequestDispatcher("EditRole.jsp");
		rd.forward(request, response);
	}
}