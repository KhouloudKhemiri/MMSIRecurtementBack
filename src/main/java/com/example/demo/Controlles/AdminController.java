package com.example.demo.Controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Admin;
import com.example.demo.cont.conteneurService;
import com.example.demo.repository.AdminRepository;

@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private conteneurService conteneurService;
	@GetMapping("/findbyid/{id}")
	public Admin findById(@PathVariable Long id) {
		return adminRepository.findById(id).orElse(null);
	}
	@PutMapping("/up/{id}")
	 public Admin update(@RequestBody Admin admin,@PathVariable Long id){
        Admin cl = adminRepository.findById(id).orElse(null);
        cl.setId(id);
        cl.setNom(admin.getNom() == null ? cl.getNom() : admin.getNom());
        cl.setPrenom(admin.getPrenom() == null ? cl.getPrenom() : admin.getPrenom());
        cl.setEmail(admin.getEmail() == null ? cl.getEmail() : admin.getEmail());
        cl.setPassword(admin.getPassword() == null ? cl.getPassword() : admin.getPassword());
        return adminRepository.saveAndFlush(cl);
}
	 @PostMapping("/addAdmin")
	    public Admin addAdmin(Admin admin, @RequestParam MultipartFile file){
	        String fileName=conteneurService.CreateNameImage(file);
	       conteneurService.store(file,fileName);
	        admin.setPhoto(fileName);
	        admin.setRole("admin");
	       
	        return adminRepository.save(admin);
	    }


}
