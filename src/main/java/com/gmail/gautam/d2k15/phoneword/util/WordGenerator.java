package com.gmail.gautam.d2k15.phoneword.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.gmail.gautam.d2k15.phoneword.model.PhoneNumber;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;

public class WordGenerator {

	private final Map<Character, Set<Character>> PHONE_WORD_MAP = new HashMap<>();
	private PhoneNumbers phoneNumbers;
	private DictionaryLookupUtil dictionaryLookupUtil;

	public WordGenerator(PhoneNumbers phoneNumbers, DictionaryLookupUtil dictionaryLookupUtil) {
		this.phoneNumbers = phoneNumbers;
		this.dictionaryLookupUtil = dictionaryLookupUtil;

		PHONE_WORD_MAP.put('2', new HashSet<>(Arrays.asList('A', 'B', 'C')));
		PHONE_WORD_MAP.put('3', new HashSet<>(Arrays.asList('D', 'E', 'F')));
		PHONE_WORD_MAP.put('4', new HashSet<>(Arrays.asList('G', 'H', 'I')));
		PHONE_WORD_MAP.put('5', new HashSet<>(Arrays.asList('J', 'K', 'L')));
		PHONE_WORD_MAP.put('6', new HashSet<>(Arrays.asList('M', 'N', 'O')));
		PHONE_WORD_MAP.put('7', new HashSet<>(Arrays.asList('P', 'Q', 'R', 'S')));
		PHONE_WORD_MAP.put('8', new HashSet<>(Arrays.asList('T', 'U', 'V')));
		PHONE_WORD_MAP.put('9', new HashSet<>(Arrays.asList('W', 'X', 'Y', 'Z')));
	}

	public PhoneNumbers execute() {
		for (PhoneNumber phoneNumber : phoneNumbers.getPhoneNumbers()) {
			Set<String> potentialWords = replaceNumbers(phoneNumber.getPhoneNumber());
			for (String word : potentialWords) {
				if (dictionaryLookupUtil.exists(word)) {
					phoneNumber.getPhoneWords().add(word);
				}
			}
		}
		return phoneNumbers;
	}

	private Set<String> replaceNumbers(final String number) {
		Set<String> potentialWords = new HashSet<>(Collections.singletonList(""));
		for (char digit : number.toCharArray()) {
			Set<String> newPotentialWords = new HashSet<>();
			for (String potentialWord : potentialWords) {
				for (char replaceable : PHONE_WORD_MAP.get(digit)) {
					newPotentialWords.add(potentialWord + replaceable);
				}
			}
			potentialWords = newPotentialWords;
		}
		return potentialWords;
	}
}
