package com.ecommnjt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
   
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String username;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String email;
	@Getter @Setter
	//@Transient
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinTable(
       name="user_role",
       joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
       inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private Set<Role> roles = new HashSet<>();
	
	
}
