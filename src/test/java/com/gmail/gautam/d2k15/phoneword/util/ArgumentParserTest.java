package com.gmail.gautam.d2k15.phoneword.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.gmail.gautam.d2k15.phoneword.model.PhoneWordArgument;

public class ArgumentParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionForNoArguments() {
		ArgumentParser argParser = new ArgumentParser(new ArrayList<>());
		argParser.parse();
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionForInvalidArguments() {
		ArgumentParser argParser = new ArgumentParser(Arrays.asList("-n", "test", "invalid", "args"));
		argParser.parse();
	}

	@Test
	public void useDefaultDictionaryIfNotSpecifiedInArguments() {
		ArgumentParser argParser = new ArgumentParser(Arrays.asList("-i", "input.txt", "-o", "output.txt"));
		PhoneWordArgument args = argParser.parse();

		Assert.assertTrue(args.getDictonaryFile().contains(ArgumentParser.DEFAULT_DICTIONARY));
	}

	@Test
	public void returnInitializedArgumentObjectForProperInput() {
		ArgumentParser argParser = new ArgumentParser(
				Arrays.asList("-d", "dictionary.txt", "-i", "input.txt", "-o", "output.txt"));
		PhoneWordArgument args = argParser.parse();

		Assert.assertEquals("dictionary.txt", args.getDictonaryFile());
		Assert.assertEquals("input.txt", args.getInputDataFile());
		Assert.assertEquals("output.txt", args.getOutputDataFile());

	}
}
