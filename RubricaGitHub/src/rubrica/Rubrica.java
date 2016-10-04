package rubrica;

import java.util.*;

public class Rubrica {

	private Map<String, Voce> listaRubrica = new TreeMap<String, Voce>();

	//1- Aggiungere contatto in Rubrica
	public Voce aggiungiVoce(String cognome, String nome, String telefono)
			throws VoceEsiste {
		if (listaRubrica.containsKey(cognome + " " + nome)) {
			throw new VoceEsiste(
					"Questo contatto e gia presente nella tua rubrica");
		}
		Voce contatto = new Voce(cognome, nome, telefono);

		listaRubrica.put(cognome + " " + nome, contatto);
		return contatto;
	}
	
	//2- Trovare contatto in Rubrica - Se non esiste lancia UtenteNonEsiste
	public Voce getVoce(String cognome, String nome){
		
		return null;
	}
	
	//3- Ritorna tutti i contatti in Rubrica
	public List<Voce> getTuttiVoci(Rubrica r){
		List<Voce> elenco = new ArrayList<Voce>();
		elenco.addAll(listaRubrica.values());
		return elenco;
	}
	
	//4- Aggiorna il numero di telefono - Se non esiste lancia UtenteNonEsiste
	public Voce aggiornaVoce(String cognome, String nome, String telefono) throws VoceNonEsiste{
		if (!listaRubrica.containsKey(cognome + " " + nome)) {
			throw new VoceNonEsiste(
					"Questo contatto non esiste");
		}
		Voce v = listaRubrica.get(cognome+" "+nome);
		v.setTelefono(telefono);
		return v;
	}
	
	//5- Elimina voce dalla Rubrica - Se non esiste lancia UtenteNonEsiste
	public Voce cancellaVoce(String cognome, String nome){
		
		return null;
	}

}
