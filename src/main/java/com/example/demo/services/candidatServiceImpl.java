package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Candidat;
import com.example.demo.cont.conteneurService;
import com.example.demo.repository.CandidatRepository;





@Service
public class candidatServiceImpl  implements candidatService{
@Autowired
private CandidatRepository candidatRepository;
@Autowired
private conteneurService conteneurService;
	@Override
	public List<Candidat> getAllCandidat() {
		
		return candidatRepository.findAll();
	}

	@Override
	public Candidat creatCandidat(Candidat candidat,MultipartFile file) {
		String fileName=conteneurService.CreateNameImage(file);
        conteneurService.store(file,fileName);
        candidat.setPhoto(fileName);
        candidat.setRole("Rh");
		return candidatRepository.save(candidat);
	}

	
		

	@Override
	public void deleteCondidat(Long id) {
		candidatRepository.deleteById(id);
		
	}

	@Override
	public Candidat findCondidatById(Long id) {
		Optional<Candidat> utOptional = candidatRepository.findById(id);
		if (utOptional.isEmpty()) {
			return null;
		}else
			return utOptional.get();
	}

	@Override
	public Candidat updateCondidat(Candidat candidat, Long id) {
		
		Candidat ut = candidatRepository.findById(id).orElse(null);
        ut.setId(id);
        ut.setNom(candidat.getNom() == null ? ut.getNom() : candidat.getNom());
        ut.setPrenom(candidat.getPrenom() == null ? ut.getPrenom() : candidat.getPrenom());
        ut.setEmail(candidat.getEmail() == null ? ut.getEmail() : candidat.getEmail());
        ut.setTel(candidat.getTel() == 0 ? ut.getTel() : candidat.getTel());
        ut.setPassword(candidat.getPassword() == null ? ut.getPassword() : candidat.getPassword());
        ut.setAdress(candidat.getAdress() == null ? ut.getAdress() : candidat.getAdress());
       
        return candidatRepository.saveAndFlush(ut);
	}

	@Override
	public List<Candidat> findByEmailAndPassword(String email, String password) {
		
		return candidatRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public ResponseEntity<Resource> getFile(String filename) {
		
		Resource file = conteneurService.loadFile(filename);//charge pdf
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
	}
	}


