package com.pbhogte.dsalgo.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class KthLargestTest {

	@Test
	public void test() {
		KthLargest sorter = new KthLargest();
        int[] input = {24,2,45,75,20,56,2,56,99,53,12};
        int k = 9;
        
        int kth = sorter.getKth(input, k);
        assertEquals(12, kth);
	}

}
