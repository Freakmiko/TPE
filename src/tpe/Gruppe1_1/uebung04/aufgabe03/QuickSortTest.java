package tpe.Gruppe1_1.uebung04.aufgabe03;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    SortAlgorithm sortAlgorithm = new QuickSort();

    @Test
    public void testSortedArray() throws Exception {
        Integer[] arr = new Integer[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
        };
        Integer[] arrSorted = new Integer[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
        };
        sortAlgorithm.sort(arr);
        for(int i = 0; i < arrSorted.length; i++)
            assertEquals(arrSorted[i], arr[i]);
    }

    @Test
    public void testSortShuffledNumbers() throws Exception {
        Integer[] arr = new Integer[] {
                4, 2, 6, 1, 3, 9, 8, 7, 5, 16, 12, 11, 10, 14, 15, 13
        };
        Integer[] arrSorted = new Integer[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
        };
        sortAlgorithm.sort(arr);
        for(int i = 0; i < arrSorted.length; i++)
            assertEquals(arrSorted[i], arr[i]);
    }
}