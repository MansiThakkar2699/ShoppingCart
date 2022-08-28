package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.NewsLetterBean;
import com.dao.NewsLetterDao;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

/**
 * Servlet implementation class OfferController
 */
@WebServlet("/OfferController")
public class OfferController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String offer = request.getParameter("offer");
		Email from = new Email("admin@eShop.com");
		String subject = "Regarding offer";
		ArrayList<NewsLetterBean> email =new ArrayList<NewsLetterBean>();
		NewsLetterDao ndao =new NewsLetterDao();
		email = ndao.getEmail();
		for(NewsLetterBean nb : email)
		{
			Email to = new Email(nb.getEmail());
			System.out.println(nb.getEmail());
			Content content = new Content("text/plain", offer);
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
	}
}