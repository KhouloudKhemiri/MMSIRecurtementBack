package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Offre;
import com.example.demo.Entity.RH;
import com.example.demo.cont.conteneurService;
import com.example.demo.repository.OffreRepository;
import com.example.demo.repository.RhRepository;



@Service
public class OffreServiceImpl implements OffreService{
	@Autowired
	private RhRepository rhRepository;
	@Autowired
private OffreRepository offreRepository;
	@Autowired
    private conteneurService conteneurService;
	@Override
	public List<Offre> getAllPub() {
		
		return offreRepository.findAll();	}

	@Override
	public Offre createpu(Offre offre, Long id_rh, MultipartFile file) {
		String fileName=conteneurService.CreateNameImage(file);
        conteneurService.store(file,fileName);
        offre.setOffrePdf(fileName);
        RH r=rhRepository.findById(id_rh).orElse(null);
        offre.setRh(r);   
		return offreRepository.save(offre);
	}

	@Override
	public void deletepub(Long id) {
		offreRepository.deleteById(id);
		
	}

	@Override
	public ResponseEntity<Resource> getFile(String filename) {
		 Resource file = conteneurService.loadFile(filename);//charge pdf
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
	                .body(file);
	    }

}
