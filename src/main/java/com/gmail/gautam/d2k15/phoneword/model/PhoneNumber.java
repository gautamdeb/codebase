package com.gmail.gautam.d2k15.phoneword.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

	private String phoneNumber;
	private List<String> phoneNumberParts = new ArrayList<String>();
	private List<String> phoneWords = new ArrayList<String>();

	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getPhoneNumberParts() {
		return phoneNumberParts;
	}

	public void setPhoneNumberParts(List<String> phoneNumberParts) {
		this.phoneNumberParts = phoneNumberParts;
	}

	public List<String> getPhoneWords() {
		return phoneWords;
	}

	public void setPhoneWords(List<String> phoneWords) {
		this.phoneWords = phoneWords;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phoneNumber=" + phoneNumber + ", phoneNumberParts=" + phoneNumberParts + ", phoneWords="
				+ phoneWords + "]";
	}

}
