package com.xebia.java8_3.collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class PhoneCoderTest {

	@Test
	public void should_get_2_when_A_B_or_C() {
		HashMap<Character, String> mnemonics = new HashMap<Character, String>() {
			{
				put('2', "ABC");
			}
		};
		Map<Character, Character> charCode = PhoneCoder.charToDigit(mnemonics);
		assertThat(
				charCode,
				allOf(hasEntry('A', '2'), hasEntry('B', '2'),
						hasEntry('C', '2')));
	}

	@Test
	public void should_get_5282_when_JAVA() {
		assertThat(PhoneCoder.getNumberFrom("Java"), equalTo("5282"));
	}

	@Test
	public void should_constains_JAVA() {
		List<String> words = Arrays.asList("Java");
		Map<String, List<String>> map = PhoneCoder.distributeWords(words);
		assertTrue(map.get("5282").contains("JAVA"));
	}

	@Test
	public void should_get_JAVA_when_5282() {
		List<String> words = Arrays.asList("Java");
		PhoneCoder phoneCoder = new PhoneCoder(words);
		List<String> result = phoneCoder.translate("5282");
		assertTrue(result.contains("JAVA"));
	}

}
