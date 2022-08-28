package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AddressBean;
import com.bean.CartBean;
import com.bean.OrderBean;
import com.bean.UserBean;
import com.dao.CartDao;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardno = request.getParameter("cardno");
		String Cvv = request.getParameter("Cvv");
		int dcharge = Integer.parseInt(request.getParameter("dcharge"));
		int tamt = Integer.parseInt(request.getParameter("tamt"));
		String sadress =request.getParameter("sadress");
		String exdate = request.getParameter("exdate");
		String promocode = request.getParameter("promocode");
		int add_id = Integer.parseInt(request.getParameter("add_id"));
		CartBean cbean = new CartBean();
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("userBean");
		cbean.setId(ubean.getId());
		String email = ubean.getEmail();
		CartDao cdao = new CartDao();
		OrderBean obean = new OrderBean();
		AddressBean abean = new AddressBean();
		obean.setTotalamount(tamt);
		obean.setDeliverycharge(dcharge);
		abean.setAdd_id(add_id);
		RequestDispatcher rd = null;
		boolean isError = false;
		ApiOperationBase.setEnvironment(Environment.SANDBOX);

        // Create object with merchant authentication details
        MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
        merchantAuthenticationType.setName("58jCf8p4Fa");
        merchantAuthenticationType.setTransactionKey("32A3WrRjcUQ9367d");

        // Populate the payment data
        PaymentType paymentType = new PaymentType();
        CreditCardType creditCard = new CreditCardType();
        creditCard.setCardNumber(cardno);
        creditCard.setExpirationDate(exdate);
        paymentType.setCreditCard(creditCard);

        // Set email address (optional)
        CustomerDataType customer = new CustomerDataType();
        customer.setEmail(email);

        // Create the payment transaction object
        TransactionRequestType txnRequest = new TransactionRequestType();
        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
        txnRequest.setPayment(paymentType);
        txnRequest.setCustomer(customer);
        txnRequest.setAmount(new BigDecimal(tamt).setScale(2, RoundingMode.CEILING));

        // Create the API request and set the parameters for this specific request
        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
        apiRequest.setMerchantAuthentication(merchantAuthenticationType);
        apiRequest.setTransactionRequest(txnRequest);

        // Call the controller
        CreateTransactionController controller = new CreateTransactionController(apiRequest);
        controller.execute();

        // Get the response
        CreateTransactionResponse response1 = new CreateTransactionResponse();
        response1 = controller.getApiResponse();
        
        // Parse the response to determine results
        if (response1!=null) {
            // If API Response is OK, go ahead and check the transaction response
            if (response1.getMessages().getResultCode() == MessageTypeEnum.OK) {
                TransactionResponse result = response1.getTransactionResponse();
                if (result.getMessages() != null) {
                    System.out.println("Successfully created transaction with Transaction ID: " + result.getTransId());
                    System.out.println("Response Code: " + result.getResponseCode());
                    System.out.println("Message Code: " + result.getMessages().getMessage().get(0).getCode());
                    System.out.println("Description: " + result.getMessages().getMessage().get(0).getDescription());
                    System.out.println("Auth Code: " + result.getAuthCode());
                    request.setAttribute("pStatus","Order SuccessFully Placed");
                } else {
                    System.out.println("Failed Transaction.");
                    if (response1.getTransactionResponse().getErrors() != null) {
                        System.out.println("Error Code: " + response1.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
                        System.out.println("Error message: " + response1.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                        request.setAttribute("pStatus",response1.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                        isError = true;
                    }
                }
            } else {
                System.out.println("Failed Transaction.");
                if (response1.getTransactionResponse() != null && response1.getTransactionResponse().getErrors() != null) {
                    System.out.println("Error Code: " + response1.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
                    System.out.println("Error message: " + response1.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                    request.setAttribute("pStatus", response1.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                    isError = true;
                } else {
                    System.out.println("Error Code: " + response1.getMessages().getMessage().get(0).getCode());
                    System.out.println("Error message: " + response1.getMessages().getMessage().get(0).getText());
                    request.setAttribute("pStatus", response1.getMessages().getMessage().get(0).getText());
                }
            }
        } else {
            // Display the error code and message when response is null 
            ANetApiResponse errorResponse = controller.getErrorResponse();
            System.out.println("Failed to get response");
            if (!errorResponse.getMessages().getMessage().isEmpty()) {
                System.out.println("Error: "+errorResponse.getMessages().getMessage().get(0).getCode()+" \n"+ errorResponse.getMessages().getMessage().get(0).getText());
            }
        }
        if(isError == false)
        //return response;
        {
		cdao.ClearCart(cbean,obean,abean);
		Email from = new Email("admin@eShop.com");
		String subject = "Welcome Message";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Your Order Was SuccessFully Placed");
		Mail mail = new Mail(from, subject, to, content);
		SendGrid sg = new SendGrid("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");
		Request request1 = new Request() {
		};
		try 
		{
			request1.setMethod(Method.POST);
			request1.setEndpoint("mail/send");
			request1.setBody(mail.build());
			Response response2 = sg.api(request1);
			System.out.println(response2.getStatusCode());
			System.out.println(response2.getBody());
			System.out.println(response2.getHeaders());
		} 
		catch (IOException ex) 
		{
			throw ex;
		}
        }
		rd = request.getRequestDispatcher("ListCartController");
		rd.forward(request, response);
	}
}
