package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String proname=request.getParameter("proname");
		int cat_id=Integer.parseInt(request.getParameter("cat_id"));
		int subcat_id=Integer.parseInt(request.getParameter("subcat_id"));
		int brand_id=Integer.parseInt(request.getParameter("brand_id"));
		int price=Integer.parseInt(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String prodinfo=request.getParameter("prodinfo");
		String otherinfo=request.getParameter("otherinfo");
		ProductBean pbean=new ProductBean();
		pbean.setProname(proname);
		pbean.setCat_id(cat_id);
		pbean.setSubcat_id(subcat_id);
		pbean.setBrand_id(brand_id);
		pbean.setPrice(price);
		pbean.setQuntity(quantity);
		pbean.setProdinfo(prodinfo);
		pbean.setOtherinfo(otherinfo);
		ProductDao pdao=new ProductDao();
		pdao.insertProduct(pbean);
		RequestDispatcher rd=request.getRequestDispatcher("ListProductController");
		rd.forward(request, response);
	}
}