package com.ecommnjt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "paymentdetails")
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	@Column(name="Id")
	private int id;
	@Getter @Setter
	@Column(name="saleid")
	private String saleId;
	@Getter @Setter
	@OneToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "orderid")
	private Order order;
}
