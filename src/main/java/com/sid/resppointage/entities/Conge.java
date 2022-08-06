package com.sid.resppointage.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Conge")
public class Conge {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*@ManyToOne
	@JoinColumn(name="id_empl")
	private Employe employe;*/
   /* private String nom;*/
   /* private String prenom;*/
    public String debut_conge;
    public String fin_conge;
    
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public Conge(Long id, String debut_conge, String fin_conge) {
		super();
		this.id = id;
		/*this.employe = employe;*/
		this.debut_conge = debut_conge;
		this.fin_conge = fin_conge;
	}
	/*public Employe getEmploye() {
		return employe;
	}*/
	/*public void setEmploye(Employe employe) {
		this.employe = employe;
	}*/
	public String getDebut_conge() {
		return debut_conge;
	}
	public void setDebut_conge(String debut_conge) {
		this.debut_conge = debut_conge;
	}
	public String getFin_conge() {
		return fin_conge;
	}
	public void setFin_conge(String fin_conge) {
		this.fin_conge = fin_conge;
	}
	

	
	public Conge() {
		super();
	}
	@Override
	public String toString() {
		return "Conge [id=" + id + ", debut_conge=" + debut_conge + ", fin_conge=" + fin_conge
				+ "]";
	}
	
	
}
