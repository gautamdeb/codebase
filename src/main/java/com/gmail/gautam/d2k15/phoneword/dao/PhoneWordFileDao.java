package com.gmail.gautam.d2k15.phoneword.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.gmail.gautam.d2k15.phoneword.model.Dictionary;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumber;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;
import com.gmail.gautam.d2k15.phoneword.util.ArgumentParser;
import com.gmail.gautam.d2k15.phoneword.util.StringEscapeUtil;

public class PhoneWordFileDao implements IPhoneWordDao {

	public Dictionary readDictionary(String path, StringEscapeUtil stringEscapeUtil) throws IOException {
		Dictionary dictionary = new Dictionary();
		BufferedReader reader = null;
		try {

			if (ArgumentParser.DEFAULT_DICTIONARY.equals(path)) {
				reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
			} else {
				reader = new BufferedReader(new FileReader(path));
			}

			String line = "";
			while ((line = reader.readLine()) != null) {
				dictionary.getWords().add(stringEscapeUtil.excapeSpecialChars(line));
			}
		} finally {
			if (reader != null)
				reader.close();
		}
		return dictionary;
	}

	public PhoneNumbers readInput(String path, StringEscapeUtil stringEscapeUtil) throws IOException {
		PhoneNumbers phoneNumbers = new PhoneNumbers();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = "";
		while ((line = reader.readLine()) != null) {
			phoneNumbers.getPhoneNumbers().add(new PhoneNumber(stringEscapeUtil.parseNumber(line)));
		}
		reader.close();
		return phoneNumbers;
	}

	public void writeOutput(PhoneNumbers phoneNumbers, String path) throws IOException {
		String format = "%-15s | %-200s";
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"));
			writer.write((String.format(format, "Phone Number", "Phone Words")));
			writer.write("-----------------------------\n");
			for (PhoneNumber phoneNumber : phoneNumbers.getPhoneNumbers()) {
				writer.write(String.format(format, phoneNumber.getPhoneNumber(), phoneNumber.getPhoneWords()));
			}
		} finally {
			if (writer != null)
				writer.close();
		}

	}

}
