package com.example.demo.services;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Candidature;



public interface CandidatureService {
	public List<Candidature> getAllCandidature();
	public Candidature creatCandidature(Candidature candidature, Long id_candidat,MultipartFile file);
	public Candidature updateCondidat(Candidature candidature,Long id);
	public void deleteCondidature(Long id);
	public Candidature findCondidatById(Long id);
	
	public ResponseEntity<Resource> getFile(String filename);
	
}
