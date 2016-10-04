package testMain;

import java.util.*;
import rubrica.*;

public class test {

	public static void main(String[] args) throws VoceEsiste, VoceNonEsiste {
		
		Rubrica r = new Rubrica();
		
		//Metodo 1
		Voce v1 = r.aggiungiVoce("Bianchi", "Paolo", "1111");
		Voce v2 = r.aggiungiVoce("Rossi", "Mario", "2222");
		Voce v3 = r.aggiungiVoce("Verdi", "Luca", "3333");
		Voce v4 = r.aggiungiVoce("Gialli", "Giorgia", "4444");
		
		for(Voce v: r.getTuttiVoci(r)){
			System.out.println(v.getCognome()+"\t"
					+v.getNome()+"\t"
					+v.getTelefono());			
		}		
		
		//Metodo 2
		
		try{
			Voce preso1 = r.getVoce("Cracco", "Carlo");//Non esiste
		}catch(VoceNonEsiste e){
			System.out.println(e);
		}
		
		Voce preso2 = r.getVoce("Rossi", "Mario");//Trovato
		
		System.out.println(preso2.getCognome()
		+"\t"+preso2.getNome()
		+"\t"+preso2.getTelefono());
		
		//Metodo 3
		
		List<Voce> elenco = r.getTuttiVoci(r);
		for(Voce v: elenco){
			System.out.println(v.getCognome()+"\t"
					+v.getNome()+"\t"
					+v.getTelefono());
		}
		
		
		//Metodo 4
		
		try{
			Voce aggiornato1 = r.aggiornaVoce("Cracco", "Carlo", "5555");//Non esiste
		}catch(Exception e){
			System.out.println(e);
		}
		
		Voce aggiornato2 = r.aggiornaVoce("Gialli", "Giorgia", "5555");//Aggiorna
		System.out.println(aggiornato2.getCognome()
				+"\t"+aggiornato2.getNome()
				+"\t"+aggiornato2.getTelefono());

		
		//Metodo 5
		
		try{
			Voce cancellato1 = r.cancellaVoce("Cracco", "Carlo");//Non esiste
		}catch(Exception e){
			System.out.println(e);
		}	
		
		Voce cancellato2 = r.cancellaVoce("Rossi", "Mario");//Cancellato
		List<Voce> elenco2 = r.getTuttiVoci(r);
		
		for(Voce v: elenco2){
			System.out.println(v.getCognome()+"\t"
					+v.getNome()+"\t"
					+v.getTelefono());
		}
	}
}
