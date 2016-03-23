package Producten;

public class DefaultProduct extends Product {

	// ============== Instance variabelen ====================
	private String naam;
	private double prijs;
	private int voorraad;
	private int eenheid;

	// ============== Contructors ===================
	public DefaultProduct(String naam, double prijs, int voorraad, int eenheid) {
		this.naam = naam;
		this.prijs = prijs;
		this.voorraad = voorraad;
		this.eenheid = eenheid;
	}

	public DefaultProduct(String naam, double prijs, int voorraad) {
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
		basis = (double) hoeveelheid * this.getPrijsPerEenheid();

		if (inclusief == true) {
			prijs = basis*getPrijsPerEenheid()/100 + basis;
		} else {
			prijs = basis;
		}
		return prijs;
	}

	public double getPrijs(int hoeveelheid) {
		double prijs = hoeveelheid * getPrijsPerEenheid() * (1 + getBTWPercentage() / 100);
		return prijs;
	}

	public double getPrijs() {
		return this.getPrijsPerEenheid();
	}

	public double getPrijsPerEenheid() {
		return prijs;
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
