package com.example.demo.Controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.Entity.Candidature;
import com.example.demo.cont.conteneurService;
import com.example.demo.services.CandidatureService;

@CrossOrigin("*")
@RestController
@RequestMapping("/candidature")
public class CandidatureController {
	@Autowired
	private CandidatureService candidatureService;

	@Autowired
	private conteneurService conteneurService;
	@GetMapping
	public List<Candidature>getAllCandidature(){
		return candidatureService.getAllCandidature();
	}
	@PostMapping("/crepu/{id_candidat}")
	public Candidature createCandidat( Candidature candidature,@PathVariable Long id_candidat,@RequestParam MultipartFile file) {
		
	    
		return candidatureService.creatCandidature(candidature, id_candidat, file);

}
@DeleteMapping
public void deleteUser( @PathVariable Long id) {
	candidatureService.deleteCondidature(id);

}}
