package com.sid.resppointage.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
public class Employe{
	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 
	    private Long id;
	    public String nom;
	    public String prenom;
	    private String tel;
	    private String e_mail;
	    private String heure_debut;
	    private String heure_fin;
	    private String salaire_par_heure;
	    private String prime;
	    private String service;
	    private String poste;
	    private String imageUrl;
	    private String codeQR;
	    
	  
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "conges",referencedColumnName = "id")
	    List<Conge> conges = new ArrayList<>();
	    @JsonManagedReference
	    @OneToMany(mappedBy = "employe",cascade = CascadeType.ALL)
		
	    List<Pointage> pointages = new ArrayList<>();
	    @OneToMany(mappedBy = "employe",cascade = CascadeType.ALL)
	    List<Salaire> salaires = new ArrayList<>();
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		
		public String getHeure_debut() {
			return heure_debut;
		}
		public void setHeure_debut(String heure_debut) {
			this.heure_debut = heure_debut;
		}
		public String getHeure_fin() {
			return heure_fin;
		}
		public void setHeure_fin(String heure_fin) {
			this.heure_fin = heure_fin;
		}
		public String getSalaire_par_heure() {
			return salaire_par_heure;
		}
		public void setSalaire_par_heure(String salaire_par_heure) {
			this.salaire_par_heure = salaire_par_heure;
		}
		public String getPrime() {
			return prime;
		}
		public void setPrime(String prime) {
			this.prime = prime;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		public String getPoste() {
			return poste;
		}
		public void setPoste(String poste) {
			this.poste = poste;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getCodeQR() {
			return codeQR;
		}
		public void setCodeQR(String codeQR) {
			this.codeQR = codeQR;
		}
		public List<Conge> getConges() {
			return conges;
		}
		public void setConges(List<Conge> conges) {
			this.conges = conges;
		}
		
		@JsonManagedReference
		public List<Pointage> getPointages() {
			return pointages;
		}
		@JsonManagedReference
		public void setPointages(List<Pointage> pointages) {
			this.pointages = pointages;
		}
		public List<Salaire> getSalaires() {
			return salaires;
		}
		public void setSalaires(List<Salaire> salaires) {
			this.salaires = salaires;
		}
		public Employe(Long id, String nom, String prenom, String tel, String e_mail, String heure_debut,
				String heure_fin, String salaire_par_heure, String prime, String service, String poste,
				String imageUrl, String codeQR, List<Conge> conges, List<Pointage> pointages, List<Salaire> salaires) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.e_mail = e_mail;
			this.heure_debut = heure_debut;
			this.heure_fin = heure_fin;
			this.salaire_par_heure = salaire_par_heure;
			this.prime = prime;
			this.service = service;
			this.poste = poste;
			this.imageUrl = imageUrl;
			this.codeQR = codeQR;
			this.conges = conges;
			this.pointages = pointages;
			this.salaires = salaires;
		}
		
		
		
		public String getE_mail() {
			return e_mail;
		}
		public void setE_mail(String e_mail) {
			this.e_mail = e_mail;
		}
		public void addConge (Conge conge){
	        conges.add(conge);
	    }
	    public void removeConge(Conge conge){
	        conges.remove(conge);
	    }

	    public void addPointage (Pointage pointage){
	        pointages.add(pointage);
	    }
	    
	    public List<Pointage> pointageMensuel(String mois) {
	        List<Pointage> pointages = this.pointages.stream().filter(pointage -> pointage.getMois().equals(mois)).collect(Collectors.toList());
	        return pointages;
	    }
		public Employe() {
			super();
		}
		@Override
		public String toString() {
			return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", e_mail=" + e_mail
					+ ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin + ", salaire_par_heure="
					+salaire_par_heure + ", prime=" + prime + ", service=" + service + ", poste=" + poste
					+ ", imageUrl=" + imageUrl + ", codeQR=" + codeQR + ", conges=" + conges + ", pointages="
					+ pointages + ", salaires=" + salaires + "]";
		}
	    
	    
}