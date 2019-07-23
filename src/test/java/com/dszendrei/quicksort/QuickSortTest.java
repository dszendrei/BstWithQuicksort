package com.dszendrei.quicksort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sortingNullThrowsError() {
        QuickSort quickSort = new QuickSort();
        assertThrows(IllegalArgumentException.class, ()-> quickSort.sort(null));
    }

    @Test
    void sortingWithNullThrowsError() {
        QuickSort quickSort = new QuickSort();
        List<Integer> toSort = Arrays.asList(5, null, 1, 12, 9);
        assertThrows(NullPointerException.class, ()-> quickSort.sort(toSort));
    }

    @Test
    void sortingAlreadySortedItemsWorks() {
        QuickSort quickSort = new QuickSort();

        List<Integer> toSort = Arrays.asList(1, 3, 5, 9, 12);
        System.out.println("Initial list: "+toSort);
        quickSort.sort(toSort);
        System.out.println("Sorted list: "+toSort+"\n");

        List<Integer> expected = Arrays.asList(1, 3, 5, 9, 12);
        assertIterableEquals(expected, toSort);
    }

    @Test
    void sortingSimpleItemsWorks() {
        QuickSort quickSort = new QuickSort();

        List<Integer> toSort = Arrays.asList(5, 3, 1, 12, 9);
        System.out.println("Initial list: "+toSort);
        quickSort.sort(toSort);
        System.out.println("Sorted list: "+toSort+"\n");

        List<Integer> expected = Arrays.asList(1, 3, 5, 9, 12);
        assertIterableEquals(expected, toSort);

        List<Integer> toSort1 = Arrays.asList(5, 3, 1, 12, 9, 110, 2, 45, 78, 56, 42);
        System.out.println("Initial list: "+toSort);
        quickSort.sort(toSort1);
        System.out.println("Sorted list: "+toSort+"\n");

        List<Integer> expected1 = Arrays.asList(1, 2, 3, 5, 9, 12, 42, 45, 56, 78, 110);
        assertIterableEquals(expected1, toSort1);

        List<Integer> toSort2 = Arrays.asList(3, 2, 1);
        System.out.println("Initial list: "+toSort);
        quickSort.sort(toSort2);
        System.out.println("Sorted list: "+toSort+"\n");

        List<Integer> expected2 = Arrays.asList(1, 2, 3);
        assertIterableEquals(expected2, toSort2);
    }

    @Test
    void sortingNegativeItemsWorks() {
        QuickSort quickSort = new QuickSort();

        List<Integer> toSort = Arrays.asList(5, -3, 1, 12, 9);
        System.out.println("Initial list: "+toSort);
        quickSort.sort(toSort);
        System.out.println("Sorted list: "+toSort+"\n");

        List<Integer> expected = Arrays.asList(-3, 1, 5, 9, 12);
        assertIterableEquals(expected, toSort);
    }

    @Test
    void sortingDuplicateItemsWorks() {
        QuickSort quickSort = new QuickSort();

        List<Integer> toSort = Arrays.asList(5, 3, 1, 5, 9);
        System.out.println("Initial list: "+toSort);
        quickSort.sort(toSort);
        System.out.println("Sorted list: "+toSort+"\n");

        List<Integer> expected = Arrays.asList(1, 3, 5, 5, 9);
        assertIterableEquals(expected, toSort);
    }

    @Test
    void sortingOneItemWorks() {
        QuickSort quickSort = new QuickSort();

        List<Integer> toSort = Arrays.asList(2);
        quickSort.sort(toSort);

        List<Integer> expected = Arrays.asList(2);
        assertIterableEquals(expected, toSort);
    }

    @Test
    void sortingZeroItemWorks() {
        QuickSort quickSort = new QuickSort();

        List<Integer> toSort = new ArrayList<>();
        quickSort.sort(toSort);

        assertEquals(0, toSort.size());
    }
}