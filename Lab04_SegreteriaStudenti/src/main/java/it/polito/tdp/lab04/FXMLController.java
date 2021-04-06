package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxCorsi;

    @FXML
    private Button btnCercaI;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnControlla;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaC;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void cercaCorsi(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	try {
    		List<Corso> corsi = model.getCorsiByStudente(Integer.parseInt(txtMatricola.getText()));
    		
    		if (corsi.isEmpty()) {
    			txtResult.setText("Studente non iscritto ad alcun corso.");
    			return;
    		}
    	
    		for (Corso c : corsi) {
    			txtResult.appendText(c + "\n");
    		}
    	} catch (NumberFormatException e) {
    		txtResult.setText("Errore: la matricola può contenere solo numeri.");
    		return;
    	}
    	

    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	
    	txtResult.clear();
    	   	
    	if (boxCorsi == null || boxCorsi.getValue().equals("")) {
    		txtResult.setText("Scegliere un corso dal menù a tendina");
    	}
    	else {
    		txtResult.clear();
    		List<Studente> studenti = model.getStudentiByCorso(boxCorsi.getValue().substring(0, 7));
    		for (Studente s : studenti) {
    			txtResult.appendText(s + "\n");
    		}
    	}

    }

    @FXML
    void completa(ActionEvent event) {
    	Studente trovato = model.getStudente(txtMatricola.getText());
    	if (trovato.getNome() == null) {
    		txtResult.setText("Studente non presente");
    	} else {
    		txtNome.setText(trovato.getNome());
    		txtCognome.setText(trovato.getCognome());
    	}
    }

    @FXML
    void iscrivi(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	try {
    		List<Corso> corsi = model.getCorsiByStudente(Integer.parseInt(txtMatricola.getText()));
    		
    		if (boxCorsi.getValue().equals("")) {
    			txtResult.setText("Selezionare un corso.");
    			return;
    		}
    		
    		for (Corso c : corsi) {
    			if (c.getCodins().equals(boxCorsi.getValue().substring(0, 7))) {
    				txtResult.setText("Studente già iscritto al corso.");
    				return;
    			}
    		}
    		
    		boolean successo = model.isciriviStudenteACorso(Integer.parseInt(txtMatricola.getText()), boxCorsi.getValue().substring(0, 7));
    		
    		if (successo) {
    			txtResult.setText("Studente iscritto al corso!");
    		} else {
    			txtResult.setText("Errore nell'iscrizione dello studente, verificare la correttezza della matricola");
    		}
    		
    		
    	} catch (NumberFormatException e) {
    		txtResult.setText("Errore: la matricola può contenere solo numeri.");
    		return;
    	}
    	
    	

    }

    @FXML
    void reset(ActionEvent event) {
    	
    	boxCorsi.getSelectionModel().clearSelection();
    	txtResult.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtMatricola.clear();

    }

    @FXML
    void initialize() {
        assert boxCorsi != null : "fx:id=\"boxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaI != null : "fx:id=\"btnCercaI\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnControlla != null : "fx:id=\"btnControlla\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaC != null : "fx:id=\"btnCercaC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	
    	this.model = model;
    	txtResult.setStyle("-fx-font-family: monospace");
    	
    	this.boxCorsi.getItems().add("");
    	
    	for (Corso c : this.model.getTuttiICorsi()) {
    		boxCorsi.getItems().add(c.getCodins() + " - " + c.getNome());
    	}
    	
    }
    
}
