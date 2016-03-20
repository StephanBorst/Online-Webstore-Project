package Bestelling;

import java.util.ArrayList;

import Producten.DefaultProduct;

public class Winkelwagen {
	ArrayList<ProductBestelling> wagentje;
	
		
	@Override
	public String toString() {
		return wagentje.toString();
	}
	
	public int getTotaalPrijs(ArrayList<ProductBestelling> wagen, boolean inclusief){
		int totaalprijs = 0;
		for(ProductBestelling a: wagen){
		totaalprijs += a.getPrijs(inclusief);
		}
		return totaalprijs;
	}
	void bestel(DefaultProduct product, int hoeveelheid){
		ProductBestelling bestel = new ProductBestelling(hoeveelheid, product);
		wagentje.add(bestel);
		product.haalUitVoorraad(hoeveelheid);
		System.out.println("Voorraad over: " + product.getVoorraad());
	}
}
