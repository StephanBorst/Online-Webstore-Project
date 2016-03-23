package Producten;

public class KwantumKorting extends Product {

	// ============== Instance variabelen ====================
	private String naam;
	private double prijs;
	private int voorraad;
	private int eenheid;

	// ============== Contructors ===================
	public KwantumKorting(String naam, double prijs, int voorraad, int eenheid) {
		this.naam = naam;
		this.prijs = prijs;
		this.voorraad = voorraad;
		this.eenheid = eenheid;
	}

	public KwantumKorting(String naam, double prijs, int voorraad) {
		this(naam, prijs, voorraad, 4);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naam).append(", ").append(prijs).append(" euro per ").append(Product.getEenheidNaam(this.eenheid)).append(", Voorraad: ").append(voorraad);
		return sb.toString();
	}

	// ======= Getters =====================
	@Override
	public double getPrijs(int hoeveelheid, boolean inclusief) {
		double basis;
		double prijs;
		basis = hoeveelheid * this.getPrijsPerEenheid(hoeveelheid);

		if (inclusief == true) {
			prijs = basis * getBTWPercentage()/100 + basis;
		} else {
			prijs = basis;
		}
		return prijs;
	}

	public double getPrijs(int hoeveelheid) {
		double prijs = this.getPrijsPerEenheid(hoeveelheid);
		if(hoeveelheid>100){
			prijs *= 0.8;
		}
		else if(hoeveelheid>200){
			prijs *= 0.6;
		}
		else{}
		prijs = prijs*hoeveelheid;
		return prijs;
	}

	public double getPrijs() {
		int hoeveelheid = 1;
		return this.getPrijsPerEenheid(hoeveelheid);
	}

	public double getPrijsPerEenheid(int hoeveelheid) {
			return this.prijs;
	}

	public static int getBTWPercentage() {
		return 21;
	}

	public String getNaam() {
		return naam;
	}

	public int getEenheid() {
		return eenheid;
	}

	public final int getVoorraad() {
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