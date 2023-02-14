package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Candidat;




@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long>{
	Optional<Candidat> findCondidatById (Long id);
	public List<Candidat> findByEmailAndPassword(String email, String password);
	Candidat findUserByEmail(String email);
}
