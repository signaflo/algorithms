/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.signaflo.algorithms;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SortingTest {

  private int[] testArray;

  @Before
  public void beforeMethod() {
    testArray = new int[] {4, 9, 7, 1, 3, 6, 5};
  }

  @Test
  public void whenSelectionSortThenArrayIsSorted() {
    int[] sorted = new int[] {1, 3, 4, 5, 6, 7, 9};
    Sorting.selectionSort(testArray);
    assertThat(testArray, is(sorted));
  }

  @Test
  public void whenMinimumIndexMethodCalledThenMinimumIndexReturned() {
    int indexOfSmallerValue = Sorting.getIndexOfSmallerValue(testArray, 0, testArray.length);
    assertThat(indexOfSmallerValue, is(3));
  }

  @Test
  public void whenSwapMethodThenArrayValuesAreSwappedAtGivenIndices() {
    Sorting.swap(testArray, 2, 5);
    int[] expected = {4, 9, 6, 1, 3, 7, 5};
    assertThat(testArray, is(expected));
  }
  
  @Test
  public void whenBubbleSortThenArrayIsSorted() {
    int[] sorted = new int[] {1, 3, 4, 5, 6, 7, 9};
    Sorting.bubbleSort(testArray);
    assertThat(testArray, is(sorted));
  }
  
  @Test
  public void whenMergeSortThenArrayIsSorted() {
    int[] expected = new int[] {1, 3, 4, 5, 6, 7, 9};
    int[] sorted = Sorting.mergeSort(testArray);
    assertThat(sorted, is(expected));
  }
  
  @Test
  public void whenCombineTwoArraysLeftSmallerThanRightThenCombinedWithCorrectOrder() {
    int[] array1 = new int[] {2, 3, 5};
    int[] array2 = new int[] {8, 13};
    int[] expected = new int[] {2, 3, 5, 8, 13};
    assertThat(Sorting.combine(array1, array2), is(expected));
  }
  
  @Test
  public void whenCombineTwoArraysRightSmallerThanLeftThenCombinedWithCorrectOrder() {
    int[] array1 = new int[] {8, 13};
    int[] array2 = new int[] {2, 3, 5};
    int[] expected = new int[] {2, 3, 5, 8, 13};
    assertThat(Sorting.combine(array1, array2), is(expected));
  }

  @Test
  public void whenQuickSortThenArrayIsSorted() {
    int[] expected = new int[] {1, 3, 4, 5, 6, 7, 9};
    Sorting.quickSort(testArray);
    assertThat(testArray, is(expected));
  }
  
}
