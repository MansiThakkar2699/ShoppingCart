package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.bean.AddressBean;
import com.bean.UserBean;
import com.dao.AddressDao;

/**
 * Servlet implementation class AddAddressController
 */
@WebServlet("/AddAddressController")
public class AddAddressController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("userBean");
		AddressDao adao = new AddressDao();
		AddressBean abean = new AddressBean();
		abean.setUser_id(ubean.getId());
		abean.setAddress(address);
		adao.insertAddress(abean);
		RequestDispatcher rd = request.getRequestDispatcher("ListAddressController");
		rd.forward(request, response);
	}
}