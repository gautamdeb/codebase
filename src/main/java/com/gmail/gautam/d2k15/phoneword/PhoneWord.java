package com.gmail.gautam.d2k15.phoneword;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.gmail.gautam.d2k15.phoneword.dao.PhoneWordFileDao;
import com.gmail.gautam.d2k15.phoneword.model.PhoneWordArgument;
import com.gmail.gautam.d2k15.phoneword.util.ArgumentParser;
import com.gmail.gautam.d2k15.phoneword.util.PhoneNumberPreProcessor;
import com.gmail.gautam.d2k15.phoneword.util.StringEscapeUtil;

public class PhoneWord {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArgumentParser argParser = new ArgumentParser(Arrays.asList(args));
		PhoneWordArgument phoneWordArgs = argParser.parse();

		printArguments(phoneWordArgs);

		PhoneWordService service = new PhoneWordService(phoneWordArgs, new PhoneWordFileDao(), new StringEscapeUtil(),
				new PhoneNumberPreProcessor());
		service.execute();
	}

	private static void printArguments(PhoneWordArgument phoneWordArgs) {
		System.out.format("PhoneWord Dic: %s \nInput:         %s \nOutput:        %s", phoneWordArgs.getDictonaryFile(),
				phoneWordArgs.getInputDataFile(), phoneWordArgs.getOutputDataFile());
	}
}
