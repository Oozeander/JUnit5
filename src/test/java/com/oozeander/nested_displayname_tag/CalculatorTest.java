package com.oozeander.nested_displayname_tag;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.oozeander.Calculator;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@DisplayName("Calculator TEST")
@Tag("OperationTests")
public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	public void setup() {
		calculator = new Calculator();
	}

	@AfterEach
	public void teardown() {
		calculator = null;
	}

	@Nested
	@DisplayName("Test for calculator.add")
	@Tag("AddTests")
	class AddTest {
		@Test
		@DisplayName("Add two positive numbers")
		void add_positive() {
			assertThat(calculator.add(1, 2)).isEqualTo(3);
		}

		@Test
		@DisplayName("Add two negative numbers")
		void add_negative() {
			assertThat(calculator.add(-1, -2)).isEqualTo(-3);
		}

		@Test
		@DisplayName("Add two numbers equals to 0")
		void add_zero() {
			assertThat(calculator.add(1, -1)).isEqualTo(0);
		}
	}

	@Test
	@Tag("DivideTests")
	void test_divide() {
		assertThat(calculator.divide(0, 18)).isEqualTo(0);
	}
}