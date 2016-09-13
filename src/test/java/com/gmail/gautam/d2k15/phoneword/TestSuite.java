package com.gmail.gautam.d2k15.phoneword;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.gmail.gautam.d2k15.phoneword.dao.PhoneWordConsoleDaoTest;
import com.gmail.gautam.d2k15.phoneword.dao.PhoneWordFileDaoTest;
import com.gmail.gautam.d2k15.phoneword.util.ArgumentParserTest;
import com.gmail.gautam.d2k15.phoneword.util.DictionaryLookupUtilTest;
import com.gmail.gautam.d2k15.phoneword.util.PhoneNumberPreProcessorTest;
import com.gmail.gautam.d2k15.phoneword.util.StringEscapeUtilTest;
import com.gmail.gautam.d2k15.phoneword.util.WordGeneratorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PhoneWordConsoleDaoTest.class, PhoneWordFileDaoTest.class, ArgumentParserTest.class,
		DictionaryLookupUtilTest.class, PhoneNumberPreProcessorTest.class, StringEscapeUtilTest.class,
		WordGeneratorTest.class })

public class TestSuite {
}
