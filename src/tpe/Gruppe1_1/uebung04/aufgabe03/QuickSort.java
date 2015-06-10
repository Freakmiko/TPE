package tpe.Gruppe1_1.uebung04.aufgabe03;

public class QuickSort extends Thread implements SortAlgorithm{

    private static ThreadGroup threadGroup = new ThreadGroup("quickSorty");

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        Integer[] arr = new Integer[9];
        for(int i=0; i < arr.length; i++)
            arr[i] = (int)(Math.random() * 100);

        for (Integer anArr1 : arr) System.out.print(anArr1 + ";");
        System.out.println();

        s.sort(arr);

        System.out.println("YAAAAAYY WE'RE FINISHED==================================");
        for (Integer anArr : arr) System.out.print(anArr + ";");

    }

    private int lowerBound;
    private int upperBound;
    private Comparable[] arr;

    public QuickSort() {
        super(threadGroup, "quickSortThread");
    }

    /**
     * This Method sorts a given array using some
     * algorithm.
     *
     * @param array The array that should be sorted
     */
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
        for (Comparable anArray1 : array) System.out.print(anArray1 + ";");
        System.out.println();

        int i = split(array, lower, upper);

        for (Comparable anArray : array) System.out.print(anArray + ";");
        System.out.println();


        Thread t1 = new QuickSort() {
            {
                setLowerBound(lower);
                setUpperBound(i - 1);
                setArr(array);
            }
        };
        t1.run();

        Thread t2 = new QuickSort() {
            {
                setLowerBound(i + 1);
                setUpperBound(upper);
                setArr(array);
            }
        };
        t2.run();
    }

    public int split(Comparable[] array, int lower, int upper) {
        int index = lower;

        for (int pointer = lower; pointer < upper; pointer++) {
            if(array[pointer].compareTo(array[upper]) <= 0) {
                swap(array, index, pointer);
                index++;
            }
        }

        swap(array, index, upper);
        return index;
    }

    @Override
    public void run() {
        quickSort(getArr(), getLowerBound(), getUpperBound());
    }

    public void swap(Comparable[] array, int el01, int el02) {
        Comparable temp;
        temp = array[el01];
        array[el01] = array[el02];
        array[el02] = temp;
    }

    private int getLowerBound() {
        return lowerBound;
    }

    private void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    private int getUpperBound() {
        return upperBound;
    }

    private void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    private Comparable[] getArr() {
        return arr;
    }

    private void setArr(Comparable[] arr) {
        this.arr = arr;
    }
}
