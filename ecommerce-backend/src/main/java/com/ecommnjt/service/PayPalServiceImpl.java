package com.ecommnjt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.Order;
import com.ecommnjt.model.PaymentDetails;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.DetailedRefund;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Refund;
import com.paypal.api.payments.RefundRequest;
import com.paypal.api.payments.Sale;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PayPalServiceImpl {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private PaymentDetailsServiceImpl paymentDetailsService;
	
	String clientId = "AQoWOTy9wHahQ4cFb5AYqxJmr8fOZDCr4n5l96CRnRvHp2GWBboFJJ9A4rZ3w-MwYUNabKee7uIERxk0";
	String clientSecret = "EEcw1gC2dUnDM9EQgJ7nIXqHFbQcjRbVs8iaw60QfK0QUTaD8s3OCb45U2cNPwyAIfUPVbZGK0adEu2d";
	
	public Map<String, Object> createPayment(String sum){
	    Map<String, Object> response = new HashMap<String, Object>();
	    Amount amount = new Amount();
	    amount.setCurrency("USD");
	    amount.setTotal(sum);
	    Transaction transaction = new Transaction();
	    transaction.setAmount(amount);
	    List<Transaction> transactions = new ArrayList<Transaction>();
	    transactions.add(transaction);

	    Payer payer = new Payer();
	    payer.setPaymentMethod("paypal");

	    Payment payment = new Payment();
	    payment.setIntent("sale");
	    payment.setPayer(payer);
	    payment.setTransactions(transactions);
	    
	    RedirectUrls redirectUrls = new RedirectUrls();
	    redirectUrls.setCancelUrl("http://localhost:4200/");
	    redirectUrls.setReturnUrl("http://localhost:4200/order-success");
	    payment.setRedirectUrls(redirectUrls);
	    Payment createdPayment;
	    try {
	        String redirectUrl = "";
	        APIContext context = new APIContext(clientId, clientSecret, "sandbox");
	        createdPayment = payment.create(context);
	        if(createdPayment!=null){
	            List<Links> links = createdPayment.getLinks();
	            for (Links link:links) {
	                if(link.getRel().equals("approval_url")){
	                    redirectUrl = link.getHref();
	                    break;
	                }
	            }
	            response.put("status", "success");
	            response.put("redirect_url", redirectUrl);
	        }
	    } catch (PayPalRESTException e) {
	        System.out.println("Error happened during payment creation!");
	    }
	    return response;
	}
	
	public Map<String, Object> completePayment(String paymentId, String PayerID, int orderId){
	    Map<String, Object> response = new HashMap();
	    
	    Order order = orderService.getOrder(orderId);
	    
	    Payment payment = new Payment();
	    payment.setId(paymentId);

	    PaymentExecution paymentExecution = new PaymentExecution();
	    paymentExecution.setPayerId(PayerID);
	    try {
	    	APIContext context = new APIContext(clientId, clientSecret, "sandbox");
	        Payment createdPayment = payment.execute(context, paymentExecution);
	        
	        //createdPayment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId();
	        if(createdPayment!=null){
	            response.put("status", "success");
	            response.put("payment", createdPayment);
	            PaymentDetails paymentDetails = new PaymentDetails();
	            paymentDetails.setId(0);
	            paymentDetails.setSaleId(createdPayment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId());
	            paymentDetails.setOrder(order);
	            paymentDetailsService.save(paymentDetails);
	            
	        }
	    } catch (PayPalRESTException e) {
	        System.err.println(e.getDetails());
	    }
	    
	    return response;
	}
	
	public Map<String, Object> refundPayment(int orderId) {
		Map<String, Object> response = new HashMap();
		
		Order order = orderService.getOrder(orderId);
		
		RefundRequest refundRequest = new RefundRequest();
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(order.getTotalPrice()+"");
		refundRequest.setAmount(amount);
		
		PaymentDetails paymentDetails = paymentDetailsService.getByOrderId(orderId);
		
		Sale sale = new Sale();
		sale.setId(paymentDetails.getSaleId());
			
		try {
			 APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			 DetailedRefund detailedRefund = sale.refund(context, refundRequest);
			 
			 if(detailedRefund != null) {
				 response.put("status", "success");
		         response.put("refund", detailedRefund);
			 }
			  
			} catch (PayPalRESTException e) {
			  System.err.println(e.getDetails());
			}
		return response;
	}
	

}
