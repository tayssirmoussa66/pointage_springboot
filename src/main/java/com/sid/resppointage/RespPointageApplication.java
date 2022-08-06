package com.sid.resppointage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sid.resppointage.OrderResponse.OrderResponse;
import com.sid.resppointage.dao.CongeRepository;
import com.sid.resppointage.dao.EmployeRepository;
import com.sid.resppointage.dao.PointageRepository;
import com.sid.resppointage.dao.SalaireRepository;
import com.sid.resppointage.entities.Conge;
import com.sid.resppointage.entities.Employe;
import com.sid.resppointage.entities.Pointage;
import com.sid.resppointage.entities.Salaire;

@SpringBootApplication
public class RespPointageApplication implements CommandLineRunner{
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	@Autowired
	private CongeRepository congeRepository;
	@Autowired
	private SalaireRepository salaireRepository;
	@Autowired
	private PointageRepository pointageRepository;
	public static void main(String[] args) {
		SpringApplication.run(RespPointageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Employe.class);
	/*	employeRepository.save(new Employe(null,"Jebr","Ahmed","23454156","ahmed@gmail.com","08:00","12:00","20","5","technique","ouvrier","employe14.jpg","code1.jpg"));
		employeRepository.save(new Employe(null,"Mimouni","Mourad","23789456","mimouni@gmail.com","14:00","18:00","10","7","Informatique","ouvrier","employe2.jpg","code2.jpg"));
		employeRepository.save(new Employe(null,"Sliti","Amir","23785156","amirsl@gmail.com","10:00","14:00","7","5","technique","ingénieur","employe3.jpg","code3.jpg"));
		employeRepository.save(new Employe(null,"Wesleti","Anwer","55425892","anwerwslti@gmail.com","10:00","14:00","7","5","technique","ouvrier","employe4.jpg","code4.jpg"));
		employeRepository.save(new Employe(null,"Dridi","Kamel","22245633","dridi@gmail.com","14:00","18:00","15","5","technique","ingénieur","employe5.jpg","code5.jpg"));
		employeRepository.save(new Employe(null,"Sliti","Rayen","29555123","rayenl@gmail.com","10:00","14:00","18","10","technique","ingénieur","employe6.jpg","code6.jpg"));
		employeRepository.save(new Employe(null,"Warteni","Mohamed","95425631","warteni@gmail.com","10:00","14:00","7","5","technique","ouvrier","employe15.jpg","code7.jpg"));
		employeRepository.save(new Employe(null,"Dridi","Aymen","92292156","dridi0@gmail.com","10:00","14:00","7","5","technique","ouvrier","employe8.jpg","code8.jpg"));
		employeRepository.save(new Employe(null,"Slama","Rayen","23454152","rayenslama@gmail.com","08:00","14:00","25","10","Informatique","ouvrier","employe9.jpg","code9.jpg"));
		employeRepository.save(new Employe(null,"Dridi","Adel","23457896","adel@gmail.com","10:00","14:00","7","5","technique","ingénieur","employe10.jpg","code10.jpg"));
		employeRepository.save(new Employe(null,"Shili","Amir","23785156","shlamir@gmail.com","10:00","14:00","7","5","Informatique","ouvrier","employe11.jpg","code11.jpg"));
		employeRepository.save(new Employe(null,"Touati","Samir","23785156","samir@gmail.com","10:00","18:00","22","9","technique","technicien","employe13.jpg","code12.jpg"));
		
		
		employeRepository.findAll().forEach(e->{
			System.out.println(e.toString());
		});*/
		restConfiguration.exposeIdsFor(OrderResponse.class);
		
		restConfiguration.exposeIdsFor(Conge.class);
	//	congeRepository.save(new Conge(null,null,"Dridi","Aymen","2021-07-12","2021-07-19"));
		
	/*congeRepository.save(new Conge(null,126,"2021-07-19","2021-08-10"));
		congeRepository.save(new Conge(null,130,"2021-07-25","2021-08-08"));
		congeRepository.save(new Conge(null,136,"2021-08-02","2021-08-15"));
		congeRepository.save(new Conge(null,133,"2021-08-09","2021-08-19"));
		congeRepository.save(new Conge(null,134,"2021-08-20","2021-08-30"));
		congeRepository.save(new Conge(null,131,"2021-09-02","2021-09-10"));
		
		
		congeRepository.findAll().forEach(c->{
			System.out.println(c.toString());
		});*/
		restConfiguration.exposeIdsFor(Salaire.class);
	
	/*	salaireRepository.save(new Salaire())   */
		
		
		restConfiguration.exposeIdsFor(Pointage.class);
	/*	pointageRepository.save(new Pointage(null,null,"2021-09-01","08:45","17:00","15min","oui"));
		pointageRepository.save(new Pointage(null,null,"2021-09-02","08:30","EN ATTEND","",""));*/
	}

}
