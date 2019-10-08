package com.signaflo.datastructures;

import lombok.NonNull;

public class PositionalNode<T> implements Position<T> {

    private final T element;

    PositionalNode(@NonNull T element) {
        this.element = element;
    }

    @Override
    public T getElement() throws IllegalStateException {
        return element;
    }
}
