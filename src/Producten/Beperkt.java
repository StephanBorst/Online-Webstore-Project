package Producten;

public class Beperkt extends Product {

	// ============== Instance variabelen ====================
	private String naam;
	private int prijs;
	private int voorraad;
	private int eenheid;
	
	// ==============       Contructors    ===================
	public Beperkt(String naam, int prijs, int voorraad, int eenheid){
		this.naam = naam;
		this.prijs = prijs;
		this.voorraad = voorraad;
		this.eenheid = eenheid;
	}
	
	public Beperkt(String naam, int prijs, int voorraad){
		this(naam, prijs, voorraad, 4);
	}
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(naam).append(" Eenheid: ").append(eenheid).append(" Voorraad: ").append(voorraad);
	return sb.toString();
	}
	
	
	
	// =======  Getters =====================
	@Override
	public int getPrijs(int hoeveelheid, boolean inclusief) {
		int basis;
		int prijs;
		basis = hoeveelheid * this.getPrijsPerEenheid(hoeveelheid);
		
		if(inclusief == true){
			prijs = basis + basis*(this.getBTWPercentage()/100);
		}
		else{prijs = basis;}
		return prijs;
	}
	public int getPrijs(int hoeveelheid){
		int prijs = hoeveelheid * this.getPrijsPerEenheid(hoeveelheid) * (1+this.getBTWPercentage()/100);
		return prijs;
	}
	public int getPrijs(){
		int hoeveelheid = 1;
		return this.getPrijsPerEenheid(hoeveelheid);
	}
	
	public int getPrijsPerEenheid(int hoeveelheid){
		this.prijs = 100 - hoeveelheid;
		return this.prijs;
	}
	public int getBTWPercentage(){
		int btwPercentage = 21;
		return btwPercentage;
	}
	public String getNaam(){
		return naam;
	}
	public int getEenheid(){
		return eenheid;
	}
	public final int getVoorraad(){
		return voorraad;
	}

	// ======= Setters ====================
	@Override
	public void setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}

	@Override
	public void haalUitVoorraad(int aantal) {
		this.voorraad = this.voorraad - aantal;
	}

	
	

}

