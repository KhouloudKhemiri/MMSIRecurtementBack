package com.example.demo.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor 
public class Candidat extends Acteur {
	private String adress;
	@OneToMany(mappedBy = "candidat")
	private List<Candidature> candidatures;
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
