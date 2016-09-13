package com.gmail.gautam.d2k15.phoneword.util;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gmail.gautam.d2k15.phoneword.model.Dictionary;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumber;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;

public class WordGeneratorTest {
	private WordGenerator wordGenerator;

	@Before
	public void beforeTest() {
		Set<String> words = new TreeSet<String>(Arrays.asList("CALL", "ME"));
		Dictionary dic = new Dictionary();
		dic.setWords(words);

		DictionaryLookupUtil dictionaryLookupUtil = new DictionaryLookupUtil(dic);
		PhoneNumbers phoneNumbers = new PhoneNumbers();
		phoneNumbers.setPhoneNumbers(Arrays.asList(new PhoneNumber("2255")));
		phoneNumbers = (new PhoneNumberPreProcessor()).preProcessNumbers(phoneNumbers);

		wordGenerator = new WordGenerator(phoneNumbers, dictionaryLookupUtil);
	}

	@Test
	public void existingDictionaryWordReturnsTrue() {
		PhoneNumbers phoneNumbers = wordGenerator.execute();
		Assert.assertEquals("CALL", phoneNumbers.getPhoneNumbers().get(0).getPhoneWords().get(0));
	}
}
