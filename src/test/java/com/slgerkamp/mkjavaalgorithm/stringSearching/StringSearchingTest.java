package com.slgerkamp.mkjavaalgorithm.stringSearching;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * ソートテスト
 *
 */
@RunWith(Enclosed.class)
public class StringSearchingTest {

	@RunWith(Theories.class)
	public static class 単純法テスト{
		
		@DataPoints
		public static StringSearchingFixture[] FIXTURES = {
			new StringSearchingFixture("ABABCDEFABCDEFABCABCGHA", "ABCABCG", 14),
			new StringSearchingFixture("AABABCDEFABCDEFAABCGHA", "AABC", 15),
			new StringSearchingFixture("ABABCDEFGHA", "ABC", 2),
			new StringSearchingFixture("ABC漢字DEF", "漢字", 3),
			new StringSearchingFixture("ABC漢字DEF", "字数", -1)
		};

		@Theory
		public void 単純法(StringSearchingFixture f){
			assertThat(StringSearching.bruteForceMethod(f.searchTarget, f.pattern), is(f.expecedIndex));
		}

	}
	
	@RunWith(Theories.class)
	public static class KMP法テスト{
		
		@DataPoints
		public static StringSearchingFixture[] FIXTURES = {
			new StringSearchingFixture("ABABCDEFABCDEFABCABCGHA", "ABCABC", 14),
			new StringSearchingFixture("AABABCDEFABCDEFAABCGHA", "AABC", 15),
			new StringSearchingFixture("ABABCDEFGHA", "ABC", 2),
			new StringSearchingFixture("ABC漢字DEF", "漢字", 3),
			new StringSearchingFixture("ABC漢字DEF", "字数", -1)
		};

		@Theory
		public void KMP法(StringSearchingFixture f){
			assertThat(StringSearching.knuthMorrisPrattMethod(f.searchTarget, f.pattern), is(f.expecedIndex));
		}

	}

}
