package com.slgerkamp.mkjavaalgorithm.sort;


import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static com.slgerkamp.mkjavaalgorithm.sort.IsSort.sortOf;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Theories.class)
public class ShuttleSortTest {
	
	@DataPoints
	public static SortFixture[] FIXTURES = {
		new SortFixture(new int [] {3,2,4,1}, new int [] {1,2,3,4}, 5),
		new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {1,3,4,6,7,8,9}, 10),
		new SortFixture(new int [] {1,3,4,6,7,9,8}, new int [] {1,3,4,6,7,8,9}, 6)
	};

	@Theory
	public void shuttleSortTest(SortFixture f){

		assertThat(ShuttleSort.shuttleSort(f.targetArray), is(sortOf(f.expecedArray, f.expecedCounter)));
		
	}
}
