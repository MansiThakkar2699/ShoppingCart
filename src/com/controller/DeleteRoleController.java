package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RoleBean;
import com.dao.RoleDao;
import com.util.DbConnection;

public class DeleteRoleController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		int role_id=Integer.parseInt(request.getParameter("role_id"));
		RoleBean rolebean=new RoleBean();
		rolebean.setId(role_id);
		RoleDao dao=new RoleDao();
		dao.DeleteRole(rolebean);
		RequestDispatcher rd=request.getRequestDispatcher("ListRoleController");
		rd.forward(request, response);
	}
}