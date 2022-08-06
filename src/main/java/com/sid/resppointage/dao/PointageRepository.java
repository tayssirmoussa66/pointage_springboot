package com.sid.resppointage.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.resppointage.OrderResponse.PointageList;
import com.sid.resppointage.entities.Employe;
import com.sid.resppointage.entities.Pointage;

@CrossOrigin("*")
@RepositoryRestResource
@Repository
public interface PointageRepository extends JpaRepository<Pointage,Long>{
	 @RestResource(path = "/byMois")
		public List<Pointage> findByMois(@Param("des") String des);
 @RestResource(path = "/byIdempl")
	 public List<Pointage> findById(@Param("employe") Employe employe);
	List<Pointage> findEmployeById(Long empl_id);
	
	
	
	 public ArrayList<Pointage> findByEmploye(Employe employe);
	
	/* @Query("SELECT new com.sid.resppointage.OrderResponse.PointageList(e.id, p.date, p.mois, p.entree,p.sortie,p.retard,p.absence) FROM Pointage p JOIN p.employe")
	    public List<PointageList> getDonneePointage();*/
}
