package com.ecommnjt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommnjt.model.PaymentDetails;
import com.ecommnjt.repository.PaymentDetailsRepository;

@Service
public class PaymentDetailsServiceImpl {
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;
	
	public void save(PaymentDetails paymentDetails) {
		paymentDetailsRepository.save(paymentDetails);
	}
	
	public PaymentDetails getByOrderId(int orderId) {
		Optional<PaymentDetails> optional = paymentDetailsRepository.findPaymentByOrderId(orderId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
