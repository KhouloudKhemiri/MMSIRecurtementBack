package com.example.demo.Controlles;

import java.util.List;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Candidat;
import com.example.demo.Entity.RH;
import com.example.demo.repository.CandidatRepository;
import com.example.demo.services.candidatService;
@CrossOrigin("*")
@RestController
@RequestMapping("/cand")
public class candidatController {
@Autowired
private candidatService candidatService;
@Autowired
private CandidatRepository candidatRepository;
@Autowired
public BCryptPasswordEncoder bCryptPasswordEncoder;
@GetMapping("/files/{filename:.+}")
@ResponseBody
public ResponseEntity<Resource> getFile(@PathVariable String filename) {
   return candidatService.getFile(filename);
}
@GetMapping
public List<Candidat> getAllCandidat(){
	return candidatService.getAllCandidat();
}
@PostMapping
public Candidat createCandidat( Candidat candidat,@RequestParam MultipartFile file) {
	String cryptedPassword = bCryptPasswordEncoder.encode(candidat.getPassword());
    candidat.setPassword(cryptedPassword);
	return candidatService.creatCandidat(candidat, file);
}
@PutMapping("/updatede/{id}")
public Candidat updateCandidat(@RequestBody Candidat candidat,@PathVariable Long id) {
	return candidatService.updateCondidat(candidat, id);
}
@PostMapping("/login")
public Candidat findBylogin(@RequestBody Candidat c){
	Candidat candidat=candidatRepository.findUserByEmail(c.getEmail());
	BCryptPasswordEncoder cryptedPassword = new BCryptPasswordEncoder();
    if (cryptedPassword.matches(c.getPassword(),candidat.getPassword())) {
		return candidat ;
	}else
	  return null;
	 
  }
@DeleteMapping("/{id}")

public void deleteUser( @PathVariable Long id) {
	candidatService.deleteCondidat(id);
}
@GetMapping(path={"/findById/{id}"})
public Candidat rechercheById(@PathVariable Long id) {
	return candidatService.findCondidatById(id);
}
}
