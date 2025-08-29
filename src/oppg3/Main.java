package oppg3;

import java.util.ArrayList;
import java.util.List;
import oppg2.Ansatt;
import oppg2.Ansatt.Kjonn;

public class Main {

	public static void main(String[] args) {
		
		List<Ansatt> ansattList = new ArrayList<Ansatt>();

		ansattList.add(new Ansatt("Daniel", "Kron", Kjonn.MANN, "Elev", 38000));
		ansattList.add(new Ansatt("Amalie", "Nilsen", Kjonn.KVINNE, "Resepsjonist", 450000));
		ansattList.add(new Ansatt("Kristin", "Elling", Kjonn.KVINNE, "Sjef", 505000));
		ansattList.add(new Ansatt("Henning", "Grave", Kjonn.MANN, "Vaskehjelp", 410000));
		ansattList.add(new Ansatt("Grashnik", "Bjoldiz", Kjonn.ALIEN, "Elev", 12000));
		
		System.out.println("Orginal liste: ");
		for(Ansatt e: ansattList) {
			System.out.println(e.toString());
		}
		
		//Lager en stream og putter bare etternavn i en ny liste
		System.out.println("\n" +"Printer ut bare etternavn i listen:");
		List<String> etternavnString = ansattList.stream()
				.map(Ansatt::getEtternavn)
				.toList();
		
		for(String e : etternavnString) {
			System.out.println(e);
		}
		
		//Teller antall Kvinner i listen av Ansatte
		System.out.print("\n" + "Antall Kvinner i listen:");
		long antall= ansattList.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE).count();
		
		System.out.println(antall+ "\n");
		
		//Gjennomsnittslønn til kvinner i listen
		System.out.print("GjennomsnittLønn for Kvinner: ");
		double gjennomsnittKvinner = ansattList.stream()
			    .filter(a -> a.getKjonn() == Kjonn.KVINNE)
			    .mapToDouble(Ansatt::getAarslonn)
			    .average()
			    .orElse(0.0);	//hvis ingen kvinner i listen må man returnere 0.0
								// kan ikke dele på 0 i gjennomsnitt
		System.out.println(gjennomsnittKvinner + "\n");
		
		
		//Øker lønnen til stilling = "Sjef"
		ansattList.stream()
	    .filter(a -> a.getStilling().equalsIgnoreCase("Sjef"))
	    .forEach(a -> a.setAarslonn((int)(a.getAarslonn() * 1.07)));
		
		System.out.println("\n"+ "Oppdatert lønn for Stilling: sjef med 7%: ");
		for(Ansatt e: ansattList) {
			System.out.println(e.toString());
		}
		
		//Tjener noen over 800k?
		boolean tjenerOver = ansattList.stream().anyMatch(p -> p.getAarslonn() > 800000);
		System.out.println("\n"+ "Har noen ansatte over 800.000 i årslønn? " + tjenerOver + "\n");
		
		//Skriver ut alle ansatt med Stream
		ansattList.stream().forEach(System.out::println);
		
		
		
		
	}
	

}
