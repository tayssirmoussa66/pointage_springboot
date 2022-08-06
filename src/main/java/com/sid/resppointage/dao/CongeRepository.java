package com.sid.resppointage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.resppointage.entities.Conge;

@CrossOrigin("*")
@RepositoryRestResource
@Repository 
public interface CongeRepository extends JpaRepository<Conge,Long>{
	
	  void deleteCongeById(Long id);

}
