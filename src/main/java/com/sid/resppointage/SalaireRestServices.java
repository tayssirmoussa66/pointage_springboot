package com.sid.resppointage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.resppointage.dao.SalaireRepository;
import com.sid.resppointage.entities.Salaire;

@RestController
@CrossOrigin("*")
public class SalaireRestServices {
	@Autowired
	private SalaireRepository salaireRepository;
	
	 @GetMapping(value ="/getsalaires")
		public List<Salaire> listSalaires(){
			return salaireRepository.findAll();
	 
	 }
}
