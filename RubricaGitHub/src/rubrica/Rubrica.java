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
		public Voce getVoce(String cognome, String nome) throws VoceNonEsiste{
			//creo nuovo ogetto vuoto
			Voce contatto = null;
			//controllo se nella mia lista esiste un contatto con queste credenziali
			if (listaRubrica.containsKey(cognome +" "+ nome)){
				//se esiste lo assegno al nuovo ogetto
				contatto = listaRubrica.get(cognome +" "+ nome);
			}else{
				throw new VoceNonEsiste(
						"Ricerca - Questo contatto non è presente nella tua rubrica");
			}
			//ritorno l'ogetto nuovo
			return contatto;
		}
	
	//3- Ritorna tutti i contatti in Rubrica
	public List<Voce> getTuttiVoci(Rubrica r){
		List<Voce> elenco = new ArrayList<Voce>();
		elenco.addAll(listaRubrica.values());
		return elenco;
	}
	
	//4- Aggiorna il numero di telefono - Se non esiste lancia UtenteNonEsiste
	public Voce aggiornaVoce(String cognome, String nome, String telefono) throws VoceNonEsiste{
		Voce v = null;
		if (!listaRubrica.containsKey(cognome+" "+ nome)) {
			throw new VoceNonEsiste(
					"Aggiornamento - Questo contatto non esiste");
		}
		v = listaRubrica.get(cognome+" "+nome);
		v.setTelefono(telefono);
		return v;
	}
	
	//5- Elimina voce dalla Rubrica - Se non esiste lancia UtenteNonEsiste
		public Voce cancellaVoce(String cognome, String nome) throws VoceNonEsiste{

			if (listaRubrica.containsKey(cognome + " " + nome)) {
				listaRubrica.remove(cognome + " " + nome);
			}else{
				throw new VoceNonEsiste(
						"Eliminazione - Questo contatto non è presente nella tua rubrica");
			}
			
			return null;
			
			
		}

}
