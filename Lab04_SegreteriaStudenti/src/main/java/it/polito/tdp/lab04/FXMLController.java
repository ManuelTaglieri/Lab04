package it.polito.tdp.lab04;

import java.net.URL;
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
    void cercaCorso(ActionEvent event) {

    }

    @FXML
    void cercaIscrivi(ActionEvent event) {

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

    }

    @FXML
    void reset(ActionEvent event) {
    	
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
    		boxCorsi.getItems().add(c.getNome() + " - " + c.getCodins());
    	}
    	
    }
    
}
