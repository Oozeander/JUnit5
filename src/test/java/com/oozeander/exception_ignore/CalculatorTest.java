package com.oozeander.exception_ignore;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.oozeander.Calculator;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	public void setup() {
		calculator = new Calculator();
	}

	@AfterEach
	public void teardown() {
		calculator = null;
	}

	@Test
	void test_exception() {
		// GIVEN
		int a = 1, b = 0;
		// WHEN
		// THEN
		assertThrows(ArithmeticException.class, () -> calculator.divide(a, b)); // or ASSERTJ
	}

	@Test
	@Disabled
	void test_ignored() {
		fail("Not yet implemented");
	}
}