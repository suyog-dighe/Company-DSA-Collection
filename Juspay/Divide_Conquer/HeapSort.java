package Juspay.Divide_Conquer;

public class HeapSort {
        // Function to perform heap sort
        public static void heapSort(int[] arr) {
            int n = arr.length;

            // Step 1: Build max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            // Step 2: Extract elements from the heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Move current root (largest element) to end
                swap(arr, 0, i);

                // Heapify the reduced heap
                heapify(arr, i, 0);
            }
        }

        // To heapify a subtree rooted at index i
        public static void heapify(int[] arr, int n, int i) {
            int largest = i;  // Initialize largest as root
            int left = 2 * i + 1;  // Left child index
            int right = 2 * i + 2;  // Right child index

            // If left child is larger than root
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            // If right child is larger than the current largest
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            // If the largest element is not root
            if (largest != i) {
                swap(arr, i, largest);

                // Recursively heapify the affected subtree
                heapify(arr, n, largest);
            }
        }

        // Utility function to swap two elements in the array
        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Utility function to print the array
        public static void printArray(int[] arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Main function to test heap sort
        public static void main(String[] args) {
            int[] arr = {12, 11, 13, 5, 6, 7};
            System.out.println("Original array:");
            printArray(arr);

            heapSort(arr);

            System.out.println("Sorted array:");
            printArray(arr);
        }

}
