package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getStudente(String matricola) {
		
		final String sql = "SELECT * " +
				"FROM studente AS s " +
				"WHERE s.matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			
			Integer matricolaS = null;
			String cognome = null;
			String nome = null;
			String CDS = null;

			while (rs.next()) {
				
				matricolaS = rs.getInt("matricola");
				cognome = rs.getString("cognome");
				nome = rs.getString("nome");
				CDS = rs.getString("CDS");
				
			}
			
			conn.close();
			
			return new Studente(matricolaS, cognome, nome, CDS);
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		
	}
	

}
