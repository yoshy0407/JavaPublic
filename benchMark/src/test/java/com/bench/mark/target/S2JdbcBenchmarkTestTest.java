package com.bench.mark.target;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class S2JdbcBenchmarkTestTest {

	S2JdbcBenchmarkTest s2jdbc;
	
	@Before
	public void setup() {
		s2jdbc = new S2JdbcBenchmarkTest();
		s2jdbc.setup();
	}
	
	@Test
	public void testSelect1() {
		s2jdbc.select1();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect10() {
		s2jdbc.select10();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect100() {
		s2jdbc.select100();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect1000() {
		s2jdbc.select1000();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect10000() {
		s2jdbc.select10000();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect100000() {
		s2jdbc.select100000();
		assertThat(true, is(true));
	}

}
