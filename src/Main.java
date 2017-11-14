import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			int nbMot = sc.nextInt();
			sc.nextLine();
			String[] mots = new String[nbMot];

			Set<Character> premier = new TreeSet<>();
			for (int i = 0; i < nbMot; i++) {
				mots[i] = sc.nextLine();
				premier.add(mots[i].charAt(0));
			}

			boolean plusGrand = false;
			for (int i = 0; i < nbMot; i++) {
				if(mots[nbMot-1].length() > mots[i].length()) {
					plusGrand = true;
				}
				if(mots[nbMot-1].length() < mots[i].length()) {
					return;
					//Probleme niveau du dernier mot trop petit
				}
			}
			
			if(plusGrand) {
				//Alors Premiere lettre du mot = 1 ou 0 
			}
			
			System.out.println(Arrays.asList(mots));

			Set<Character> lettres = new TreeSet<>();

			for (String mot : mots) {
				for (char c : mot.toCharArray()) {
					lettres.add(c);
				}
			}
			

			System.out.println(lettres);
			Character[] mot = new Character[lettres.size()];
			lettres.toArray(mot);

			Integer[] valeur = new Integer[lettres.size()];
			for (int i = 0; i < valeur.length; i++) {
				valeur[i] = 0;
			}
		/*
			for(int n : valeur) {
			
				System.out.print(n + " ");
			}
		*/
			testAll(mot, valeur, premier, 0, mots);
		/*
			System.out.println(Arrays.asList(premier));
			System.out.println(Arrays.asList(valeur));
		*/
		}

	}

	public static void testAll(Character[] ensembleDesLettresMot, Integer[] value, Set<Character> premier, int n, String[] mots) {

		if (n == ensembleDesLettresMot.length) {
			HashMap<Character, Integer> mapCharacter = findSolution(value,ensembleDesLettresMot);
			testCas(mapCharacter, mots);
		//	System.out.println(Arrays.asList(value));
			return;
		}

		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < n; j++) {
				
				/*if(premier.contains(ensembleDesLettresMot[j])) {
					value[j]=1;
					continue outer;
				}*/
				if (value[j] == i) {
					continue outer;
				}
			}
			
			
			value[n] = i;
			testAll(ensembleDesLettresMot, value,premier, n + 1, mots);
		}

	}
	
	public static HashMap<Character, Integer> findSolution(Integer[] value,Character[] ensembleDesLettresMot) {
		HashMap<Character, Integer> mapCharacter = new HashMap<>();
		for(int i =0; i<value.length ; i++) {
			mapCharacter.put(ensembleDesLettresMot[i], value[i]);
		}
		System.out.println(Arrays.asList(mapCharacter).toString());
		//System.out.println(mapCharacter.toString());
		return mapCharacter;
	}
	
	public static void testCas(HashMap<Character, Integer> mapCharacter, String [] mots) {
		Integer[][] sums = new Integer[mots.length][];
		for (int i = 0; i < mots.length; i++) {
			Integer[] motValeur = new Integer[mots[i].length()];
			for (int j = 0; j < mots[i].length(); j++) {
				motValeur[j] = mapCharacter.get(mots[i].charAt(j));
			}

			System.out.println(Arrays.asList(motValeur));
			sums[i]=motValeur;
			
		}
		
		System.out.println(Arrays.asList(sums[0]));
		
	}
	
}