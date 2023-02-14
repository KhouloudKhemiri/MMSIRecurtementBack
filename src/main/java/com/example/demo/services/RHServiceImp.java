
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.Entity.RH;
import com.example.demo.cont.conteneurService;
import com.example.demo.repository.RhRepository;





@Service
public class RHServiceImp implements RHService{
	@Autowired
	private RhRepository rhRepository;
	
		@Autowired
	    private conteneurService conteneurService;
		@Autowired
	    public JavaMailSender javaMailSender;
		@Autowired
	    public BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public List<RH> getAllresponsable() {
		
		return rhRepository.findAll();
	}

	@Override
	public RH createRH(RH rh, MultipartFile file) {
		 String pass=rh.getPassword();
		String cryptedPassword = bCryptPasswordEncoder.encode(rh.getPassword());
        rh.setPassword(cryptedPassword);
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(rh.getEmail());
        msg.setSubject("welcome to MMSIGroup");
        msg.setText("Bonjour  "+rh.getNom() +"  "+ rh.getPrenom() +" "+rh.getPhoto()
                    +"\n Votre Inscription effectuer avec succés aves les coordonnés: \n "
        		    +"Login : "+ rh.getEmail()+"\n PassWord : "+ pass+
        		
        		
        		
        		"\n \n \n Trés Coordialement ");

        javaMailSender.send(msg);
        
		String fileName=conteneurService.CreateNameImage(file);
        conteneurService.store(file,fileName);
        rh.setPhoto(fileName);
        rh.setRole("Rh");
       
		return rhRepository.save(rh);
	}

	@Override
	public ResponseEntity<Resource> getFile(String filename) {
		
		 Resource file = conteneurService.loadFile(filename);//charge pdf
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
	                .body(file);
	}

	@Override
	public List<RH> findByEmailAndPassword(String email, String password) {
		
		return rhRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void Delete(Long id) {
		rhRepository.deleteById(id);
		
	}

	@Override
	public RH updateRh(RH rh, Long id) {
		
		RH ut = rhRepository.findById(id).orElse(null);
        ut.setId(id);
        ut.setNom(rh.getNom() == null ? ut.getNom() : rh.getNom());
        ut.setPrenom(rh.getPrenom() == null ? ut.getPrenom() : rh.getPrenom());
        ut.setEmail(rh.getEmail() == null ? ut.getEmail() : rh.getEmail());
        ut.setTel(rh.getTel() == 0 ? ut.getTel() : rh.getTel());
        ut.setPassword(rh.getPassword() == null ? ut.getPassword() : rh.getPassword());
        
       
        return rhRepository.saveAndFlush(ut);
	}

	@Override
	public RH findById(Long id) {
		
		Optional<RH> utOptional = rhRepository.findById(id);
		if (utOptional.isEmpty()) {
			return null;
		}else
			return utOptional.get();
	}
	}


