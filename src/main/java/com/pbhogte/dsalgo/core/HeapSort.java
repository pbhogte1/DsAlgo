package com.pbhogte.dsalgo.core;

import java.util.Arrays;

import com.pbhogte.utils.ArrayUtil;

/** 
 * The heapify() operation is run once, and is O(n) in performance. 
 * The siftDown() function is O(log(n)), and is called n times. 
 * Therefore, the performance of this algorithm is O(n + n * log(n)) which evaluates to O(n log n).
 * 
 * @author pbhogte
 *
 */
public class HeapSort {

	int[] a;
	int size;
	
	public int[] sort(int[] a) {
		if ((a == null) || a.length == 0) {
			throw new RuntimeException("Invalid input");
		}
		this.a = a;
		size = a.length - 1;
		
		ArrayUtil.print(a);
		heapify(); // at the end of heapify, each parent will be greater than its children
		ArrayUtil.print(a);
		ArrayUtil.printHeap(a);
		
		// Start sorting in descending order from the back of the array
		while (size >= 0) {
			swap(0, size); // move root to the end
			ArrayUtil.print(a);
			size--;
			siftDown(0, size); // operate on the remaining heap
			ArrayUtil.print(a);
		}
		ArrayUtil.print(a);
		ArrayUtil.printHeap(a);
		return Arrays.copyOf(a, a.length);
	}
	
	/** 
	 * Build the heap order - parent is greater than children
	 */
	public void heapify() {
		int start = parent(size);
		while (start >= 0) {
			siftDown(start, size);
			start--;
		}
	}
	
	/**
	 * Repair the heap - build the heap order iteratively
	 * @param start - start parent index
	 * @param end - end child index
	 */
	public void siftDown(int start, int end) {
		System.out.println("start is " + start + " and end is " + end);
		int root = start;
		while (leftChild(root) <= end) {
			System.out.println("root is " + root + " and end is " + end);
			int leftChild = leftChild(root);
			int temp = root;
			if (a[temp] < a[leftChild]) { // left-child is greater than root
				temp = leftChild; // temp hold pointer to left-child
			}
			int rightChild = rightChild(root);
			if ((rightChild <= end) && (a[temp] < a[rightChild])) { // right-child is greater so far
				temp = rightChild; // temp hold pointer to right-child
			}
			if (temp == root) {
				return;
			}
			else {
				swap(root, temp); // swap root with greater element
				root = temp;
			}
		}
	}
	
	private void swap(int first, int second) {
		System.out.println("Swapping " + first + " and " + second);
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
 	}
	
	private int parent(int i) {
		return (i-1)/2;
	}
	
	private int leftChild(int i) {
		return 2*i + 1;
	}
	
	private int rightChild(int i) {
		return 2*i + 2;
	}
	
}
