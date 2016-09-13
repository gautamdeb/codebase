package com.gmail.gautam.d2k15.phoneword.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.gmail.gautam.d2k15.phoneword.model.Dictionary;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;
import com.gmail.gautam.d2k15.phoneword.util.StringEscapeUtil;

public interface IPhoneWordDao {
	public Dictionary readDictionary(final String path, StringEscapeUtil stringEscapeUtil)
			throws FileNotFoundException, IOException;

	public PhoneNumbers readInput(final String path, StringEscapeUtil stringEscapeUtil)
			throws FileNotFoundException, IOException;

	public void writeOutput(final PhoneNumbers phoneNumbers, final String path) throws IOException;

}
