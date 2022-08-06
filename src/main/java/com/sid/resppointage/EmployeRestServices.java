package com.sid.resppointage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sid.resppointage.entities.Conge;
import com.sid.resppointage.entities.Employe;
import com.sid.resppointage.entities.Pointage;
import com.sid.resppointage.entities.Salaire;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sid.resppointage.OrderResponse.OrderResponse;
import com.sid.resppointage.dao.EmployeRepository;
import com.sid.resppointage.dao.PointageRepository;
import com.sid.resppointage.dao.SalaireRepository;


@RestController
@CrossOrigin("*")
public class EmployeRestServices {
	@Autowired
    ServletContext context;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private  EmployeService employeService;
	@Autowired
	private  PointageRepository pointageRepository;
	@Autowired
	private SalaireRepository salaireRepository;
	
	 @GetMapping(value ="/listsalaires")
		public List<Salaire> listSalaires(){
			return salaireRepository.findAll();
	 
	 }
	
	@GetMapping(value ="/listEmployes")
	public List<Employe> listEmployes(){
		return employeRepository.findAll();
	}
	/*@GetMapping("/getConge")
    public ResponseEntity<List<OrderResponse>> getAllConges () {
        List<OrderResponse> conges = employeService.getConge();
        return new ResponseEntity<>(conges, HttpStatus.OK);
    }
	*/
	 @GetMapping("/getConge")
	    public ResponseEntity<List<OrderResponse>> getAllConges () {
	        List<OrderResponse> conges = employeService.getConge();
	        return new ResponseEntity<>(conges, HttpStatus.OK);
	    }
	
	 
	/* @GetMapping("/getPoint")
	    public ResponseEntity<List<PointageList>> getAllPointages () {
	        List<PointageList> pointages = employeService.getPoint();
	        return new ResponseEntity<>(pointages, HttpStatus.OK);
	    }*/
	/* @PutMapping("/addPointage/{id}")
	    public ResponseEntity<List<Pointage>> addPointage(@RequestBody Pointage pointage,@PathVariable("id")Long id){
	       List<Pointage> pointages = employeService.addPointageToEmployee(id,pointage);
	        return new ResponseEntity<>(pointages, HttpStatus.OK);
	    }*/
	
	@GetMapping(value ="/listEmployes/{id}")
    public Employe listEmployes( @PathVariable(name = "id") Long id){
        return employeRepository.findById(id).get();
      }
	@PutMapping (value ="/update/{id}")
    public Employe update(@PathVariable(name = "id") Long id, @RequestBody Employe e){
        e.setId(id);
        return employeRepository.save(e);
    }
	
	 @PostMapping(value ="/listEmployes")
	    public Employe save( @RequestBody  Employe e){
	        return employeRepository.save(e);
	    }
		 
	 
	 
	 
	 @GetMapping(path = "/imageEmploye/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	    public byte[]images(@PathVariable(name="id") Long id) throws IOException {
	        Employe e =employeRepository.findById(id).get();
	        String photoName=e.getImageUrl();
	        File file = new File(System.getProperty("user.home")+"/Desktop/Stage d'été/Menuisierpro/src/assets/img/"+photoName);
	        Path path = Paths.get(file.toURI());
	        return Files.readAllBytes(path);
	    }
	
