package com.signaflo.datastructures;

public interface Position<T> {

    /**
     * Returns the element stored at this position.
     *
     * @return The element stored at this position.
     *
     * @throws IllegalStateException if position is invalid.
     */
    T getElement() throws IllegalStateException;
}
