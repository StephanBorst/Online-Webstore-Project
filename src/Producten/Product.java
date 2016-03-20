package Producten;

public abstract class Product {
	
	static final int gram = 1;
	static final int kilo = 2;
	static final int liters = 3;
	static final int stuk = 4;
	static final int pak = 5;
	
	public abstract String toString();
	
	public abstract int getPrijs(int hoeveelheid, boolean inclusief);
	
	public abstract int getPrijs(int hoeveelheid);
	
	public abstract int getPrijs();
	
	public abstract void setVoorraad(int voorraad);
	
	public abstract void haalUitVoorraad(int aantal);		
	
	public final String getEenheidNaam(int eenheid){
		String soort;
		switch(eenheid){
		case 1: soort = "gram";
		case 2: soort = "kilo";
		case 3: soort = "liters";
		case 4: soort = "stuk";
		case 5: soort = "pak";
		default: soort = null;
		return soort;
		}
		}
	
}
