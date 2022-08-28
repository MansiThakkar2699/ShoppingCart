package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.SignUpDao;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fname,lname,email,password,gender,securityque,securityans;
		boolean isError=false;
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		email=request.getParameter("email");
		password=request.getParameter("password");
		gender=request.getParameter("gender");
		securityque=request.getParameter("securityque");
		securityans=request.getParameter("securityans");
		if(fname==null || fname.trim().length()==0)
		{
			isError=true;
			request.setAttribute("fnameError","please Enter FirstName");
		}
		if(lname==null || lname.trim().length()==0)
		{
			isError=true;
			request.setAttribute("lnameError","please Enter LastName");
		}
		if(email==null || email.trim().length()==0)
		{
			isError=true;
			request.setAttribute("emailError","please Enter Email");
		}
		if(password==null || password.trim().length()==0)
		{
			isError=true;
			request.setAttribute("passwordError","please Enter Password");
		}
		if(gender==null)
		{
			isError=true;
			request.setAttribute("genderError", "please Select Gender");
		}
		if(securityque == null)
		{
			isError=true;
			request.setAttribute("securityqueError","Please Select securityque");
		}
		if(securityans == null)
		{
			request.setAttribute("securityansError","Please Select security Answer");
		}
		RequestDispatcher rd=null;
		if(isError==true)
		{
			rd=request.getRequestDispatcher("SignUp.jsp");
		}
		else
		{
			System.out.println("signup");
			rd=request.getRequestDispatcher("Login.jsp");
			UserBean b=new UserBean();
			b.setFname(fname);
			b.setLname(lname);
			b.setEmail(email);
			b.setGender(gender);
			b.setPassword(password);
			b.setSecurityque(securityque);
			b.setSecurityans(securityans);
			try
			{
				SignUpDao dao=new SignUpDao();
				dao.InsertUser(b);
				Email from = new Email("admin@eShop.com");
				String subject = "Welcome Message";
				Email to = new Email(b.getEmail());
				Content content = new Content("text/plain", "Welcome to eShop");
				Mail mail = new Mail(from, subject, to, content);

				SendGrid sg = new SendGrid("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");
				Request request1 = new Request() {
				};
				try {
					request1.setMethod(Method.POST);
					request1.setEndpoint("mail/send");
					request1.setBody(mail.build());
					Response response1 = sg.api(request1);
					System.out.println(response1.getStatusCode());
					System.out.println(response1.getBody());
					System.out.println(response1.getHeaders());
				} catch (IOException ex) {
					throw ex;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		rd.forward(request, response);
	}
}