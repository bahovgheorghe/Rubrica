package rubrica;

import java.util.Map;
import java.util.TreeMap;

public class Rubrica {

	private Map<String,Voce> listaRubrica = new TreeMap<String,Voce>();
	
	//primo metodo
	public Voce aggiungiVoce(String cognome,String nome,String telefono) throws VoceEsiste{
		if(listaRubrica.containsKey(cognome +" "+ nome)){
			throw new VoceEsiste("Questo contatto e gia presente nella tua rubrica");
		}
		Voce contatto = new Voce(cognome,nome,telefono);
		
		listaRubrica.put(cognome +" "+ nome, contatto);
		return contatto;
	}
	
	//secondo metodo
	public Voce cercaVoce(String cognome, String nome){
		Voce v = null;
		if(listaRubrica.containsKey(cognome+" "+nome)){
			v = listaRubrica.get(cognome+" "+nome);
		}		
		return v;
	}
	
}
