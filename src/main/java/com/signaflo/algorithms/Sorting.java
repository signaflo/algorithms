package com.signaflo.algorithms;

/**
 * A collection of sorting functions (static methods).
 */
public class Sorting {

  private Sorting() {}

  /**
   * Sorts an array of integers using the selection sort algorithm.
   *
   * The array is sorted in place in ascending order.
   * 
   * @param integers the integers to sort.
   */
  public static void selectionSort(int[] integers) {
    for (int i = 0; i < integers.length; i++) {
      int minIndex = getIndexOfSmallerValue(integers, i, integers.length);
      swap(integers, i, minIndex);
    }
  }

  // Iterate through an array of integers and returns the index of the smallest element.
  static int getIndexOfSmallerValue(int[] integers, int startIndex, int endIndex) {
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

  /**
   * Sorts an array of integers using the bubble sort algorithm.
   * 
   * The array is sorted in place in ascending order.
   * 
   * @param integers the integers to sort.
   */
  public static void bubbleSort(int[] integers) {
    int n = integers.length;
    for (int i = 0; i < n - 1; i++) { 
      compareAndSwapAdjacentIntegers(integers, i);
    } 
  }

  /**
   * Compare each integer among those remaining that haven't been swapped to the end.
   * If the integer to the left is larger than the one to the right, swap places.
   *
   * @param integers the integers to be sorted.
   * @param alreadySorted the number of integers already moved over to the end of the array.
   */
  private static void compareAndSwapAdjacentIntegers(int[] integers, int alreadySorted) {
    int n = integers.length;
    for (int j = 0; j < n - 1 - alreadySorted; j++) { 
      if (integers[j] > integers[j + 1]) { 
        swap(integers, j + 1, j); 
      } 
    } 
  }
  
}