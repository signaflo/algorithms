package com.signaflo.algorithms;

import java.util.NoSuchElementException;

/**
 * A collection of search functions (in the form of static methods).
 */
public class Search {
  
  private Search() {}

  /**
   * 
   * @param integers the integers to search through for the provided value.
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
}
