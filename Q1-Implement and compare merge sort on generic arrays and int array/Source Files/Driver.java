package cs6301.g45;

import java.util.Random;
import java.util.Scanner;

/**
 * Java Program to run the sorting algorithms
 * @author Lopamudra Muduli
 * @author Bhakti Khatri
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */


public class Driver {
	
	Timer timer = new Timer(); //Timer used for running time of merge sort
	
	public int[] createRandArray(int length){
		int[] arr = new int[length]; //input array to be sorted
		
		Random rand = new Random(); //Generate random numbers used for input array
		for(int i=0; i<length; i++) {
		    arr[i] = rand.nextInt(length);
		}
		return arr;
	}
	
	/*For merge sort using generic array*/
	public void mGSort(int length){
		Integer[] arr = new Integer[length]; //input array to be sorted
		Integer[] temp = new Integer[length]; //temporary array to be used during the merge operation.
		
		Random rand = new Random(); //Generate random numbers used for input array
		for(int i=0; i<length; i++) {
		    arr[i] = rand.nextInt(length);
		}
		System.out.print("First 10 elements in the Input unsorted array : ");
		MergeSortUsingGenerics.printFirstTen(arr);
		timer.start();
	    MergeSortUsingGenerics.mergeSort(arr,temp,0,length - 1);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		MergeSortUsingGenerics.printFirstTen(arr);

	}
		
	/*For N^2 insertion sort using int array*/
	public void iSort(int length){
		Integer[] arr = new Integer[length]; //input array to be sorted
		Random rand = new Random(); //Generate random numbers used for input array
		for(int i=0; i<length; i++) {
		    arr[i] = rand.nextInt(length);
		}
		System.out.print("First 10 elements in the Input unsorted array : ");
		InsertionSort.printFirstTen(arr);
	    timer.start();
	    InsertionSort.nSquareSort(arr);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		InsertionSort.printFirstTen(arr);

	}
	
	/*For merge sort using int array*/
	public void mSort(int length){
		int[] temp = new int[length]; //temporary array to be used during the merge operation.
		int[] arr = createRandArray(length);
		System.out.print("First 10 elements in the Input unsorted array : ");
		MergeSUsingIntArray.printFirstTen(arr);
	    timer.start();
	    MergeSUsingIntArray.mergeSort(arr,temp,0,length - 1);
		System.out.println(timer.end());
		System.out.print("First 10 elements in the Output sorted array : ");
		MergeSUsingIntArray.printFirstTen(arr);

	}
	
	public static void main(String[] args) {
		Scanner sc = null;
		int length;
		Driver d = new Driver();
		if (args.length == 2){
			length = Integer.parseInt(args[0]);
			System.out.println("Size of the input array:"+ length);
			if (args[1].equalsIgnoreCase("1")) {
				System.out.println("----------------------------------");
				System.out.println("MergeSortIntArray:");
				d.mSort(length);
			} else if (args[1].equalsIgnoreCase("2")) {
				System.out.println("----------------------------------");
				System.out.println("InsertionSort:");
				d.iSort(length);
			} else if (args[1].equalsIgnoreCase("3")) {
				System.out.println("----------------------------------");
				System.out.println("MergeSortGen:");
				d.mGSort(length);
			}
			
		} else {
			System.out.println("Invalid Argument. java <program> <arraysize> <sorttype>");
		}
	}

}
