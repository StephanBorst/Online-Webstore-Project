package Producten;

public abstract class Product {

	// ========= Constants===========
	static final int gram = 1;
	static final int kilo = 2;
	static final int liter = 3;
	static final int stuk = 4;
	static final int pak = 5;

	// ========= Variables============

	public abstract String toString();

	public abstract double getPrijs(int hoeveelheid, boolean inclusief);

	public abstract double getPrijs(int hoeveelheid);

	public abstract double getPrijs();

	public abstract String getNaam();

	public abstract void setVoorraad(int voorraad);

	public abstract void haalUitVoorraad(int aantal);

	public static String getEenheidNaam(int eenheid) {
		String soort;
		switch (eenheid) {
		case 1:
			soort = "gram";
			break;
		case 2:
			soort = "kilo";
			break;
		case 3:
			soort = "liter";
			break;
		case 4:
			soort = "stuk";
			break;
		case 5:
			soort = "pak";
			break;
		default:
			soort = null;
			break;
		}
		return soort;
	}

	public abstract int getVoorraad();
	

}
