package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Language;

public class LanguageModel {
	private List<Language> languages;
	public LanguageModel() {
		languages = new ArrayList<Language>();
		languages.add(new Language("lang1", "language 1"));
		languages.add(new Language("lang2", "language 2"));
		languages.add(new Language("lang3", "language 3"));
		languages.add(new Language("lang4", "language 4"));
		languages.add(new Language("lang5", "language 5"));
	}
	public List<Language> findAll(){
		return languages;
	}
}
