package com.ecommnjt.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Role {
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	@ManyToMany(mappedBy = "roles")
    private Set< User > users;
}
