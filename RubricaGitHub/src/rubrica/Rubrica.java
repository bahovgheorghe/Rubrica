package rubrica;

import java.util.Map;
import java.util.TreeMap;

public class Rubrica {

	private Map<String, Voce> listaRubrica = new TreeMap<String, Voce>();

	// primo metodo
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

	// secondo metodo
	public Voce cercaVoce(String cognome, String nome) {
		// dichiara voce vuota
		Voce v = null;
		if (listaRubrica.containsKey(cognome + " " + nome)) {
			v = listaRubrica.get(cognome + " " + nome);
		}
		return v;
	}

	// terzo metodo
	public String cancellaVoce(String cognome, String nome) {
		String ok = "voce elliminata";
		String ko = "voce non presente nella rubrica";

		if (listaRubrica.containsKey(cognome + " " + nome)) {
			listaRubrica.remove(cognome + " " + nome);
			return ok;
		}
		return ko;
	}
}
