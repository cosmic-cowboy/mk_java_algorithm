package com.slgerkamp.mkjavaalgorithm.recursive;


import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 指定された個数のマス目に配置可能な組み合わせのテスト
 *
 */
@RunWith(Theories.class)
public class QueenBTest {

	@DataPoints
	public static Fixture [] FIXTURES = {
		new Fixture(8, 16777216),
		new Fixture(2, 4),
		new Fixture(3, 27)
	};
	
	@Theory
	public void 指定された個数のマス目に配置可能な組み合わせ(Fixture f){
		assertThat(new QueenB(f.num).set(), is(f.expected));
	}
	
	static class Fixture{
		int num;
		int expected;
		public Fixture(int num, int expected) {
			super();
			this.num = num;
			this.expected = expected;
		}
	}

}
