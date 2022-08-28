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

import com.bean.AddressBean;
import com.bean.UserBean;
import com.dao.AddressDao;

/**
 * Servlet implementation class ListAddressController
 */
@WebServlet("/ListAddressController")
public class ListAddressController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Address");
		AddressDao adao = new AddressDao();
		AddressBean abean = new AddressBean();
		ArrayList<AddressBean> addressList ;
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("userBean");
		abean.setUser_id(ubean.getId());
		addressList = adao.ListAddress(ubean.getId());
		request.setAttribute("addressList", addressList);
		RequestDispatcher rd = request.getRequestDispatcher("ListAddress.jsp");
		rd.forward(request, response);
	}
}