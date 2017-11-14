import java.util.ArrayList;
import java.util.Collection;

public class Somme {

	final Collection<Character> operandes;
	final Character resultat;
	

	public Somme(Collection<Character> operandes, Character resultat) {
		super();
		this.operandes = operandes;
		this.resultat = resultat;
	}
	
	public int check(final Map<Character, Integer> valeur, final int[] valeurs){
		int somme = retenue;
		for(Character car : operandes){
			somme+=valeurs.get(car);
			
		}
		
		int retenue2 = somme/10;
		
	}
	
	
	
}
