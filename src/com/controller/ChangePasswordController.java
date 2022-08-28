package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.SignUpDao;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("ChangePasswordController");
		String Password = request.getParameter("Password");
		String newPassword = request.getParameter("newpassword");
		String confirmpass = request.getParameter("confirmpass");
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("user");
		System.out.println(Password);
		System.out.println("Password from database:-"+ubean.getPassword());
		System.out.println(newPassword);
		System.out.println(confirmpass);
		RequestDispatcher rd = null;
		if(!newPassword.equals(confirmpass))
		{
			request.setAttribute("msg", "NewPassword & ConfirmNewPassword must be same");
			rd = request.getRequestDispatcher("ChangePassword.jsp");
		}
		else if(!Password.equals(ubean.getPassword()))
		{
			request.setAttribute("msg", "Old Password is wrong");
			rd = request.getRequestDispatcher("ChangePassword.jsp");
		}
		else
		{
			System.out.println("else");
			//ubean.setPassword(newPassword);
			SignUpDao dao = new SignUpDao();
			dao.updatePassword(ubean.getEmail(),newPassword);
			request.setAttribute("msg", "Your Password is updated");
			rd = request.getRequestDispatcher("AdminHome.jsp");
		}
		rd.forward(request, response);
	}
}