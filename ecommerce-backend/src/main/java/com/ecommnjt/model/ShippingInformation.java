package com.ecommnjt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="shippinginformation")
public class ShippingInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int shippingid;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String address1;
	@Getter @Setter
	private String address2;
	@Getter @Setter
	private String city;
	@Getter @Setter
	private String telephone;
}
