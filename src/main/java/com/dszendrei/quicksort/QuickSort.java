package com.dszendrei.quicksort;

import java.util.List;

public class QuickSort {

    /**
     * Sorts the given List in place.
     *
     * @param toSort the List to sort. Throws an error if its null, or contains null.
     */
    public void sort(List<Integer> toSort) {
        if (toSort == null) throw new IllegalArgumentException();
        recursiveSorting(toSort,0,toSort.size()-1);
    }

    /**
     * Sorts the given List in place.
     * Static version.
     * @param toSort the List to sort. Throws an error if its null, or contains null.
     */
    public static void quickSort(List<Integer> toSort) {
        new QuickSort().sort(toSort);
    }

    private void recursiveSorting(List<Integer> toSort, int leftIndex, int rightIndex) {

        if (rightIndex-leftIndex<1) return;

        int pivotIndex = (leftIndex+rightIndex)/2;
        Integer pivot = toSort.get(pivotIndex);
        int initialLeftIndex = leftIndex;
        int initialRightIndex = rightIndex;
        Integer left;
        Integer right;

        while (leftIndex < rightIndex) {
            left = toSort.get(leftIndex);
            right = toSort.get(rightIndex);

            while (left < pivot) {
                leftIndex++;
                left = toSort.get(leftIndex);
            }

            while (right > pivot) {
                rightIndex--;
                right = toSort.get(rightIndex);
            }

            if (left.equals(right)) break;

            if (left > right) {
                toSort.set(leftIndex, right);
                if (leftIndex !=  rightIndex) toSort.set(rightIndex, left);
            }
        }
        recursiveSorting(toSort, initialLeftIndex, leftIndex);
        recursiveSorting(toSort, leftIndex+1, initialRightIndex);
    }
}
