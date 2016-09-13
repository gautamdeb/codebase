package com.gmail.gautam.d2k15.phoneword.util;

import java.util.Arrays;

import com.gmail.gautam.d2k15.phoneword.model.PhoneNumber;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;

public class PhoneNumberPreProcessor {

	public PhoneNumbers preProcessNumbers(PhoneNumbers phoneNumbers) {
		for (PhoneNumber number : phoneNumbers.getPhoneNumbers()) {
			number.setPhoneNumberParts(Arrays.asList(number.getPhoneNumber().split("\\.")));
		}
		return phoneNumbers;
	}

}
