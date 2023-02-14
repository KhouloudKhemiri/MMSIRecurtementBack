package com.example.demo.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Candidature implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
private Long id;



private String description;
private String niveau;
private String competence;
private String expérience;
private  String CV;
private int active;
private LocalDate date=LocalDate.now();

@ManyToOne
@JoinColumn(name="candidat_id")
private Candidat candidat;
public Candidat getCandidat() {
	return candidat;
}
public void setCandidat(Candidat candidat) {
	this.candidat = candidat;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getNiveau() {
	return niveau;
}
public void setNiveau(String niveau) {
	this.niveau = niveau;
}
public String getCompetence() {
	return competence;
}
public void setCompetence(String competence) {
	this.competence = competence;
}
public String getExpérience() {
	return expérience;
}
public void setExpérience(String expérience) {
	this.expérience = expérience;
}
public String getCV() {
	return CV;
}
public void setCV(String cV) {
	CV = cV;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}

}
