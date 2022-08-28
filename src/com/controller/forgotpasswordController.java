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
 * Servlet implementation class forgotpasswordController
 */
@WebServlet("/forgotpasswordController")
public class forgotpasswordController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String securityque = request.getParameter("securityque");
		String securityans = request.getParameter("securityans");
		System.out.println(securityque);
		System.out.println(securityans);
		System.out.println(email);
		SignUpDao sdao=new SignUpDao();
		UserBean ubean = sdao.getDataByEmail(email);
		RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
		if(ubean == null)
		{
			request.setAttribute("msg","InvalidEmail");
		}
		else
		{
			System.out.println("else");
			System.out.println(securityque);
			System.out.println(securityans);
			System.out.println(ubean.getSecurityque());
			System.out.println(ubean.getSecurityans());
			if(ubean.getSecurityque().equals(securityque) && ubean.getSecurityans().equals(securityans))
			{
				Email from = new Email("admin@eShop.com");
				String subject = "Password Recovered";
				Email to = new Email(ubean.getEmail());
				Content content = new Content("text/plain", "Your password for login into eShop is "+ubean.getPassword());
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
				request.setAttribute("msg","Your password is Recoverd please check your email");
			}
			else
			{
				request.setAttribute("msg","InvalidSecurityQuestion&Answer");
			}
		}
		rd.forward(request, response);
	}
}