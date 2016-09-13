package com.gmail.gautam.d2k15.phoneword.util;

public class StringEscapeUtil {

	private static final String SP_CHAR = "\\p{Punct}";
	private static final String SPACE = "\\s";

	public String excapeSpecialChars(final String inputString) {
		return inputString.replaceAll(SP_CHAR, "").replaceAll(SPACE, "").toString().trim().toUpperCase();
	}

	public String parseNumber(final String number) {
		return removePrefix(number).replaceAll("\\.", "").replaceAll("\\-", "");
	}

	private String removePrefix(String s) {
		if (s.startsWith("1800")) {
			return s.substring(4);
		}
		return s;
	}
}
