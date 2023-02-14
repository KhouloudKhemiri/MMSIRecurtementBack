package com.example.demo.services;

import java.util.List
;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Candidat;
import com.example.demo.Entity.RH;



public interface RHService {
public List<RH>getAllresponsable();
public RH createRH(RH rh,MultipartFile file);
public ResponseEntity<Resource> getFile(String filename);
public void Delete(Long id);
public List<RH> findByEmailAndPassword(String email,String password);
public RH updateRh(RH rh,Long id);
public RH findById(Long id);

}
