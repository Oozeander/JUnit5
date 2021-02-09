package com.oozeander.lifecyclehooks;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.oozeander.Calculator;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CalculatorTest {
	private Calculator calculator;
	private static Instant start;

	@BeforeAll
	public static void init() {
		start = Instant.now();
	}

	@AfterAll
	public static void destroy() {
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("Tests took " + duration + " ms");
	}

	@BeforeEach
	public void setup() {
		calculator = new Calculator();
	}

	@AfterEach
	public void teardown() {
		calculator = null;
	}

	@Test
	void test() {
		assertThat(calculator.isEven(14)).isTrue();
	}
}