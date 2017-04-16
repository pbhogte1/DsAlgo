package com.pbhogte.dsalgo.leetcode;

import com.pbhogte.utils.ArrayUtil;

/**
 * Also see QuickSort
 */
public class KthLargest {
     
    private int array[];
    private int length;
    private int index;
 
    public int getKth(int[] inputArr, int k) {
    	
        if (inputArr == null || inputArr.length == 0) {
            return -1;
        }
        this.array = inputArr;
        length = inputArr.length;
        this.index = k-1;
        System.out.println("index is " + index);
        selectiveSort(0, length - 1);
        return array[index];
    }
    
    /**
     * This method selectively only the part of the array, that is useful for computing kth largest
     * 
     * @param lowerIndex
     * @param higherIndex
     */
    private void selectiveSort(int lowerIndex, int higherIndex) {
    	
    	System.out.println("Sorting from " + lowerIndex + " to " + higherIndex);
    		
    	int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        System.out.println("pivot is " + pivot);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is smaller then the pivot value, and also we will identify a number
             * from right side which is greater then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] > pivot) {
                i++;
            }
            while (array[j] < pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbersAt(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        System.out.println("lowerindex is " + lowerIndex + ", higherindex is " + higherIndex 
        		+ " , i is " + i + " , j is " + j);
        ArrayUtil.print(array);
        if (lowerIndex <= index && index <= j)
            selectiveSort(lowerIndex, j);	// make sure items from lowerIndex to index are sorted, but need to sort till j
        if (i <= index && index <= higherIndex)
            selectiveSort(i, higherIndex);	// make sure items from i to index are sorted, but need to sort till higherIndex
    }
 
    private void exchangeNumbersAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
}