	 @GetMapping(path = "/imageCodeQR/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	    public byte[]imagesQR(@PathVariable(name="id") Long id) throws IOException {
	        Employe e =employeRepository.findById(id).get();
	        String photoName=e.getCodeQR();
	        File file = new File(System.getProperty("user.home")+"/Desktop/Stage d'été/LES testes/Menuisierpro/src/assets/img/"+photoName);
	        Path path = Paths.get(file.toURI());
	        return Files.readAllBytes(path);
	    }
	 
	 
	 @PostMapping(value ="/upload")
	    @Transactional
	    public ResponseEntity<Response> createArticle (@RequestParam("file") MultipartFile file,
	    		@RequestParam("employe") String employe) throws JsonParseException , JsonMappingException , Exception
	    {
	        System.out.println("Ok .............");
	        Employe arti = new ObjectMapper().readValue(employe, Employe.class);
	        boolean isExit = new File(context.getRealPath("/Images/")).exists();
	        if (!isExit)
	        {
	            new File (context.getRealPath("/Images")).mkdir();
	            System.out.println("mk dir.............");
	        }
	        String imageUrl = file.getOriginalFilename();
	        String newFileName = FilenameUtils.getBaseName(imageUrl)+"."+FilenameUtils.getExtension(imageUrl);
	        File serverFile = new File(System.getProperty("/Images/"+File.separator+newFileName));
	        try
	        {
	            System.out.println("Image");
	            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

	        }catch(Exception e) {
	            e.printStackTrace();
	        }


	        arti.setImageUrl(newFileName);
	        Employe art = employeRepository.save(arti);
	        if (art != null)
	        {
	            return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
	        }
	        else
	        {
	            return new ResponseEntity<Response>(new Response ("Employe not saved"),HttpStatus.BAD_REQUEST);
	        }
	    }
	    
	 @PutMapping("/addConge/{id}")
	    public ResponseEntity<OrderResponse> addConge(@RequestBody Conge conge,@PathVariable("id")Long id){
	        OrderResponse response = employeService.addCongeToEmployee(id,conge);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	 
	 }
	 
	 // Pointage
	 
	 @GetMapping(value ="/listPointage")
		public List<Pointage> listPointage(){
			return pointageRepository.findAll();
		}
	 
	 @GetMapping("/getpointageMensuel/{id}/{mois}")
	    public ResponseEntity<List<Pointage>> getPointage(@PathVariable("id")Long id, @PathVariable("mois")String mois){
	        List<Pointage> pointages = employeService.getPointageMensuel(id,mois);
	        return new ResponseEntity<>(pointages, HttpStatus.OK);
	    }
	 
	 @GetMapping("/getpointageMois/{mois}")
	    public ResponseEntity<List<Pointage>> getPointage(@PathVariable("mois")String mois){
	        List<Pointage> pointages = employeService.getPointageMensuel(mois);
	        return new ResponseEntity<>(pointages, HttpStatus.OK);
	    }
	 
	 
	 
	 @GetMapping(value="/getpointageMens/{id}" , produces="application/json")
	    public ResponseEntity<ArrayList<Pointage>> getPointage(@PathVariable("id")Long id){
		 ArrayList<Pointage> listOfPointage;
		 listOfPointage = pointageRepository.findByEmploye(employeRepository.findEmployeById(id));
	        return new ResponseEntity<ArrayList<Pointage>>(listOfPointage, HttpStatus.OK);
	    }
	
	 
	 @GetMapping("/findemploye/{empl_id}")
	    public List<Pointage> findEmploye(@PathVariable Long empl_id){
	        
	        return pointageRepository.findEmployeById(empl_id);
	    }
	 
	 
	 
	 
	 /* @GetMapping("/getpointage/{id}")
	    public ResponseEntity<List<Pointage>> getPointage(@PathVariable("id")Long id){
	        List<Pointage> pointages = employeService.getPointage(id);
	        return new ResponseEntity<>(pointages, HttpStatus.OK);
	    }*/


@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteConge (@PathVariable("id")Long id) {
    employeService.deleteConge(id);
    return new ResponseEntity<>(HttpStatus.OK);
}



public Salaire getSalaireMensuel(Long EmployeeId, String mois){
    Employe employe = employeService.findEmployeById(EmployeeId);
  /*  Salaire salaire=new Salaire(mois,HB,HS,prime,Total);*/
    Salaire salaire=new Salaire();
    Integer HB=salaire.gethb(mois);
    Integer HS=salaire.geths(mois);
    Integer prime=Integer.valueOf(employe.getPrime());
    Integer Total=salaire.calculTotal(mois);
    
  /*  employe.addSalaire(salaire);*/
    employeRepository.save(employe);
    return salaire;
}

}

