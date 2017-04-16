package com.pbhogte.dsalgo.core;

import java.util.Arrays;

public class QuickSort {

	int[] a;
	
	public int[] sort(int[] a) throws RuntimeException {
		if ((a == null) || a.length == 0) {
			throw new RuntimeException("Invalid input");
		}
		this.a = a;
		qsort(0, a.length - 1);
		return Arrays.copyOf(a, a.length);
	}
	
	private void qsort(int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int p = partition(lo, hi);
		qsort(lo, p);
		qsort(p+1, hi);
		
	}
	
	private int partition(int lo, int hi) {
		int pivot = a[lo];
		int i = lo;
		int j = hi;
		while (true) {
			while (a[i] < pivot) {
				i++;
			}
			
			while (a[j] > pivot) {
				j--;
			}
			
			if (i < j) {
				swap(i,j);
				i++;
				j--;
			}
			else {
				return j;
			}
		}
		
	}
	
	private void swap(int first, int second) {
		// Swapping first and second element;
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
 	}
	
}
