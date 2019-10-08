package com.signaflo.datastructures.lists;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList<String> list = null;

    @Before
    public void beforeMethod() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void whenConstructEmptySinglyLinkedListThenFirstAndLastAreEmpty() {
        assertThat(list.getFirst(), is(Optional.empty()));
        assertThat(list.getLast(), is(Optional.empty()));
    }

    @Test
    public void whenAddFirstToEmptyListThenSizeEqualsOne() {
        list.addFirst("MSP");
        assertThat(list.getSize(), is(1));
    }

    @Test
    public void whenAddFirstToEmptyListThenFirstEqualsLast() {
        list.addFirst("MSP");
        assertThat(list.getFirst(), is(list.getLast()));
    }

    @Test
    public void whenAddFirstToEmptyListThenHeadNextIsNull() {
        list.addFirst("MSP");
        assertThat(list.getHead().getNext(), is(nullValue()));
    }

    @Test
    public void whenAddSecondElementToListThenHeadNextIsFirstElement() {
        list.addFirst("MSP");
        SinglyLinkedList.Node<String> firstElement = list.getHead();
        list.addFirst("JFK");
        assertThat(list.getHead().getNext(), is(firstElement));
    }

    @Test
    public void whenRemoveFirstFromEmptyListThenEmptyOptionalAndSizeIsZero() {
        assertThat(list.removeFirst(), is(Optional.empty()));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void whenRemoveFirstFromOneElementListThenSizeIsZeroAndFirstAndLastAreNull() {
        list.addFirst("MSP");
        list.removeFirst();
        assertThat(list.getSize(), is(0));
        assertThat(list.getFirst(), is(Optional.empty()));
        assertThat(list.getLast(), is(Optional.empty()));
    }

    @Test
    public void whenAddLastToEmptyListThenFirstEqualsLastAndSizeEqualsOne() {
        list.addLast("MSP");
        assertThat(list.getSize(), is(1));
        assertThat(list.getFirst(), is(list.getLast()));
    }

}
