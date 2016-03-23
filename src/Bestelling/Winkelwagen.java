package Bestelling;

import java.util.ArrayList;

import Producten.Product;

public class Winkelwagen {
	

	private ArrayList<ProductBestelling> wagentje;
	
	public Winkelwagen(){
		this.wagentje = new ArrayList<ProductBestelling>();
	}
	
	@Override
	public String toString() {
		return wagentje.toString();
	}
	
	public int getTotaalPrijs(ArrayList<ProductBestelling> wagen, boolean inclusief){
		int totaalprijs = 0;
		for(ProductBestelling bestelling: wagen){
		totaalprijs += bestelling.getPrijs(inclusief);
		}
		return totaalprijs;
	}
	
	public void bestel(Product product, int hoeveelheid){
		product.haalUitVoorraad(hoeveelheid);
		ProductBestelling bestel = new ProductBestelling(hoeveelheid, product);
		wagentje.add(bestel);
		}
	
	public ArrayList<ProductBestelling> getWinkelwagen(){
		return this.wagentje;
	}

}
