package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RoleBean;
import com.dao.RoleDao;
import com.util.DbConnection;

public class ListRoleController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RoleDao roleDao=new RoleDao();
		ArrayList<RoleBean>roleList=roleDao.listRole();
		request.setAttribute("roleList",roleList);
		RequestDispatcher rd=request.getRequestDispatcher("ListRole.jsp");
		rd.forward(request, response);
	}
}