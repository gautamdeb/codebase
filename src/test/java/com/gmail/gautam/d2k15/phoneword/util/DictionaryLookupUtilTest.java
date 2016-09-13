package com.gmail.gautam.d2k15.phoneword.util;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gmail.gautam.d2k15.phoneword.model.Dictionary;

public class DictionaryLookupUtilTest {
	private DictionaryLookupUtil lookupUtil = null;

	@Before
	public void beforeTest() {
		Set<String> words = new TreeSet<String>(Arrays.asList("word1", "word2"));
		Dictionary dic = new Dictionary();
		dic.setWords(words);
		lookupUtil = new DictionaryLookupUtil(dic);
	}

	@Test
	public void existingDictionaryWordReturnsTrue() {
		lookupUtil.exists("");
		Assert.assertTrue(lookupUtil.exists("word1"));
	}

	@Test
	public void nonExistingDictionaryWordReturnsFalse() {
		Assert.assertFalse(lookupUtil.exists("non-word"));
	}
}
