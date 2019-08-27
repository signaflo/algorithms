package com.signaflo.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
  
  private int[] evenLengthArray = new int[] {1, 2, 4, 5, 7, 8, 9, 11};
  private int[] oddLengthArray = new int[] {1, 2, 4, 5, 7, 8, 9};

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void whenBinarySearchValueEvenLengthOddIndexThenCorrectIndexReturned() {
    int value = 8;
    int correctIndex = 5;
    assertThat(Search.binarySearch(evenLengthArray, value), is (correctIndex));
  }

  @Test
  public void whenBinarySearchValueEvenLengthEvenIndexThenCorrectIndexReturned() {
    int value = 4;
    int correctIndex = 2;
    assertThat(Search.binarySearch(evenLengthArray, value), is (correctIndex));
  }

  @Test
  public void whenBinarySearchValueOddLengthOddIndexThenCorrectIndexReturned() {
    int value = 2;
    int correctIndex = 1;
    assertThat(Search.binarySearch(oddLengthArray, value), is(correctIndex));
  }

  @Test
  public void whenBinarySearchValueOddLengthEvenIndexThenCorrectIndexReturned() {
    int value = 4;
    int correctIndex = 2;
    assertThat(Search.binarySearch(oddLengthArray, value), is(correctIndex));
  }
  
  @Test
  public void whenLinearSearchThenCorrectIndex() {
    int value = 4;
    int correctIndex = 2;
    assertThat(Search.linearSearch(oddLengthArray, value), is(correctIndex));
  }
  
  @Test
  public void whenValueNotInArrayAndBinarySearchThenNoSuchElementException() {
    exception.expect(NoSuchElementException.class);
    Search.binarySearch(evenLengthArray, 3);
  }
  
  @Test
  public void whenValueNotInArrayAndLinearSearchThenNoSuchElementException() {
    exception.expect(NoSuchElementException.class);
    Search.linearSearch(evenLengthArray, 3);
  }
}
