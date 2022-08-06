package com.sid.resppointage.OrderResponse;





public class PointageList {
	

    private String date;
    private String mois;
    
    private String entree;
    private String sortie;
    private String retard;
    private String absence;

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
	public PointageList(String date, String mois, String entree, String sortie, String retard,
			String absence) {
		super();

		this.date = date;
		this.mois = mois;
		this.entree = entree;
		this.sortie = sortie;
		this.retard = retard;
		this.absence = absence;
	}
	public PointageList() {
		super();
	}
	@Override
	public String toString() {
		return "PointageList [ date=" + date + ", mois=" + mois + ", entree=" + entree + ", sortie="
				+ sortie + ", retard=" + retard + ", absence=" + absence + "]";
	}
    
}
