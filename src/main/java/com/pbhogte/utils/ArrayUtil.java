package com.pbhogte.utils;

public class ArrayUtil {

	public static void print(int[] input) {
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void print(int[][] input) {
		for(int[] i:input){
			for(int j:i){
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void printHeap(int[] input) {
    	int size = input.length - 1;
        for (int i = 0; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + getElementAt(input, i) + " LEFT CHILD : " + getElementAt(input, 2*i + 1)
                  + " RIGHT CHILD :" + getElementAt(input, 2 * i  + 2) );
            System.out.println();
        }
    }
	
	private static int getElementAt(int[] a, int index) {
		if (index <= a.length-1) {
			return a[index];
		}
		else {
			return Integer.MIN_VALUE;
		}
	}
}
