package com.ecommnjt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShippingInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String addressLineOne;
	@Getter @Setter
	private String addressLineTwo;
	@Getter @Setter
	private String city;
	@Getter @Setter
	private String telephone;
}
