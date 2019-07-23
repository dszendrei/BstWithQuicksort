package com.dszendrei.bst;

import com.dszendrei.quicksort.QuickSort;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

public class BinarySearchTree {

    private BstNode rootNode;
    private Set<Integer> listOfValues = new HashSet<>();
    private BstNode nodeToGet;

    public void buildFromUnsortedList(List<Integer> elements){
        QuickSort.quickSort(elements);
        buildFromSortedList(elements);
    }

    public void buildFromSortedList(List<Integer> elements) {
        rootNode = new BstNode(elements.get(elements.size()/2));
        int i = 2;
        Set<Integer> orderedElements = new LinkedHashSet<>();
        Integer actualValue;
        int index;
        do {
            index = elements.size()/(i);
            while (index < elements.size() && index > 0) {
                actualValue = elements.get(index);
                orderedElements.add(actualValue);
                index += elements.size()/(i/2);
            }
            i = i*2;
        } while (index>0);
        orderedElements.addAll(elements);
        orderedElements.forEach(integer -> addRecursive(rootNode, integer));
    }

    public boolean search(Integer toFind) {
        return containsNodeRecursive(rootNode, toFind);
    }

    public BstNode getNode(Integer toGet) {
        if (search(toGet)) return nodeToGet;
        return null;
    }


    public void add(Integer toAdd) {
        toList();
        if (listOfValues.contains(toAdd)) throw new KeyAlreadyExistsException();
        listOfValues.add(toAdd);
        List<Integer> elements = new ArrayList<>(listOfValues);
        elements.sort(Integer::compareTo);
        buildFromSortedList(elements);
    }

    private BstNode addRecursive(BstNode current, int value) {
        if (current == null) {
            return new BstNode(value);
        }
        if (value < current.value) {
            current.leftNode = addRecursive(current.leftNode, value);
        } else if (value > current.value) {
            current.rightNode = addRecursive(current.rightNode, value);
        } else {
            return current;
        }
        return current;
    }

    public void remove(Integer toRemove) {
        toList();
        if (!listOfValues.contains(toRemove)) throw new NoSuchElementException();
        listOfValues.remove(toRemove);
        List<Integer> elements = new ArrayList<>(listOfValues);
        elements.sort(Integer::compareTo);
        buildFromSortedList(elements);
    }

    public List<Integer> toList() {
        listOfValues = new HashSet<>();
        addRecursiveToList(rootNode);
        return new ArrayList<>(listOfValues);
    }

    private BstNode addRecursiveToList(BstNode current) {
        listOfValues.add(current.value);
        if(current.leftNode != null) {
            if (!listOfValues.contains(current.leftNode.value)) {
                current.leftNode = addRecursiveToList(current.leftNode);
            }
        }
        if(current.rightNode != null) {
            if (!listOfValues.contains(current.rightNode.value)) {
                current.rightNode = addRecursiveToList(current.rightNode);
            }
        } else {
            return current;
        }
        return current;
    }

    private boolean containsNodeRecursive(BstNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            nodeToGet = current;
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.leftNode, value)
                : containsNodeRecursive(current.rightNode, value);
    }
}
