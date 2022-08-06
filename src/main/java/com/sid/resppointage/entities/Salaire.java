package com.sid.resppointage.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Salaire{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String mois;
    @ManyToOne
    @JoinColumn(name="id_empl")
    private Employe employe;
    private String heures_de_base;
    private String heures_sup;
    private String primes;
    private String Total;
    @OneToMany(mappedBy ="salaire")
    private List<Pointage> pointages = new ArrayList<>();

	    public Salaire() {
	    }

	   
	    
	    public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getMois() {
			return mois;
		}



		public void setMois(String mois) {
			this.mois = mois;
		}



		public Employe getEmploye() {
			return employe;
		}



		public void setEmploye(Employe employe) {
			this.employe = employe;
		}



		public String getHeures_de_base() {
			return heures_de_base;
		}



		public void setHeures_de_base(String heures_de_base) {
			this.heures_de_base = heures_de_base;
		}



		public String getHeures_sup() {
			return heures_sup;
		}



		public void setHeures_sup(String heures_sup) {
			this.heures_sup = heures_sup;
		}



		public String getPrimes() {
			return primes;
		}



		public void setPrimes(String primes) {
			this.primes = primes;
		}



		public String getTotal() {
			return Total;
		}



		public void setTotal(String total) {
			Total = total;
		}



		public List<Pointage> getPointages() {
			return pointages;
		}



		public void setPointages(List<Pointage> pointages) {
			this.pointages = pointages;
		}



		public Salaire(Long id, String mois, Employe employe, String heures_de_base, String heures_sup, String primes,
				String total, List<Pointage> pointages) {
			super();
			this.id = id;
			this.mois = mois;
			this.employe = employe;
			this.heures_de_base = heures_de_base;
			this.heures_sup = heures_sup;
			this.primes = primes;
			Total = total;
			this.pointages = pointages;
		}
//calcul de salaire
		 public List<Pointage> pointageMensuel(String mois) {
		        List<Pointage> pointages = this.pointages.stream().filter(pointage -> pointage.getMois().equals(mois)).collect(Collectors.toList());
		        return pointages;
		    }
		    public Integer gethb(String mois){
		        List<Pointage> pointages=this.pointageMensuel(mois);
		        Integer heures_de_base=0;

		        for(Pointage p :pointages){
		        	heures_de_base+=8;

		        }
		        return heures_de_base;
		    }

		    public Integer geths(String mois){
		        List<Pointage> pointages=this.pointageMensuel(mois);
		        Integer heure_sup=0;

		        for(Pointage p :pointages){
		            Integer pas=(Integer.valueOf(p.getSortie())-Integer.valueOf(p.getEntree()));
		            if (pas>8){
		                heure_sup+=(pas-8);
		            }
		        }
		        return heure_sup;
		    }

		    public Integer calculTotal(String mois){
		        Integer HB = this.gethb(mois);
		        Integer HS = this.geths(mois);
		        Integer SB = Integer.valueOf(employe.getSalaire_par_heure());
		      
		        Integer prime = Integer.valueOf(this.getPrimes());
		        Integer Total = HB*SB + HS*SB + prime;
		        return Total;

		    }

		/*public Integer gethb(List<Pointage> pointages){
	        Integer heure_base=0;

	        for(Pointage p :pointages){
	            Integer pas= p.getSortie()- p.getEntree();
	            if (pas<=8){
	                heure_base+=pas;
	            }
	        }
	        return heure_base;
	    }

	 /*   public Integer geths(List<Pointage> pointages){

	        Integer heure_sup=0;

	        for(Pointage p :pointages){
	            Integer pas= p.getSortie()- p.getEntree();
	            if (pas>8){
	                heure_sup+=(pas-8);
	            }
	        }
	        return heure_sup;
	    }

*/

		@Override
		public String toString() {
			return "Salaire [id=" + id + ", mois=" + mois + ", employe=" + employe + ", heures_de_base="
					+ heures_de_base + ", heures_sup=" + heures_sup + ", primes=" + primes + ", Total=" + Total
					+ ", pointages=" + pointages + "]";
		}
	   
	    
	    
	}
