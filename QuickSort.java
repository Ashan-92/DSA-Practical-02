package dataSorterApp;


public class QuickSort {
	//step count varible intizialize
	    public static int steps = 0;

	    // Public variable to reset steps and call recursive sort
	    public static void sort(int[] arr) {
	        steps = 0;
	        if (arr == null || arr.length < 2) return;
	        sortRec(arr, 0, arr.length - 1);
	    }
// recursive
	    private static void sortRec(int[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            sortRec(arr, low, pi - 1);
	            sortRec(arr, pi + 1, high);
	        }
	    }
//divider
	    private static int partition(int[] arr, int low, int high) {
	        int pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            steps++;
	            if (arr[j] < pivot) {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i + 1]; 
	        arr[i + 1] = arr[high];
	        arr[high] = temp;
	        return i + 1;
	    }
	}

