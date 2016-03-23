package webshop;

import java.util.ArrayList;
import java.util.Scanner;

import Bestelling.ProductBestelling;
import Bestelling.Winkelwagen;
import Producten.DefaultProduct;
import Producten.KwantumKorting;
import Producten.Product;

public class application {

	public static void main(String[] args) {

		//====== Producten Initialisaite ==========
		Product product1 = new DefaultProduct("Boek OCA Examen", 40, 1000);
		Product product2 = new DefaultProduct("Mock Examen", 10, 400);
		Product product3 = new KwantumKorting("Pen", 15 , 600, 3);
		Product product4 = new KwantumKorting("Papier", 20, 800, 1);
		Product product5 = new DefaultProduct("Beker", 18.5 , 200, 2);
		Winkelwagen wagen = new Winkelwagen();
		int bestellingcount = 0;
		Scanner s = new Scanner(System.in);
		
		
		//====== Overzicht Producten ===============
		ArrayList<Product> lijstProducten = new ArrayList<Product>();
		lijstProducten.add(product1);
		lijstProducten.add(product2);
		lijstProducten.add(product3);
		lijstProducten.add(product4);
		lijstProducten.add(product5);

		//===== Bestelling ==========================

		while (true) {
			
			//====== Product en hoeveelheid selecteren uit upgedate lijst
			for (Product product : lijstProducten) {
				System.out.println("[ " + product + " ]");
			}
			System.out.println();
			System.out.println("Selecteer een product bij naam!");
			String naam = s.nextLine();

			System.out.println("Selecteer hoeveelheid!");
			int hoeveelheid = s.nextInt();
			s.nextLine();
			
			// ===== Bestelling doen =================
			for (Product product : lijstProducten) {
				if (product.getNaam().equals(naam) && hoeveelheid <= product.getVoorraad()) {
					wagen.bestel(product, hoeveelheid);
				}
			}
			bestellingcount++;
			
			// ===== Bestelling check, onjuist bestellingcount -1 ================
			if(wagen.getWinkelwagen().size() < bestellingcount){
				System.out.println("Onjuiste naam of hoeveelheid ingevoerd");
				bestellingcount--;
				continue;
			} 
			/*
			System.out.println("Wagentje op dit moment:");
			for (ProductBestelling bestelling : wagen.getWinkelwagen()) {
				System.out.println(wagen.getWinkelwagen().indexOf(bestelling)+1 + ":) [ "+ bestelling + " ]");
			}*/
			
			for(int i=0; i<wagen.getWinkelwagen().size();i++){
				for(int j = i+1;j<wagen.getWinkelwagen().size();j++){
					if(wagen.getWinkelwagen().get(i).getProductnaam().equals(wagen.getWinkelwagen().get(j).getProductnaam())){
						wagen.getWinkelwagen().get(i).setHoeveelheid(wagen.getWinkelwagen().get(i).getHoeveelheid()+wagen.getWinkelwagen().get(j).getHoeveelheid());
						wagen.getWinkelwagen().remove(j);
					}
				}
			}
			System.out.println("Wagentje op dit moment:");
			for (ProductBestelling bestelling : wagen.getWinkelwagen()) {
				System.out.println(wagen.getWinkelwagen().indexOf(bestelling)+1 + ":) [ "+ bestelling + " ]");
			}
			
			//============== Hoeveelheid kunnen aanpassen======================================
			System.out.println("Hoeveelheid aanpassen? ja of nee");
			
			if(s.nextLine().contains("ja")){
				
				System.out.println("Selecteer Productregel");
				int productregel = s.nextInt();
				int verschilhoeveelheid = wagen.getWinkelwagen().get(productregel-1).getHoeveelheid();
				System.out.println("Selecteer nieuwe hoeveelheid");
				int nieuwehoeveelheid = s.nextInt();
				s.nextLine();
				// Nieuwe hoeveelheid en bijbehorende voorraad updaten
				wagen.getWinkelwagen().get(productregel-1).setHoeveelheid(nieuwehoeveelheid);
				verschilhoeveelheid = verschilhoeveelheid - wagen.getWinkelwagen().get(productregel-1).getHoeveelheid();
				wagen.getWinkelwagen().get(productregel-1).getProduct().setVoorraad(wagen.getWinkelwagen().get(productregel-1).getProduct().getVoorraad()+verschilhoeveelheid);
				
				// Print wagen
				System.out.println("Wagentje op dit moment:");
				for (ProductBestelling bestelling : wagen.getWinkelwagen()) {
					System.out.println(wagen.getWinkelwagen().indexOf(bestelling)+1 + ":) [ "+ bestelling + " ]");
				}
			}
	
			
			// =============== Einde Bestelling opvragen ================================================
			System.out.println();
			System.out.println("Klaar met bestelling? ja of nee");
			String beslissing = s.nextLine();

			if(beslissing.contains("ja")){
			
			break;
			}
		}
		
		//=============== Producten kunnen verwijderen =============================================
		System.out.println("Product verwijderen? ja of nee");
			while(s.nextLine().contains("ja")){
			System.out.println("Selecteer Productregel");
			int productregel = s.nextInt();
			wagen.getWinkelwagen().remove(productregel-1);
			System.out.println("Wagentje op dit moment:");
			for (ProductBestelling bestelling : wagen.getWinkelwagen()) {
				System.out.println(wagen.getWinkelwagen().indexOf(bestelling)+1 + ":) [ "+ bestelling + " ]");
			}
			System.out.println("Nog een product verwijderen? ja of nee");
		}
		
		// =========== Definitieve winkelwagen ===================================
		s.close();
		System.out.println("Definitieve winkelwagen: ");
		for (ProductBestelling bestelling : wagen.getWinkelwagen()) {
			System.out.println(wagen.getWinkelwagen().indexOf(bestelling)+1 + ":) [ "+ bestelling + " ]");
		}
		
		// ============ Prijs Berekening =======================================
		System.out.println("Totaal(Excl): " + wagen.getTotaalPrijs(wagen.getWinkelwagen(), false));
		System.out.println("BTW: " + (wagen.getTotaalPrijs(wagen.getWinkelwagen(), true) - wagen.getTotaalPrijs(wagen.getWinkelwagen(), false)));
		System.out.println("Totaal(Incl): " + wagen.getTotaalPrijs(wagen.getWinkelwagen(), true));

	}

}
