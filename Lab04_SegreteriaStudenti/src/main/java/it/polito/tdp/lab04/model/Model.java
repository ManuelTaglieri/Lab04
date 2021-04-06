package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi() {
		return corsoDao.getTuttiICorsi();
	}
	
	public Studente getStudente(String matricola) {
		return studenteDao.getStudente(matricola);
	}
	
	public List<Studente> getStudentiByCorso(String codice) {
		return corsoDao.getStudentiIscrittiAlCorso(new Corso(codice, null, null, null));
	}
	
	public List<Corso> getCorsiByStudente(Integer matricola) {
		return corsoDao.getCorsiByStudente(new Studente(matricola, null, null, null));
	}
	
	public boolean isciriviStudenteACorso(Integer matricola, String codice) {
		return corsoDao.iscriviStudenteACorso(new Studente(matricola, null, null, null), new Corso(codice, null, null, null));
	}

}
