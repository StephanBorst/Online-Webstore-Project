package Bestelling;

import Producten.DefaultProduct;
import Producten.Product;

public class ProductBestelling {
	
	private DefaultProduct product;
	private int hoeveelheid;
	
	public ProductBestelling(int hoeveelheid, DefaultProduct product){
		this.hoeveelheid = hoeveelheid;
		this.product = product;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Product: ")
		.append(this.getProductnaam(product))
		.append(" Hoeveelheid: ")
		.append(hoeveelheid);
		return sb.toString();
	}
	public int getPrijs(boolean inclusief){
		int totaalprijs;
		if(inclusief == true){
			totaalprijs = product.getPrijs(this.hoeveelheid, true);
		}
		else{
			totaalprijs = product.getPrijs(this.hoeveelheid, false);
		}
		return totaalprijs;
	}
	public String getProductnaam(DefaultProduct obj){
		return obj.getNaam();
	}
	public int getHoeveelheid() {
		return hoeveelheid;
	}
	public void setHoeveelheid(int hoeveelheid) {
		this.hoeveelheid = hoeveelheid;
	}
	
}
