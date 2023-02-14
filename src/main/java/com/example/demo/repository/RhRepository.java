package com.example.demo.repository;

import java.util.List;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.RH;




@Repository
public interface RhRepository extends JpaRepository<RH, Long> {
	Optional<RH> findById(Long id);
	public List<RH> findByEmailAndPassword(String email, String password);
	RH findUserByEmail(String email);
}
