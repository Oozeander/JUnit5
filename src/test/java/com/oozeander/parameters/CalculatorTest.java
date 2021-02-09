package com.oozeander.parameters;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest(name = "0 / {0} = 0")
	@ValueSource(ints = { 1, -2, -5, 49, 256 })
	void test_OneParameter(int a) {
		// GIVEN
		// WHEN
		int expected = 0, actual = calculator.divide(0, a);
		// THEN
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest(name = "{0} / {1} = {2}")
	@CsvSource({ "2, 1, 2", "45, 3, 15", "16, -4, -4" })
	void test_AllParameters(int a, int b, int expected) {
		// GIVEN
		// THEN
		int actual = calculator.divide(a, b);
		// WHEN
		assertThat(actual).isEqualTo(expected);
	}
}