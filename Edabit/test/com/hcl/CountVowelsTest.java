package com.hcl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountVowelsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals(2, VowelCount.countVowels("apple"));
	}

	@Test
	public void test2() {
		assertEquals(5, VowelCount.countVowels("cheesecake"));
	}

	@Test
	public void test3() {
		assertEquals(3, VowelCount.countVowels("martini"));
	}

	@Test
	public void test4() {
		assertEquals(0, VowelCount.countVowels("rhythm"));
	}

	@Test
	public void test5() {
		assertEquals(0, VowelCount.countVowels(""));
	}

	@Test
	public void test6() {
		assertEquals(0, VowelCount.countVowels("b"));
	}

	@Test
	public void test7() {
		assertEquals(1, VowelCount.countVowels("a"));
	}

	@Test
	public void test8() {
		assertEquals(0, VowelCount.countVowels("bbbbbb"));
	}

	@Test
	public void test9() {
		assertEquals(1, VowelCount.countVowels("bbbbba"));
	}

	@Test
	public void test10() {
		assertEquals(1, VowelCount.countVowels("abbbb"));
	}

	@Test
	public void test11() {
		assertEquals(1, VowelCount.countVowels("bbbab"));
	}

	@Test
	public void test12() {
		assertEquals(2, VowelCount.countVowels("bbaab"));
	}

	@Test
	public void test13() {
		assertEquals(3, VowelCount.countVowels("baabab"));
	}
}
