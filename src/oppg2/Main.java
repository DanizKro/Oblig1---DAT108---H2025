package oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import oppg2.Ansatt.Kjonn;

public class Main {

	public static void main(String[] args) {
		
		// Lambda variabler for lønnsendring
		Function<Ansatt, Double> kroneTillegg = Ansatt -> Ansatt.getAarslonn() + 10000.00;
		Function<Ansatt, Double> prosentTillegg = Ansatt -> Ansatt.getAarslonn() * 1.05;
		
		Function<Ansatt, Double> krLavLonn = Ansatt -> {
			if (Ansatt.getAarslonn() < 150000) {
				return (double) Ansatt.getAarslonn();
			} else {
				return Ansatt.getAarslonn() * 1.0;
			}
		};
		
		Function<Ansatt, Double> krMann = Ansatt -> {
			if (Ansatt.getKjonn() == Kjonn.MANN ) {
				return Ansatt.getAarslonn() + 10000.0;
			} else {
				return Ansatt.getAarslonn() * 1.0;
			}
		};

		// Ansatt liste
		List<Ansatt> ansattList = new ArrayList<Ansatt>();

		ansattList.add(new Ansatt("Daniel", "Kron", Kjonn.MANN, "Elev", 38000));
		ansattList.add(new Ansatt("Jonas", "Nilsen", Kjonn.MANN, "Resepsjonist", 450000));
		ansattList.add(new Ansatt("Kristin", "Elling", Kjonn.KVINNE, "Admin", 505000));
		ansattList.add(new Ansatt("Henning", "Grave", Kjonn.MANN, "Vaskehjelp", 410000));
		ansattList.add(new Ansatt("Grashnik", "Bjoldiz", Kjonn.ALIEN, "Elev", 12000));

		for(Ansatt e : ansattList) {
			System.out.println(e.toString());
		}
		
		//Endrer lønnen og skriver ut på nytt
		lonnsoppgjor(ansattList, prosentTillegg);
		System.out.println("Ny lønn med 5% økning");
		
		for(Ansatt e : ansattList) {
			System.out.println(e.toString());
		}
		lonnsoppgjor(ansattList, kroneTillegg);
		System.out.println("Ny lønn med 5% økning");
		
		for(Ansatt e : ansattList) {
			System.out.println(e.toString());
		}

	}

	private static void lonnsoppgjor(List<Ansatt> ansattListe, Function<Ansatt, Double> operasjon) {

		for (Ansatt a : ansattListe) {
			Double nyLonn = operasjon.apply(a);
			a.setAarslonn(nyLonn.intValue());
		}

	}
}
