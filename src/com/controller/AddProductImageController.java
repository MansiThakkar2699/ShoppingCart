package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/AddProductImageController")
public class AddProductImageController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("image controller");
		int productId = 0;
		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (item.isFormField()) {
						System.out.println("field => " + item.getFieldName());
						System.out.println("object => " + item.toString());
						System.out.println("value => " + item.getString());
						productId = Integer.parseInt(item.getString());
						System.out.println("image uploading for product id " + productId);
					}
				}

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = item.getName();
						System.out.println("Name of image" + name);
						File productFolder = new File(
								"E:\\Java Workspace\\ShoppingCart2020\\WebContent\\product_images\\"
										+ productId);
						productFolder.mkdir();
						item.write(new File(productFolder, name));
					}
				}

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}

		request.getRequestDispatcher("AddProductImage.jsp").forward(request, response);
	}
}
