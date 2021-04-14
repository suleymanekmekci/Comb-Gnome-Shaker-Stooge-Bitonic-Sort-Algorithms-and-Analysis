import java.util.Collections;
import java.util.List;

public class SortAlgorithms {
    double elapsedTimeComb,elapsedTimeGnome,elapsedTimeShaker,elapsedTimeStooge,elapsedTimeBitonic;

    public <T extends Comparable<T>>void combSort(List<T> input) {
        // calculate time


        double gap = input.size();
        float shrink = 1.3f;
        boolean sorted = false;
        double start = System.nanoTime();
        while (!sorted) {
            // Reduce gap in each loop
            gap = Math.floor(gap/shrink);

            if (gap <= 1){
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while (i + gap < input.size()) {
                if (input.get(i).compareTo(input.get(i + (int) gap)) > 0) {
                    // swap two indices with each other
                    swap( i, i+ (int)gap, input );
                }

                i++;
            }
        }
        double end = System.nanoTime();
        elapsedTimeComb = end-start;
    }

    public <T extends Comparable<T>>void gnomeSort(List<T> input) {
        double start = System.nanoTime();
        int position = 0;

        while (position < input.size()) {
            if (position == 0 || input.get(position).compareTo(input.get(position-1)) >= 0) {
                position++;
            }
            else {
                swap(position,position-1,input);
                position--;
            }

        }

        double end = System.nanoTime();
        elapsedTimeGnome = end-start;
    }

    public <T extends Comparable<T>>void shakerSort(List<T> input) {
        double start = System.nanoTime();

        boolean swapped = true;
        do {
            swapped = false;

            for (int i = 0; i < input.size() - 1; i++) {
                if (input.get(i).compareTo(input.get(i+1)) > 0 ) {
                    swap(i,i+1,input);
                    swapped=true;
                }
            }

            // if not swapped, it means array is already sorted. break
            if (!swapped) {
                break;
            }
            swapped = false;

            // iterate from end to beginning
            for (int i = input.size() - 2; i >= 0 ; i--) {
                if (input.get(i).compareTo(input.get(i+1)) > 0 ) {
                    swap(i,i+1,input);
                    swapped=true;
                }
            }


        } while (swapped);

        double end = System.nanoTime();
        elapsedTimeShaker = end-start;
    }


    public  <T extends Comparable<T>>void stoogeSort(List<T> input) {
        double start = System.nanoTime();
        stoogeSortHelper(input,0,input.size()-1);
        double end = System.nanoTime();
        elapsedTimeStooge = end-start;

    }
    private static  <T extends Comparable<T>>void stoogeSortHelper(List<T> input,int i,int j) {
        if (input.get(i).compareTo(input.get(j)) > 0)
            swap(i,j,input);

        if ((j - i + 1) > 2) {
            double t = Math.floor( (j - i + 1) / 3 );
            // sort first 2/3 part of the array
            stoogeSortHelper(input, i , (int) (j-t));

            // sort last 2/3 part of the array
            stoogeSortHelper(input, (int) (i+t), j);

            // sort again first 2/3 part of the array
            stoogeSortHelper(input, i , (int) (j-t));

        }

    }

    private static  <T extends Comparable<T>>void compAndSwap(List<T> input, int i, int j, int dire){

        if ( ( dire == 1 && (input.get(i).compareTo(input.get(j)) > 0) )  || (dire==0 && input.get(i).compareTo(input.get(j)) < 0 ) )
            swap(i,j,input);
    }
    private static  <T extends Comparable<T>>void bitonicMerge(List<T> input, int low, int count, int dire){
        if (count > 1) {
            int k = count/2;
            for (int i = low; i < low+k; i++)
                compAndSwap(input, i, i+k, dire);

            bitonicMerge(input, low, k, dire);
            bitonicMerge(input, low+k, k, dire);

        }
    }

    private static  <T extends Comparable<T>>void bitonicSortHelper(List<T> input,int low,int count,int dire) {
        if (count > 1) {
            int k = count/2;
            bitonicSortHelper(input, low, k, 1);
            bitonicSortHelper(input, low+k, k, 0);
            bitonicMerge(input, low, count, dire);
        }
    }


    public  <T extends Comparable<T>>void bitonicSort(List<T> input) {
        double start = System.nanoTime();
        bitonicSortHelper(input,0,input.size(),1);
        double end = System.nanoTime();


        elapsedTimeBitonic = (end-start);

    }


    public static  <T extends Comparable<T>>void swap(int left, int right, List<T> input) {
        T temp = input.get(left);
        input.set(left,input.get(right));
        input.set(right,temp);
    }
}
