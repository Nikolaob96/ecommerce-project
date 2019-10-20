package com.ecommnjt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommnjt.model.Order;
import com.ecommnjt.model.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer>{
	
	@Query("select s from PaymentDetails s where orderId=?1")
	Optional<PaymentDetails> findPaymentByOrderId(@Param("orderId") int id);
}
