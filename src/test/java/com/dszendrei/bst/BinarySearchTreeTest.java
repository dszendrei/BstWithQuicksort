package com.dszendrei.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void init() {
        binarySearchTree = new BinarySearchTree();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        binarySearchTree.buildFromSortedList(list);
    }

    @Test
    void build() {
        assertEquals(10, binarySearchTree.toList().size());
    }

    @Test
    void search() {
        assertTrue(binarySearchTree.search(0));
        assertTrue(binarySearchTree.search(9));
        assertFalse(binarySearchTree.search(-1));
        assertFalse(binarySearchTree.search(10));
    }

    @Test
    void searchIfInputIsNotSorted() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 9, 0, 6, 4, 3, 7, 5, 8, 1));
        binarySearchTree.buildFromUnsortedList(list);
        assertTrue(binarySearchTree.search(0));
        assertTrue(binarySearchTree.search(9));
        assertFalse(binarySearchTree.search(-1));
        assertFalse(binarySearchTree.search(10));
    }

    @Test
    void getNode() {
        BstNode testNode = new BstNode(5);
        testNode.rightNode = new BstNode(7);
        testNode.leftNode = new BstNode(2);
        BstNode testNode2 = new BstNode(3);
        testNode2.rightNode = new BstNode(4);
        assertEquals(binarySearchTree.getNode(5), testNode);
        assertEquals(binarySearchTree.getNode(3), testNode2);
    }


    @Test
    void add() {
        binarySearchTree.add(10);
        assertTrue(binarySearchTree.search(10));
        assertTrue(binarySearchTree.search(9));
        assertFalse(binarySearchTree.search(11));
    }

    @Test
    void addAlreadyExistingKey() {
        assertThrows(KeyAlreadyExistsException.class, () -> binarySearchTree.add(0));
    }

    @Test
    void remove() {
        binarySearchTree.remove(0);
        assertFalse(binarySearchTree.search(0));
        assertTrue(binarySearchTree.search(1));
        binarySearchTree.remove(9);
        assertFalse(binarySearchTree.search(9));
        assertTrue(binarySearchTree.search(8));
    }

    @Test
    void removeNoExisting() {
        assertThrows(NoSuchElementException.class, () -> binarySearchTree.remove(10));
    }

    @Test
    void toList() {
        assertEquals(binarySearchTree.toList().size(), 10);
    }
}