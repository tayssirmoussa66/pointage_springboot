package com.sid.resppointage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.resppointage.entities.Salaire;

@CrossOrigin("*")
@RepositoryRestResource
public interface SalaireRepository extends JpaRepository<Salaire,Long>{

	
	@RestResource(path = "/byMois")
	public List<Salaire> findByMois(@Param("des") String des);
}
