package com.signaflo.datastructures.lists;

import java.util.Optional;

public interface LinkedList<T> {

    /**
     * Add a new element to the front of the list.
     *
     * @param element The element to add to the front of the list.
     */
    void addFirst(T element);

    /**
     * Add a new element to the end of the list.
     *
     * @param element The element to add to the end of the list.
     */
    void addLast(T element);

    /**
     * Removes and returns the first element of the list.
     *
     * @return The first element of the list.
     */
    Optional<T> removeFirst();


    /**
     * Returns but does not remove the first element in the list.
     *
     * @return The first element in the list.
     */
    Optional<T> getFirst();

    /**
     * Returns but does not remove the last element in the list.
     *
     * @return The last element of the list.
     */
    Optional<T> getLast();

    /**
     * Return the current number of elements in the list.
     *
     * @return THe current number of elements in the list.
     */
    int getSize();

    /**
     * Return true if the list is empty and false otherwise.
     *
     * @return True if the list is empty and false otherwise.
     */
    boolean isEmpty();

}
