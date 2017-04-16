package com.pbhogte.dsalgo.core;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.pbhogte.utils.ArrayUtil;

public class QuickSortTest {

	private static QuickSort qSort = new QuickSort();

	@Test
	public void test1() {
		int[] input  = {5, 10, 12, 30, 99, 34, 47, 89, 60};
		int[] expectedOutput = {5, 10, 12, 30, 34, 47, 60, 89, 99};
		
		int[] output = qSort.sort(input);
		ArrayUtil.print(output);
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test(expected = RuntimeException.class)
	public void test2() {
		int[] input  = null;
		qSort.sort(input);
	}
	
	@Test(expected = RuntimeException.class)
	public void test3() {
		int[] input  = {};
		qSort.sort(input);
	}

}
