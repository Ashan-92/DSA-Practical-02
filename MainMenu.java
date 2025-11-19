package dataSorterApp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class MainMenu {
	
	static int[] numbers = new int[0]; 
	
	// Get input number list from user 
	public static void enterNumbers(Scanner scanner) {
		 System.out.print("How many numbers? ");
	        int n = scanner.nextInt();
	        numbers = new int[n];
	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter number " + (i + 1) + ": ");
	            numbers[i] = scanner.nextInt();
	        }
	}
	
	// Random number Generator
	 private static void generateRandom(Scanner sc) {
	        System.out.print("Enter dataset size: ");
	        int n = sc.nextInt();
	        Random rand = new Random();
	        numbers = new int[n];
	        for (int i = 0; i < n; i++) numbers[i] = rand.nextInt(1000);
	        System.out.println("Random dataset generated!");
	    }
	
	// Perform bubble sort 
	public static void bubbleSort() {
		if (numbers.length == 0) { System.out.println("Please load data first."); return; }
        int[] arr = Arrays.copyOf(numbers, numbers.length);
        long start = System.nanoTime();
        BubleSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("Bubble Sorted: " + Arrays.toString(arr));
        System.out.println("Steps: " + BubleSort.steps + " | Time: " + (end - start) / 1e6 + " ms");
	}
	// Perform Merge sort method
	private static void mergeSort() {
        if (numbers.length == 0) { 
        	System.out.println("Please load data first."); 
        	return; 
        	}
        int[] arr = Arrays.copyOf(numbers, numbers.length);
        long start = System.nanoTime();
        MergeSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("Merge Sorted: " + Arrays.toString(arr));
        System.out.println("Steps: " + MergeSort.steps + " | Time: " + (end - start) / 1e6 + " ms");
    }
	//Perform quick sort
	private static void quickSort() {
        if (numbers.length == 0) {
        	System.out.println("Please load data first."); 
        	return; 
        	}
        int[] arr = Arrays.copyOf(numbers, numbers.length);
        long start = System.nanoTime();
        QuickSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("Quick Sorted: " + Arrays.toString(arr));
        System.out.println("Steps: " + QuickSort.steps + " | Time: " + (end - start) / 1e6 + " ms");
    }
	
	// performance comparing
	 private static void compareAll() {
	        if (numbers.length == 0) { System.out.println("Please load data first."); 
	        return; 
	        }

	        int[] a1 = Arrays.copyOf(numbers, numbers.length);
	        int[] a2 = Arrays.copyOf(numbers, numbers.length);
	        int[] a3 = Arrays.copyOf(numbers, numbers.length);

	        long t1 = System.nanoTime(); 
	        BubleSort.sort(a1); 
	        long e1 = System.nanoTime();
	        
	        long t2 = System.nanoTime(); 
	        MergeSort.sort(a2); 
	        long e2 = System.nanoTime();
	        
	        long t3 = System.nanoTime(); 
	        QuickSort.sort(a3); 
	        long e3 = System.nanoTime();

	        System.out.println("\n--- Comparison Table ---");
	        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Steps", "Time (ms)");
	        System.out.printf("%-15s %-15d %-15.3f%n", "Bubble Sort", BubleSort.steps, (e1 - t1) / 1e6);
	        System.out.printf("%-15s %-15d %-15.3f%n", "Merge Sort", MergeSort.steps, (e2 - t2) / 1e6);
	        System.out.printf("%-15s %-15d %-15.3f%n", "Quick Sort", QuickSort.steps, (e3 - t3) / 1e6);
	    }
	
	// Main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            // Display the menu
            System.out.println("\n---Welcome Data Sorter----"); 
            System.out.println("\n --Main Menu");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter Your choice.");
                scanner.next(); // consume invalid token
                continue;
            }
            // Get user input
            choice = scanner.nextInt();

            // Process the choice using a switch statement
        	
            switch (choice) {
            
                case 1-> enterNumbers(scanner);
                case 2-> generateRandom(scanner);    
                case 3-> bubbleSort();      
                case 4-> mergeSort();      
                case 5-> quickSort();
                case 6-> compareAll();
                case 7-> System.out.println("Existing");
                default-> System.out.println("Invalid Choice");	 
                     
            }
        } while (choice != 7); // Loop until the user chooses to exit

        scanner.close(); // Close the scanner to release resources
	}

}
