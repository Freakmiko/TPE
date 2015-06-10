package tpe.Gruppe1_1.uebung04.aufgabe03;

import java.util.Collections;

public class QuickSort extends Thread implements SortAlgorithm{

    private static ThreadGroup threadGroup = new ThreadGroup("quickSorty");

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        Integer[] arr = new Integer[9];
        for(int i=0; i < arr.length; i++)
            arr[i] = (int)(Math.random() * 100);

        for(int i=0; i < arr.length; i++)
            System.out.print(arr[i] + ";");
        System.out.println();
        s.sort(arr);

        System.out.println("YAAAAAYY WE'RE FINISHED==================================");
        for(int i=0; i < arr.length; i++)
            System.out.print(arr[i] + ";");

    }

    public int lowerBound;
    public int upperBound;
    public Comparable[] arr;

    public QuickSort() {
        super(threadGroup, "quickSortThread");
    }

    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
        while(threadGroup.activeCount() > 0)
            try {
                wait(160);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void quickSort(Comparable[] array, int lower, int upper) {
        if (upper <= lower) return ;

        System.out.println(this.getName());
        for(int counter=0; counter < array.length; counter++)
            System.out.print(array[counter] + ";");
        System.out.println();

        int i = split(array, lower, upper);

        for(int counter=0; counter < array.length; counter++)
            System.out.print(array[counter] + ";");
        System.out.println();


        Thread t1 = new QuickSort() {
            {
                lowerBound = lower;
                upperBound = i - 1;
                arr = array;
            }
        };
        t1.run();

        Thread t2 = new QuickSort() {
            {
                lowerBound = i + 1;
                upperBound = upper;
                arr = array;
            }
        };
        t2.run();
    }

    public int split(Comparable[] array, int lower, int upper) {
        int pivotElement = upper;
        int index = lower;

        for (int pointer = lower; pointer < upper; pointer++) {
            if(array[pointer].compareTo(array[pivotElement]) <= 0) {
                swap(array, index, pointer);
                index++;
            }
        }

        swap(array, index, pivotElement);
        return index;
    }

    @Override
    public void run() {
        quickSort(arr, lowerBound, upperBound);
    }

    public void swap(Comparable[] array, int el01, int el02) {
        Comparable temp;
        temp = array[el01];
        array[el01] = array[el02];
        array[el02] = temp;
    }

}
