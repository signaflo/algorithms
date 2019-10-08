package com.signaflo.datastructures;

class ArrayStack<T> implements Stack<T> {

    private final T[] elements;

    @SuppressWarnings("unchecked")
    ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(T value) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T top() {
        return null;
    }
}
