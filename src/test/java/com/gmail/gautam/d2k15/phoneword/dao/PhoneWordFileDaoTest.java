package com.gmail.gautam.d2k15.phoneword.dao;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.gmail.gautam.d2k15.phoneword.model.PhoneNumbers;
import com.gmail.gautam.d2k15.phoneword.util.StringEscapeUtil;

public class PhoneWordFileDaoTest {

	private IPhoneWordDao dao;

	@Before
	public void beforeTest() {
		dao = new PhoneWordFileDao();
	}

	@Test(expected = IOException.class)
	public void readDictionary() throws IOException {
		dao.readDictionary("/some/path", new StringEscapeUtil());
	}

	@Test(expected = IOException.class)
	public void readInput() throws IOException {
		dao.readInput("/some/path", new StringEscapeUtil());
	}

	@Test(expected = IOException.class)
	public void writeOutput() throws IOException {
		dao.writeOutput(new PhoneNumbers(), "/some/path");
	}

}
