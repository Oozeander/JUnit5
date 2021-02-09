package com.oozeander.timeout;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

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
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void test_timeout() {
		// GIVEN
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int amountToAdd = 10;
		// WHEN
		int[] expected = { 11, 12, 13, 14, 15, 16 }, actual = calculator.addEach(array, amountToAdd);
		// THEN
		assertThat(actual).containsExactly(expected);
	}
}