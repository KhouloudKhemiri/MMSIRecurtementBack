package com.example.demo.services;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Offre;



public interface OffreService {
	public List<Offre> getAllPub();
	public Offre createpu( Offre offre, Long id_rh ,MultipartFile file);
	public void deletepub( Long id);
	public ResponseEntity<Resource> getFile(String filename);
}
