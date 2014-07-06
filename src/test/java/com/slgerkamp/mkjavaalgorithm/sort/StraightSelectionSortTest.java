package com.slgerkamp.mkjavaalgorithm.sort;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static com.slgerkamp.mkjavaalgorithm.sort.IsSort.sortOf;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Theories.class)
public class StraightSelectionSortTest {
	
	@DataPoints
	public static SortFixture[] FIXTURES = {
		new SortFixture(new int [] {3,2,4,1}, new int [] {1,2,3,4}, 10),
		new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {1,3,4,6,7,8,9}, 28),
		new SortFixture(new int [] {1,3,4,6,7,9,8}, new int [] {1,3,4,6,7,8,9}, 28)
	};

	@Theory
	public void straightSelectionSortTest(SortFixture f){

		assertThat(StraightSelectionSort.straightSelectionSort(f.targetArray), is(sortOf(f.expecedArray, f.expecedCounter)));
		
	}
}
