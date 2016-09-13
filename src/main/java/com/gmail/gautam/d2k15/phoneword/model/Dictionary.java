package com.gmail.gautam.d2k15.phoneword.model;

import java.util.Set;
import java.util.TreeSet;

public class Dictionary {
	Set<String> words = new TreeSet<String>();

	public Set<String> getWords() {
		return words;
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "Dictionary [words=" + words + "]";
	}

}
