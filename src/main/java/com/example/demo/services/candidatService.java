package com.example.demo.services;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Candidat;




public interface candidatService {
	public List<Candidat> getAllCandidat();
	public Candidat creatCandidat(Candidat candidat,MultipartFile file);
	public Candidat updateCondidat(Candidat candidat,Long id);
	public void deleteCondidat(Long id);
	public Candidat findCondidatById(Long id);
	public List<Candidat> findByEmailAndPassword(String email,String password);
	public ResponseEntity<Resource> getFile(String filename);
	
	

}
