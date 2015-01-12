package com.xebia.java8_3.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneCoder {
	@SuppressWarnings("serial")
	private static final Map<Character, String> MNEMONICS = new HashMap<Character, String>() {
		{
			put('2', "ABC");
			put('3', "DEF");
			put('4', "GHI");
			put('5', "JKL");
			put('6', "MNO");
			put('7', "PQRS");
			put('8', "TUV");
			put('9', "WXYZ");
		}
	};
	private static final Map<Character, Character> CHAR_TO_DIGIT = charToDigit(MNEMONICS);
	private Map<String, List<String>> numbers;

	public static Map<Character, Character> charToDigit(
			Map<Character, String> mnemonics) {
		Map<Character, Character> charCodes = new HashMap<>();
		return charCodes;
	}

	public static String getNumberFrom(String word) {
		return word;
	}

	public static Map<String, List<String>> distributeWords(List<String> words) {
		return null;
	}

	public PhoneCoder(List<String> words) {
		numbers = distributeWords(words);
	}

	public List<String> translate(String number) {
		return java.util.Arrays.asList(number);
	}
}
