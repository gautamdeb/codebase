package com.gmail.gautam.d2k15.phoneword.util;

import com.gmail.gautam.d2k15.phoneword.model.Dictionary;

public class DictionaryLookupUtil {
	private Dictionary dictionary;

	public DictionaryLookupUtil(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public boolean exists(final String word) {
		return dictionary.getWords().contains(word);
	}
}
