package com.example.demo.Controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Offre;
import com.example.demo.cont.conteneurService;
import com.example.demo.services.OffreService;
@CrossOrigin("*")
@RestController
@RequestMapping("/off")
public class OffreController {
	@Autowired
	private OffreService offreService;
	@Autowired
	private conteneurService conteneurService;
	@GetMapping
	public List<Offre> GetAll(){
		return offreService.getAllPub();
	}
	@PostMapping("/crepu/{id_rh}")
	public Offre creatOffer(Offre offre ,@PathVariable Long id_rh,@RequestParam MultipartFile file) {
		return offreService.createpu(offre, id_rh, file);
	}
@DeleteMapping(path="/{id}")
public void deletePub(@PathVariable Long id) {
	offreService.deletepub(id);
	}
@GetMapping("/files/{filename:.+}")
@ResponseBody
public ResponseEntity<Resource> getFile(@PathVariable String filename) {
   return offreService.getFile(filename);
}
}
