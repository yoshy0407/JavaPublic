package com.bench.mark.target;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DomaBenchmarkTestTest {

	DomaBenchmarkTest doma;
	
	@Before
	public void testSetup() {
		doma = new DomaBenchmarkTest();
		doma.setup();
	}

	@Test
	public void testSelect1() {
		doma.select1();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect10() {
		doma.select10();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect100() {
		doma.select100();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect1000() {
		doma.select1000();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect10000() {
		doma.select10000();
		assertThat(true, is(true));
	}

	@Test
	public void testSelect100000() {
		doma.select100000();
		assertThat(true, is(true));
	}

}
