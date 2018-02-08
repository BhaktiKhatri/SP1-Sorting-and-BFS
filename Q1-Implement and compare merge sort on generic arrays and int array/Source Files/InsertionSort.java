package cs6301.g45;

/**
 * Implementation of Insertion Sort algorithm.
 * @author Lopamudra Muduli
 * @author Bhakti Khatri
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */

public class InsertionSort {
	
	//Insertion sort method
	static<T extends Comparable<? super T>> void nSquareSort(T[] arr) {
	
		for (int i=1; i<arr.length; ++i)
        {
            T key = arr[i];
            int j = i-1;
 
            while (j>=0 && arr[j].compareTo(key) <= 0)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
	}
	
	static<T> void printFirstTen(T[] arr) {
        int n = Math.min(arr.length, 10);
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }	
}
