package Bestelling;

import Producten.Product;

public class ProductBestelling {
	
	private Product product;
	private int hoeveelheid;
	
	ProductBestelling(int hoeveelheid, Product product){
		this.hoeveelheid = hoeveelheid;
		this.product = product;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Product: ")
		.append(this.getProductnaam())
		.append(", Aantal: ")
		.append(hoeveelheid)
		.append(", Prijs(Excl): ")
		.append(getPrijs(false));
		return sb.toString();
	}
	double getPrijs(boolean inclusief){
		double totaalprijs;
		if(inclusief == true){
			totaalprijs = product.getPrijs(this.hoeveelheid, true);
		}
		else{
			totaalprijs = product.getPrijs(this.hoeveelheid, false);
		}
		return totaalprijs;
	}
	public String getProductnaam(){
		return product.getNaam();
	}
	public Product getProduct(){
		return product;
	}
	public int getHoeveelheid() {
		return hoeveelheid;
	}
	public void setHoeveelheid(int hoeveelheid) {
		this.hoeveelheid = hoeveelheid;
	}
	
}
