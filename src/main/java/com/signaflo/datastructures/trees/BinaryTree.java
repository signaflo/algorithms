package com.signaflo.datastructures.trees;

import com.signaflo.datastructures.Position;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface BinaryTree<T> extends Tree<T> {

    /**
     * Return the left child of the given node.
     *
     * @param node the node whose left child should be returned.
     *
     * @return The left child of the given node.
     */
    Optional<Position<T>> getLeftChild(@NonNull Position<T> node);

    /**
     * Return the right child of the given node.
     *
     * @param node the node whose right child should be returned.
     *
     * @return The right child of the given node.
     */
    Optional<Position<T>> getRightChild(@NonNull Position<T> node);

    /**
     * Return the sibling of the given node.
     *
     * @param node the node whose sibling should be returned.
     *
     * @return The sibling of the given node.
     */
    default Optional<Position<T>> getSibling(@NonNull Position<T> node) {
        Position<T> parent = this.getParent(node).orElse(null);
        if (parent == null) return Optional.empty();
        Position<T> leftChild = getLeftChild(node).orElse(null);
        if (node.equals(leftChild)) {
            return getRightChild(node);
        } else {
            return Optional.ofNullable(leftChild);
        }
    }

    @Override
    default int numChildren(Position<T> node) {
        int count = 0;
        if (getLeftChild(node).isPresent()) count++;
        if (getRightChild(node).isPresent()) count++;
        return count;
    }

    @Override
    default Iterable<Position<T>> getChildren(Position<T> node) {
        List<Position<T>> snapshot = new ArrayList<>(2);
        getLeftChild(node).ifPresent(snapshot::add);
        getRightChild(node).ifPresent(snapshot::add);
        return Collections.unmodifiableCollection(snapshot);
    }

}
