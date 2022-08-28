package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProductBean;
import com.bean.UserBean;
import com.dao.ProductDao;
import com.dao.SignUpDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		SignUpDao signDao=new SignUpDao();
		UserBean userBean=signDao.login(email,password);
		RequestDispatcher rd=null;
		if(userBean == null)
		{
			request.setAttribute("loginError", "<font color='red'>Invalid UserName or Password</font>");
			rd=request.getRequestDispatcher("Login.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("userBean",userBean);
			if(userBean.getRoleId()==1)
			{
				ProductDao pdao=new ProductDao();
				ArrayList<ProductBean> productList=new ArrayList<ProductBean>();
				productList=pdao.listProduct();
				request.setAttribute("productList",productList);
				rd=request.getRequestDispatcher("UserHomeController");
			}
			else
			{
				rd=request.getRequestDispatcher("AdminHomeController");
			}
		}
		rd.forward(request, response);
	}
}
