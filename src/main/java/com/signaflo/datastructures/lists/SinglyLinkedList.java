package com.signaflo.datastructures.lists;

import java.util.Objects;
import java.util.Optional;

public final class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void addFirst(T element) {
        this.head = new Node<>(element, head);
        if (isEmpty()) {
            this.tail = this.head;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> newest = new Node<>(element, null);
        if (isEmpty()) {
            this.head = newest;
        } else {
            this.tail.setNext(newest);
        }
        this.tail = newest;
        size++;
    }

    @Override
    public Optional<T> removeFirst() {
        if (isEmpty()) {
            return Optional.empty();
        }
        T first = this.head.getElement();
        this.head = this.head.getNext();
        size--;
        if (size == 0) {
            this.tail = null;
        }
        return Optional.of(first);
    }

    @Override
    public Optional<T> getFirst() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(this.head.getElement());
    }

    @Override
    public Optional<T> getLast() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(this.tail.getElement());
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    Node<T> getHead() {
        return this.head;
    }

    Node<T> getTail() {
        return this.tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SinglyLinkedList{");
        sb.append("head=").append(head);
        sb.append(", tail=").append(tail);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

    static class Node<T> {

        private T element;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        T getElement() {
            return this.element;
        }

        Node<T> getNext() {
            return this.next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(element, node.element) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, next);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("element=").append(element);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
