package it.polito.tdp.spellchecker.controller;


	import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;


import it.polito.tdp.spellchecker.model.SpellModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.*;
	import javafx.scene.control.MenuButton;
	import javafx.scene.control.TextArea;
	import javafx.scene.text.Text;

	public class SpellCheckerController {

		private SpellModel model;
		
		public void setModel(SpellModel model) {
			this.model = model;
		}
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private MenuButton languageMenu;
	    
	    @FXML
	    private MenuItem englishButton;

	    @FXML
	    private MenuItem italianButton;


	    @FXML
	    private TextArea txtArea1;

	    @FXML
	    private Button spellButton;

	    @FXML
	    private TextArea txtArea2;

	    @FXML
	    private Text txtErrors;

	    @FXML
	    private Button clearButton;
	    
	    @FXML
	    private Text txtTime;

	    @FXML
	    void chooseEnglish(ActionEvent event) {
	    	model.setDictionary("English");
	    	languageMenu.setText("English");
	    	languageMenu.setDisable(true);
	    }

	    @FXML
	    void chooseItalian(ActionEvent event) {
	    	model.setDictionary("Italian");
	    	languageMenu.setText("Italian");
	    	languageMenu.setDisable(true);
	    }

	    @FXML
	    void doClear(ActionEvent event) {

	    	txtArea1.clear();
	    	txtArea2.clear();
	    	txtErrors.setText("0 errors");
	    	txtTime.setText("0 ns");
	    	languageMenu.setDisable(false);
	    	model.clearModel();
	    	languageMenu.setText("MenuButton");
	    	//pulire tutto
	    }

	    @FXML
	    void doSpell(ActionEvent event) {
	    	
	    	//leggere Da area
	    	String s = txtArea1.getText().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]?", "");
	    	String[] x = s.split(" ");
	    	List<String> temp = new ArrayList<String>();
	    	for(int i=0;i<x.length;i++) {
	    		temp.add(x[i]);
	    	}
	    	
	    	//confrontate con dictionary con i metodi
	    	
	    	model.setWrongs(temp);
	    	//stampare le wrongWords
	    	List<String> wrongWords = model.getWrongWords();
	    	for(String w : wrongWords) {
	    		txtArea2.appendText(w+"\n");
	    	}
	    	
	    	//stampare il numero di errori
	    	txtErrors.setText(model.getErrors()+" errors");
	    	
	    	//stampare tempo
	    	txtTime.setText(System.nanoTime()+" ns");
	    }

	    @FXML
	    void initialize() {
	        assert languageMenu != null : "fx:id=\"languageMenu\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert englishButton != null : "fx:id=\"englishButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert italianButton != null : "fx:id=\"italianButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtArea1 != null : "fx:id=\"txtArea1\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert spellButton != null : "fx:id=\"spellButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtArea2 != null : "fx:id=\"txtArea2\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";

	    }
	}

