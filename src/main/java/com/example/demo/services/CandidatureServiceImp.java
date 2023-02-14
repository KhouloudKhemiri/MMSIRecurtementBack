package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Candidat;
import com.example.demo.Entity.Candidature;


import com.example.demo.cont.conteneurService;
import com.example.demo.repository.CandidatRepository;
import com.example.demo.repository.CandidatureRepository;

@Service
public class CandidatureServiceImp implements CandidatureService{
	@Autowired
private CandidatureRepository candidatureRepository;
	@Autowired
	private CandidatRepository candidatRepository;
	@Autowired
	private conteneurService conteneurService;
	@Override
	public List<Candidature> getAllCandidature() {
		
		return candidatureRepository.findAll();
	}

	@Override
	public Candidature creatCandidature(Candidature candidature, Long id_candidat, MultipartFile file) {
		String fileName=conteneurService.CreateNameImage(file);
        conteneurService.store(file,fileName);
        candidature.setCV(fileName);
        Candidat c=candidatRepository.findById(id_candidat).orElse(null);
        candidature.setCandidat(c);   
		return candidatureRepository.save(candidature);
	}

	@Override
	public Candidature updateCondidat(Candidature candidature, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCondidature(Long id) {
		candidatureRepository.deleteById(id);
		
	}

	@Override
	public Candidature findCondidatById(Long id) {
		
		return null;
	}

	@Override
	public ResponseEntity<Resource> getFile(String filename) {
		Resource file = conteneurService.loadFile(filename);//charge pdf
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
	}

	

}
