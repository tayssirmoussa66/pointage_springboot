package com.sid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.resppointage.dao.CongeRepository;
import com.sid.resppointage.entities.Conge;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class CongeController {
@Autowired
	private CongeRepository congeRepository;

@GetMapping(value ="/listConges")
public List<Conge> listConges(){
	return congeRepository.findAll();
}

@GetMapping(value ="/listConges/{id}")
public Conge listConges( @PathVariable(name = "id") Long id){
    return congeRepository.findById(id).get();
  }

@PutMapping (value ="/listConges/{id}")
public Conge update(@PathVariable(name = "id") Long id, @RequestBody Conge c){
    c.setId(id);
    return congeRepository.save(c);
}

 @PostMapping (value ="/listConges/{id}")
    public Conge save( @RequestBody  Conge c){
        return congeRepository.save(c);
    }
 @DeleteMapping (value ="/listConges/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        congeRepository.deleteById(id);
    }

	@GetMapping("/getconge")
	public List<Conge> getAllConge(){
		return congeRepository.findAll();
	}
	
	  @PostMapping("/conge")
	 public Conge createConge(@Validated @RequestBody Conge c)
	 {
		  return congeRepository.save(c);
	 }
	  
	
}
