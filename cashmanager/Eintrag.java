package cashmanager.cashmanager;

import java.util.Calendar;
import java.util.Date;

public abstract class Eintrag {
	
	private int id = 0;
	private double betrag;
	private String kategorie;
	private String name;
	private java.util.Date utildatum = Calendar.getInstance().getTime();
	private java.sql.Date sqldatum = new java.sql.Date(utildatum.getTime());
	
	public abstract double betragAendern();
	
	public abstract void eintragLoeschen();

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatum() {
		return sqldatum;
	}

	public void setDatum(java.sql.Date sqldatum) {
		this.sqldatum = sqldatum;
	}
	
	public String toString() {
		String p;
		p = this.getKategorie()+"\n";
		p += this.getDatum()+"\n";
		p += this.getBetrag()+"\n";
		p += this.getName()+"\n";
		return p;
	}
	
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
