package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RoleBean;
import com.dao.RoleDao;
import com.util.DbConnection;

public class UpdateRoleController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String role=request.getParameter("roleName");
		int role_id=Integer.parseInt(request.getParameter("role_id"));
		RoleBean roleBean=new RoleBean();
		roleBean.setName(role);
		roleBean.setId(role_id);
		RoleDao roleDao=new RoleDao();
		roleDao.UpdateBook(roleBean);
		
		response.sendRedirect("ListRoleController");
	}
}