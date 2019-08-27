package com.signaflo.algorithms;

import java.util.NoSuchElementException;

/**
 * A collection of search functions (in the form of static methods).
 */
public class Search {
  
  private Search() {}

  /**
   * Perform binary search on an array of sorted integers, returning the index of the value if found
   * and throwing a NoSuchElementException otherwise. Time performance is O(log n).
   * 
   * @param integers a sorted array of integers to search through for the provided value.
   * @param value the value to search the array for.
   *              
   * @return the index where the value is stored in the array.
   * 
   * @throws NoSuchElementException if the value is not in the array.
   */
  public static int binarySearch(int[] integers, int value) {
    return binarySearch(integers, value, 0, integers.length);
  }
  
  private static int binarySearch(int[] integers, int value, int lowerBound, int upperBound) {
    if (lowerBound > upperBound) { 
      throw new NoSuchElementException();
    }
    int median = (lowerBound + upperBound) / 2;
    if (value == integers[median]) {
      return median;
    } else if (integers[median] < value) {
      return binarySearch(integers, value, median + 1, upperBound);
    } else {
      return binarySearch(integers, value, lowerBound, median - 1);
    }
  }

  /**
   * Perform linear search on a sorted or unsorted array of integers. Time performance is O(n).
   * 
   * @param integers the array of integers to through for the provided value.
   * @param value the value to search the array for.
   *
   * @return the index where the value is stored in the array.
   *
   * @throws NoSuchElementException if the value is not in the array.
   */
  public static int linearSearch(int[] integers, int value) {
    for (int i = 0; i < integers.length; i++) {
      if (integers[i] == value) {
        return i;
      }
    }
    throw new NoSuchElementException();
  }
}
