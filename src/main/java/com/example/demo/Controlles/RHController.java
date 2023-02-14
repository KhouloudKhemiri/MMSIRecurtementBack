package com.example.demo.Controlles;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.example.demo.Entity.RH;
import com.example.demo.repository.RhRepository;
import com.example.demo.services.RHService;



import org.springframework.core.io.Resource;


@CrossOrigin("*")
@RestController
@RequestMapping("/responsabl")
public class RHController {
	@Autowired
	private RHService rhService;
	@Autowired
	private RhRepository rhRepository;
	
	@GetMapping
	public List<RH>getAllresp(){
		return rhService.getAllresponsable();
	}
	@PostMapping
	public RH createresp(RH rh,@RequestParam MultipartFile file) {
		
		return rhService.createRH(rh, file);
	}
	
	@GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
       return rhService.getFile(filename);
    }
	@DeleteMapping("/{id}")
	public void deleteUser( @PathVariable Long id) {
		rhService.Delete(id);
	}
	@PutMapping("/updat/{id}")
	public RH updateRH(@RequestBody RH rh,@PathVariable Long id) {
		return rhService.updateRh(rh, id);
	}
	@GetMapping(path={"/findById/{id}"})
	public RH rechercheById(@PathVariable Long id) {
		return rhService.findById(id);
	}
	@PostMapping("/login")
	public RH findBylogin(@RequestBody RH r){
		RH rh=rhRepository.findUserByEmail(r.getEmail());
		BCryptPasswordEncoder cryptedPassword = new BCryptPasswordEncoder();
	    if (cryptedPassword.matches(r.getPassword(),rh.getPassword())) {
			return rh ;
		}else
		  return null;
		 
	  }
		 
	  
		  
	  }


