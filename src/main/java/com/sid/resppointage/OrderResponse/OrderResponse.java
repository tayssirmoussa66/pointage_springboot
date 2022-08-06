package com.sid.resppointage.OrderResponse;

public class OrderResponse {
	    private String nom;
	    private String prenom;
	    private String debut_conge;
	    private String fin_conge;
	    
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

		public OrderResponse() {
			super();
		}

		public OrderResponse(String nom, String prenom, String debut_conge, String fin_conge) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.debut_conge = debut_conge;
			this.fin_conge = fin_conge;
		}

		@Override
		public String toString() {
			return "OrderResponse [nom=" + nom + ", prenom=" + prenom + ", debut_conge=" + debut_conge + ", fin_conge="
					+ fin_conge + "]";
		}
	    

}
