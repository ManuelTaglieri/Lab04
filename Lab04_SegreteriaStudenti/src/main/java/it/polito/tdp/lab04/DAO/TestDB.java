package it.polito.tdp.lab04.DAO;

import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		List<Studente> studenti = cdao.getStudentiIscrittiAlCorso(cdao.getTuttiICorsi().get(1));
		
		for (Studente s : studenti) {
			System.out.println(s);
		}
		
	}

}
