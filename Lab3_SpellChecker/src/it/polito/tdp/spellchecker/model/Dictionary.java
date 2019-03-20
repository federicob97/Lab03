package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	private List<String> dictionary;
	
	
	public Dictionary() {
		
		this.dictionary = new ArrayList<String>();
	}

	public void loadDictionary(String language) {
		String file = "rsc/"+language+".txt";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String word;
	
			while((word = br.readLine())!=null) {
				
				dictionary.add(word);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> result = new ArrayList<RichWord>();
		for(String s : inputTextList) {
			
				result.add(new RichWord(s,dictionary.contains(s)));
		}
		return result;
	}
}
