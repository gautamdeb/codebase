package com.gmail.gautam.d2k15.phoneword.util;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gmail.gautam.d2k15.phoneword.model.PhoneNumber;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;

public class PhoneNumberPreProcessorTest {
	PhoneNumberPreProcessor preProessor;

	@Before
	public void beforeTest() {
		preProessor = new PhoneNumberPreProcessor();
	}

	@Test
	public void phoneNumberWithoutSeperator() {
		PhoneNumbers phoneNumbers = new PhoneNumbers();
		phoneNumbers.setPhoneNumbers(Arrays.asList(new PhoneNumber("123456")));
		phoneNumbers = preProessor.preProcessNumbers(phoneNumbers);
		Assert.assertTrue("123456".equals(phoneNumbers.getPhoneNumbers().get(0).getPhoneNumberParts().get(0)));
	}

	@Test
	public void phoneNumberWithSeperator() {
		PhoneNumbers phoneNumbers = new PhoneNumbers();
		phoneNumbers.setPhoneNumbers(Arrays.asList(new PhoneNumber("123.456")));
		phoneNumbers = preProessor.preProcessNumbers(phoneNumbers);
		Assert.assertTrue("123".equals(phoneNumbers.getPhoneNumbers().get(0).getPhoneNumberParts().get(0)));
		Assert.assertTrue("456".equals(phoneNumbers.getPhoneNumbers().get(0).getPhoneNumberParts().get(1)));
	}
}
