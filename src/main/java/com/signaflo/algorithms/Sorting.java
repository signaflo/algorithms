package com.signaflo.algorithms;

import lombok.NonNull;

/**
 * A collection of sorting functions (in the form of static methods).
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
  // Swapping is done in place, mutating the passed in array.
  static void swap(int[] integers, int firstIndex, int secondIndex) {
    int temp = integers[firstIndex];
    integers[firstIndex] = integers[secondIndex];
    integers[secondIndex] = temp;
  }

  /**
   * Sorts an array of integers using the bubble sort algorithm.
   * 
   * The array is sorted in place in ascending order.
   * 
   * @param integers the elements to sort.
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
   * @param integers the elements to be compared.
   * @param alreadyBubbled the number of integers already moved over to the end of the array.
   */
  private static void compareAndSwapAdjacentIntegers(int[] integers, int alreadyBubbled) {
    int n = integers.length;
    for (int j = 0; j < n - 1 - alreadyBubbled; j++) { 
      if (integers[j] > integers[j + 1]) { 
        swap(integers, j + 1, j); 
      } 
    } 
  }
  
  public static int[] mergeSort(int[] integers) {
    return mergeSort(integers, integers.length);
  }
  
  private static int[] mergeSort(int[] integers, int n) {
    if (n < 2) {
      return integers;
    }
    
    int leftLength = n / 2;
    int rightLength = (n % 2 == 0)? (n / 2) : ((n + 1) / 2);
    int[] left = new int[leftLength];
    int[] right = new int[rightLength];
    System.arraycopy(integers, 0, left, 0, leftLength);
    System.arraycopy(integers, leftLength, right, 0, rightLength);
    
    left = mergeSort(left, left.length);
    right = mergeSort(right, right.length);
    return combine(left, right);
  }
  
  static int[] combine(int[] array1, int[] array2) {
    int[] combined = new int[array1.length + array2.length];
    int leftIndex = 0;
    int rightIndex = 0;
    
    for (int i = 0; i < combined.length; i++) {
      if (leftIndex == array1.length) { // There are no more elements to compare in array1.
        if (rightIndex < array2.length) {
          combined[i] = array2[rightIndex++];
        }
      } else if (rightIndex == array2.length) { // There are no more elements to compare in array2.
        if (leftIndex < array1.length) {
          combined[i] = array1[leftIndex++];
        }
      } else { // There are elements left to compare in both arrays.
        if (array1[leftIndex] < array2[rightIndex]) {
          combined[i] = array1[leftIndex++];
        } else {
          combined[i] = array2[rightIndex++];
        }
      }
    }
    return combined;
  }

  public static void quickSort(@NonNull int[] array) {
    if (array.length > 1) {
      quickSort(array, 0, array.length - 1);
    }
  }

  private static void quickSort(int[] array, int start, int end) {
    int partitionPoint = partition(array, start, end);

    if (partitionPoint - 1 > start) {
      quickSort(array, start, partitionPoint - 1);
    }
    if (partitionPoint + 1 < end) {
      quickSort(array, partitionPoint + 1, end);
    }
  }

  private static int partition(int[] array, int start, int end) {
    int pivot = array[end];

    for (int i = start; i < end; i++) {
      if (array[i] < pivot) {
        swap(array, start, i);
        start++;
      }
    }

    swap(array, start, end);
    return start;
  }
  
}
