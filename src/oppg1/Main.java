package oppg1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		// a
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

		// Usortert Liste
		for(String e : listen) {
			System.out.print(e + ", ");
		}
		
		Collections.sort(listen, (a,b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
		System.out.println();
		
		// Sortert Liste
		for(String e : listen) {
			System.out.print(e + ", ");
		}
		
		
		// b
		// Lambda utrykkene lagert i variabler
		BiFunction<Integer,Integer,Integer> summerFunksjon = (a,b) -> a+b;
		BiFunction<Integer,Integer,Integer> denStorste = (a,b) -> Math.max(a,b);
		BiFunction<Integer,Integer,Integer> avstand = (a,b) -> Math.abs(a-b);
		
		System.out.println();
		System.out.println(beregn(12,13, summerFunksjon));
		System.out.println(beregn(-5,3, denStorste));
		System.out.println(beregn(54,45, avstand));
		
		
		
	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> fu) {
		
		return fu.apply(a,b);
		}

}
