package it.polito.tdp.spellchecker.model;

import java.util.*;

public class SpellModel {

	private Dictionary dic;
	private int errors;
	private List<String> wrongWords;
	
	
	public SpellModel() {
	
		dic = new Dictionary();
		this.errors = 0;
		this.wrongWords = new ArrayList<String>();

	}



	public void setDictionary(String language) {
		dic.loadDictionary(language);
	}
	
	public void setWrongs(List<String> listWord) {
		
		List<RichWord> temp = dic.spellCheckText(listWord);
		for(RichWord rw : temp) {
			if(!rw.isCorrect()) {
				wrongWords.add(rw.getWord());
				errors++;
			}
		}
	}



	public int getErrors() {
		return errors;
	}



	public List<String> getWrongWords() {
		return wrongWords;
	}
	
	public void clearModel() {
		wrongWords.clear();
		errors=0;
		dic = new Dictionary();
	}
}
