package com.sid.resppointage.entities;




import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table
public class Pointage {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    
	    private Long id;
	    @JsonBackReference
	    @ManyToOne()
	    @JoinColumn(name="empl_id")
	    private Employe employe;
	    private String date;
	    private String mois;
	    
	    private String entree;
	    private String sortie;
	    private String retard;
	    private String absence;
	    @ManyToOne()
	    private Salaire salaire;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@JsonBackReference
		public Employe getEmploye() {
			return employe;
		}
		@JsonBackReference
		public void setEmploye(Employe employe) {
			this.employe = employe;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getMois() {
			return mois;
		}
		public void setMois(String mois) {
			this.mois = mois;
		}
		public String getEntree() {
			return entree;
		}
		public void setEntree(String entree) {
			this.entree = entree;
		}
		public String getSortie() {
			return sortie;
		}
		public void setSortie(String sortie) {
			this.sortie = sortie;
		}
		public String getRetard() {
			return retard;
		}
		public void setRetard(String retard) {
			this.retard = retard;
		}
		public String getAbsence() {
			return absence;
		}
		public void setAbsence(String absence) {
			this.absence = absence;
		}
		public Salaire getSalaire() {
			return salaire;
		}
		public void setSalaire(Salaire salaire) {
			this.salaire = salaire;
		}
		public Pointage(Long id, Employe employe, String date, String mois, String entree, String sortie,
				String retard, String absence, Salaire salaire) {
			super();
			this.id = id;
			this.employe = employe;
			this.date = date;
			this.mois = mois;
			this.entree = entree;
			this.sortie = sortie;
			this.retard = retard;
			this.absence = absence;
			this.salaire = salaire;
		}
		
		
		 
		
		
		
		
		
		@Override
		public String toString() {
			return "Pointage [id=" + id + ", employe=" + employe + ", date=" + date + ", mois=" + mois + ", entree="
					+ entree + ", sortie=" + sortie + ", retard=" + retard + ", absence=" + absence + ", salaire="
					+ salaire + "]";
		}
		public Pointage() {
			super();
		}
	    
	    
}
