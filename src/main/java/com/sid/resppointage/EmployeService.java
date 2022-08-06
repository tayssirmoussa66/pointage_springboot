package com.sid.resppointage;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.resppointage.OrderResponse.OrderResponse;
import com.sid.resppointage.OrderResponse.PointageList;
import com.sid.resppointage.dao.CongeRepository;
import com.sid.resppointage.dao.EmployeRepository;
import com.sid.resppointage.dao.PointageRepository;
import com.sid.resppointage.entities.Conge;
import com.sid.resppointage.entities.Employe;
import com.sid.resppointage.entities.Pointage;
@Transactional
@Service
public class EmployeService {
@Autowired
private EmployeRepository employeRepository;
@Autowired
private PointageRepository pointageRepository;
@Autowired
private CongeRepository congeRepository;

public Employe findEmployeById(Long id){

    return employeRepository.findEmployeById(id);
}
	 public List<OrderResponse> getConge(){

	        return employeRepository.getJoinInformation();
	    
}
	/* public List<PointageList> getPoint(){

	        return pointageRepository.getDonneePointage();
	    
}*/
	  
	 
	 
	 
	/* public Employe addCongeToEmployee(Long id, Conge conge){
	        Employe employe = findEmployeById(id);
	        employe.addConge(conge);
	        return employe;
	    }
	 */
	 public OrderResponse addCongeToEmployee(Long EmployeeId, Conge conge){
	        Employe employe = findEmployeById(EmployeeId);
	        employe.addConge(conge);
	        employeRepository.save(employe);
	        OrderResponse Response = new com.sid.resppointage.OrderResponse.OrderResponse(employe.nom, employe.prenom, conge.debut_conge, conge.fin_conge);
	        return Response;
	    }
	 
	 
	 
	 
	 public List<Pointage>getPointage(Long id){
	        Employe employe = findEmployeById(id);
	        return employe.getPointages();
	    }
	 
	 public List<Pointage> getPointageMensuel(Long id, String mois){
	        Employe employe = findEmployeById(id);
	        return employe.pointageMensuel(mois);
	    }
	 
	 public List<Pointage> getPointageMensuel( String mois){
	       
	        return pointageRepository.findByMois(mois);
	    }
	 
	 public List<Pointage> getPointageMensuel(Long id){
	        Employe employe = findEmployeById(id);
	        return employe.getPointages();
	    }
	 
	 
	/*  public List<Pointage> addPointageToEmployee(Long EmployeeId, Pointage pointage){
	        Employe employee = findEmployeById(EmployeeId);
	        employee.addPointage(pointage);
	        employeRepository.save(employee);
	        return employee.pointages;
	    }
	  */
	 
	 
	 
	 
	/* public List<Pointage> findPointageSetByEmployeId(Long employeId) {
		 return StreamSupport.stream(pointageRepository.findAll().spliterator(), true).filter(pointage -> pointage.getEmploye().equals(employeId).collect(Collectors.toList()));
	   
	   }*/

	 
	 
	 public void deleteConge(Long id){
	        congeRepository.deleteCongeById(id);

	    }

}








