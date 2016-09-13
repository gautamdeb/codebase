package com.gmail.gautam.d2k15.phoneword;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.gmail.gautam.d2k15.phoneword.dao.IPhoneWordDao;
import com.gmail.gautam.d2k15.phoneword.model.Dictionary;
import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;
import com.gmail.gautam.d2k15.phoneword.model.PhoneWordArgument;
import com.gmail.gautam.d2k15.phoneword.util.DictionaryLookupUtil;
import com.gmail.gautam.d2k15.phoneword.util.PhoneNumberPreProcessor;
import com.gmail.gautam.d2k15.phoneword.util.StringEscapeUtil;
import com.gmail.gautam.d2k15.phoneword.util.WordGenerator;

public class PhoneWordService {
	private PhoneWordArgument phoneWordArgs;
	private IPhoneWordDao fileDao;
	private StringEscapeUtil stringEscapeUtil;
	private PhoneNumberPreProcessor preProcessor;

	public PhoneWordService(final PhoneWordArgument phoneWordArgs, final IPhoneWordDao fileDao,
			final StringEscapeUtil stringEscapeUtil, PhoneNumberPreProcessor preProcessor) {
		this.phoneWordArgs = phoneWordArgs;
		this.fileDao = fileDao;
		this.stringEscapeUtil = stringEscapeUtil;
		this.preProcessor = preProcessor;
	}

	public void execute() throws FileNotFoundException, IOException {
		// 1. read dictionary
		Dictionary dictionary = fileDao.readDictionary(phoneWordArgs.getDictonaryFile(), stringEscapeUtil);

		// 2. read phone numbers
		PhoneNumbers phoneNumbers = fileDao.readInput(phoneWordArgs.getInputDataFile(), stringEscapeUtil);

		// 3. pre-process phone numbers
		phoneNumbers = preProcessor.preProcessNumbers(phoneNumbers);

		// 4. generate phone words
		WordGenerator wordGenerator = new WordGenerator(phoneNumbers, new DictionaryLookupUtil(dictionary));
		wordGenerator.execute();

		// 5. write output
		fileDao.writeOutput(phoneNumbers, phoneWordArgs.getOutputDataFile());
	}
}
