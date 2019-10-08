package com.signaflo.datastructures.trees;

import com.signaflo.datastructures.Position;
import lombok.NonNull;

import java.util.Iterator;
import java.util.Optional;

/**
 *
 * A hierarchical structure composed of nodes with parent-child relationships.
 *
 * Any methods passed a null node element throw a NullPointerException.
 *
 * @param <T> The type of node elements in the tree.
 */
public interface Tree<T> extends Iterable<T> {

    /**
     * Returns the root node, or nothing if the tree is empty.
     *
     * @return The root node, or nothing if the tree is empty.
     */
    Optional<Position<T>> getRoot();

    /**
     * Returns the parent of the given node, or nothing if the given node is the root or not a member of the tree.
     *
     * @param node The child node.
     *
     * @return The parent of the given node, or nothing if the given node is the root or not a member of the tree.
     */
    Optional<Position<T>> getParent(@NonNull Position<T> node);

    Iterable<Position<T>> getChildren(@NonNull Position<T> node);

    int numChildren(@NonNull Position<T> node);

    int getSize();

    Iterator<T> iterator();

    Iterable<Position<T>> getPositions();

    default boolean isInternal(@NonNull Position<T> node) {
        return numChildren(node) > 0;
    }

    default boolean isExternal(@NonNull Position<T> node) {
        return numChildren(node) == 0;
    }

    default boolean isRoot(@NonNull Position<T> node) {
        return getRoot().filter(node::equals).isPresent();
    }

    default boolean isEmpty() {
        return getSize() == 0;
    }

    default int getDepth(@NonNull Position<T> node) {
        if (isRoot(node)) {
            return 0;
        }
        Optional<Position<T>> parent = getParent(node);
        return 1 + (parent.isPresent() ? getDepth(parent.get()) : 0);
    }

    default int getHeight() {
        return getRoot().map(this::getHeight).orElse(0);
    }

    default int getHeight(@NonNull Position<T> root) {
        int h = 0;
        for (Position<T> child: getChildren(root)) {
            h = Math.max(h, 1 + getHeight(child));
        }
        return h;
    }

}
