package com.pbhogte.dsalgo.core;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.pbhogte.utils.ArrayUtil;

public class HeapSortTest {

	private static HeapSort hSort = new HeapSort();

	@Test
	public void test1() {
		int[] input  = {5, 10, 12, 30, 99, 34, 47, 89, 60};
		int[] expectedOutput = {5, 10, 12, 30, 34, 47, 60, 89, 99};
		
		int[] output = hSort.sort(input);
		ArrayUtil.print(output);
		assertArrayEquals(expectedOutput, output);
	}
	
	@Test(expected = RuntimeException.class)
	public void test2() {
		int[] input  = null;
		hSort.sort(input);
	}
	
	@Test(expected = RuntimeException.class)
	public void test3() {
		int[] input  = {};
		hSort.sort(input);
	}

}
