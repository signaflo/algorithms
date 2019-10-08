package com.signaflo.datastructures;

public interface Stack<T> {

    /**
     * Returns the number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    int size();

    /**
     * Returns true if the stack is empty and false otherwise.
     * @return True if the stack is empty and false otherwise.
     */
    boolean isEmpty();

    /**
     * Pushes a new value onto the top of the stack.
     *
     * @param value the value to place on top of the stack.
     */
    void push(T value);

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     */
    T pop();

    /**
     * Returns, but does not remove, the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     */
    T top();

    static <T> Stack<T> newArrayStack(int capacity) {
        return new ArrayStack<>(capacity);
    }
}
