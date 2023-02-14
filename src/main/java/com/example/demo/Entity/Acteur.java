package com.example.demo.Entity;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


public class Acteur{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private  String nom;
	private String prenom;
	private int tel;
	private String email;
	private String password;
	private String Role;
	private String photo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	


}
