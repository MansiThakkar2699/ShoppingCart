package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
 
@WebServlet("/ProductReportController")
public class ProductReportController extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //compiling jrxml file 
	   String path = "D://ProductList.pdf";
	   String sourceFileName = "E:\\Java Workspace\\ShoppingCart2020\\src\\reports\\Product.jrxml";
	   
	   try {
	   	JasperReport jasperReport = null;
	    jasperReport = JasperCompileManager.compileReport(sourceFileName);
	    Map<String,Object> params = new HashMap<String,Object>();

	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, DbConnection.getConnection());	
	        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
	   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   //pdf 
	   //pdf send browser -> download 
	   File f = new File(path);
	   response.setContentType("application/pdf");
	   response.setHeader("Content-Disposition","inline;filename=ProductList.pdf");
	   response.setContentLength((int) f.length());
	   response.setHeader("Content-Length", String.valueOf(f.length()));
	   //FileInputStream in = new FileInputStream(f);
	   Files.copy(f.toPath(), response.getOutputStream());
   }

}
