package com.baxterplanning.algorithms;

/**
 * A collection of sorting functions (static methods).
 */
public class Sorting {

  private Sorting() {}

  /**
   * Sorts an array of integers using the selection sort algorithm.
   *
   * The array is sorted in place in ascending order.
   */
  public static void selectionSort(int[] integers) {
    for (int i = 0; i < integers.length; i++) {
      int minIndex = getIndexOfMinimumValue(integers, i, integers.length);
      swap(integers, i, minIndex);
    }
  }

  // Iterate through an array of integers and returns the index of the smallest element.
  static int getIndexOfMinimumValue(int[] integers, int startIndex, int endIndex) {
    int smallestIndex = startIndex;
    for (int i = startIndex; i < endIndex; i++) {
      if (integers[i] <= integers[smallestIndex]) {
        smallestIndex = i;
      }
    }
    return smallestIndex;
  }

  // Swaps the values at the provided indices of the given array of integers.
  // Swapping is done in place and the array returned is the one passed in.
  static int[] swap(int[] integers, int firstIndex, int secondIndex) {
    int temp = integers[firstIndex];
    integers[firstIndex] = integers[secondIndex];
    integers[secondIndex] = temp;
    return integers;
  }
}
