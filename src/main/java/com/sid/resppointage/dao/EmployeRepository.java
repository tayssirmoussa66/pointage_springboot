package com.sid.resppointage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.resppointage.OrderResponse.OrderResponse;
import com.sid.resppointage.entities.Employe;
@CrossOrigin("*")
@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe,Long>{
	 @RestResource(path = "/byName")
	public List<Employe> findByNom(@Param("des") String des);
	 Employe findEmployeById(Long id);
	 
	/* @Query("SELECT new com.sid.resppointage.OrderResponse(e.nom, e.prenom, c.debut_conge, c.fin_conge) FROM Employe e JOIN e.conges c")
	    public List<OrderResponse>getJoinInformation();*/
	/* @Query("SELECT new com.sid.resppointage.OrderResponse(e.nom, e.prenom, c.debut_conge, c.fin_conge) FROM Employe e INNER JOIN Conge c ON e.id=c.id_empl")
	    public List<OrderResponse> getJoinInformation();*/
	 @Query("SELECT new com.sid.resppointage.OrderResponse.OrderResponse(e.nom, e.prenom, c.debut_conge, c.fin_conge) FROM Employe e JOIN e.conges c")
	    public List<OrderResponse> getJoinInformation();
	 
	

}
