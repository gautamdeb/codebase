package com.gmail.gautam.d2k15.phoneword.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringEscapeUtilTest {
	private StringEscapeUtil stringEscapeUtil;

	@Before
	public void beforeTest() {
		stringEscapeUtil = new StringEscapeUtil();
	}

	@Test
	public void escapeSpecialCharacters() {
		String escapedString = stringEscapeUtil.excapeSpecialChars("abc'd");
		Assert.assertEquals("abcd", escapedString.toLowerCase());
	}

	@Test
	public void escapedStringInUpperCase() {
		String escapedString = stringEscapeUtil.excapeSpecialChars("abc'd");
		Assert.assertEquals("ABCD", escapedString);
	}

	@Test
	public void parserNumber() {
		String escapedString = stringEscapeUtil.parseNumber("123-8.9");
		Assert.assertEquals("12389", escapedString);
	}

	@Test
	public void parserNumberAndEscapPrefix1800() {
		String escapedString = stringEscapeUtil.parseNumber("1800123-8.9");
		Assert.assertEquals("12389", escapedString);
	}
}
