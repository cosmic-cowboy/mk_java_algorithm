package com.slgerkamp.mkjavaalgorithm.sort;

import static com.slgerkamp.mkjavaalgorithm.sort.IsSort.sortOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class MergeSortTest {

	@DataPoints
	public static SortFixture[] FIXTURES = {
		new SortFixture(new int [] {3,2,4,1}, new int [] {1,2,3,4}, 5),
		new SortFixture(new int [] {6,4,3,7,1,9,8}, new int [] {1,3,4,6,7,8,9}, 13),
		new SortFixture(new int [] {1,3,4,6,7,9,8}, new int [] {1,3,4,6,7,8,9}, 11)
	};
	
	@Theory
	public void quickSortTest(SortFixture f){
		assertThat(MergeSort.mergeSort(f.targetArray), is(sortOf(f.expecedArray, f.expecedCounter)));
	}
}

