package com.pbhogte.dsalgo.core;

import java.util.Arrays;

import com.pbhogte.utils.ArrayUtil;

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
		heapify();
		ArrayUtil.print(a);
		ArrayUtil.printHeap(a);
		
		while (size >= 0) {
			swap(0, size);
			size--;
			siftDown(0, size);
		}
		ArrayUtil.print(a);
		return Arrays.copyOf(a, a.length);
	}
	
	public void heapify() {
		int start = parent(size);
		while (start >= 0) {
			siftDown(start, size);
			start--;
		}
	}
	
	public void siftDown(int start, int end) {
		//System.out.println("start is " + start + " and end is " + end);
		int root = start;
		while (leftChild(root) <= end) {
			//System.out.println("root is " + root + " and end is " + end);
			int leftChild = leftChild(root);
			int temp = root;
			if (a[temp] < a[leftChild]) {
				temp = leftChild;
			}
			int rightChild = rightChild(root);
			if ((rightChild <= end) && (a[temp] < a[rightChild])) {
				temp = rightChild;
			}
			if (temp == root) {
				return;
			}
			else {
				swap(root, temp);
				root = temp;
			}
		}
	}
	
	private void swap(int first, int second) {
		//System.out.println("Swapping " + first + " and " + second);
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
	
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		heapSort.sort(new int[] {5, 10, 12, 30, 99, 34, 47, 89, 60});
		
	}
}
