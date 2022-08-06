package com.sid.Controller;


import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;


import com.sid.resppointage.dao.EmployeRepository;
import com.sid.resppointage.entities.Employe;


@RestController
@CrossOrigin("*")
public class employeController {
	
	@Autowired
	private EmployeRepository employeRepository ;

	@GetMapping("/employees")
	public List<Employe> getAllEmploye(){
		return employeRepository.findAll();
	}
	
	  @PostMapping("/create")
	 public Employe createEmploye(@Validated @RequestBody Employe e)
	 {
		  return employeRepository.save(e);
	 }
	  
		//delete
	    @DeleteMapping ("/delete/{id}")
	    public void delete(@PathVariable(name = "id") Long id){
	    	employeRepository.deleteById(id);
	    }

	    
	    
	    
	    
	    
}
