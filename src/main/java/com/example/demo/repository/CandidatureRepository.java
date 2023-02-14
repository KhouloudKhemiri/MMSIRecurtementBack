package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Candidature;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

	List<Candidature> findAll();

}
