package com.slgerkamp.mkjavaalgorithm.sort;

import org.junit.Test;

import com.slgerkamp.mkjavaalgorithm.sort.Sort.ORDER;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * ソートテスト
 *
 */
public class SortTest {

	/**
	 * 単純交換ソート(バブルソート) 
	 */
	@Test
	public void bubbleSortTest(){
		
		int [] targetArray = {3,2,4,1};
		int [] ascendingSortArray  = {1,2,3,4};
		int [] descendingSortArray = {4,3,2,1};

		assertThat(Sort.bubbleSort(targetArray, ORDER.ASCENDING), is(ascendingSortArray));
		assertThat(Sort.bubbleSort(targetArray, ORDER.DESCENDING), is(descendingSortArray));
	}
}
