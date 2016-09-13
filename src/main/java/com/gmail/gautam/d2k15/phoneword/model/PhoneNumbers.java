package com.gmail.gautam.d2k15.phoneword.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers {

	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "PhoneNumbers [phoneNumbers=" + phoneNumbers + "]";
	}

}
