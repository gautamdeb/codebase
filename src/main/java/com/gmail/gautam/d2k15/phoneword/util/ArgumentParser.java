package com.gmail.gautam.d2k15.phoneword.util;

import java.util.List;

import com.gmail.gautam.d2k15.phoneword.model.PhoneWordArgument;

public class ArgumentParser {

	public static final String DEFAULT_DICTIONARY = "/brit-a-z.txt";
	private List<String> arguments;

	public ArgumentParser(List<String> arguments) {
		this.arguments = arguments;
	}

	public PhoneWordArgument parse() {
		String dictionaryFile = "";
		String inputFile = "";
		String outputFile = "";
		if (arguments.size() < 4) {
			throw new IllegalArgumentException(
					"Input argument pattern: [-d dictionary-file-path] -i input-file-path -o output-file-path");
		} else {
			if (arguments.contains("-d")) {
				dictionaryFile = arguments.get(arguments.indexOf("-d") + 1);
			} else {
				/*
				 * String file =
				 * getClass().getResource(DEFAULT_DICTIONARY).getFile(); String
				 * file2 =
				 * (getClass().getResourceAsStream(DEFAULT_DICTIONARY)).read(
				 * 1024); System.out.println(file2); dictionaryFile =
				 * file.startsWith("/") ? file.substring(1) : file;
				 */
				dictionaryFile = DEFAULT_DICTIONARY;
			}

			if (arguments.contains("-i") && arguments.contains("-o")) {
				inputFile = arguments.get(arguments.indexOf("-i") + 1);
				outputFile = arguments.get(arguments.indexOf("-o") + 1);
			} else {
				throw new IllegalArgumentException(
						"Input argument pattern: [-d dictionary-file-path] [-i input-file-path] [-o output-file-path]");
			}

		}
		return new PhoneWordArgument(dictionaryFile, inputFile, outputFile);
	}
}
