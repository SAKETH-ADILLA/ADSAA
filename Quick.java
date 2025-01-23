import java.util.*;

public class Quick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = in.nextInt();
        int a[] = new int[n];
        System.out.println("Enter Elements: ");
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        long start = System.nanoTime();
        quicksort(a, 0, n - 1);  // Initial call to quicksort with the full array range
        long end = System.nanoTime();

        System.out.println("Sorted Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println("\nTotal Time Taken: " + (end - start) + "ns");
    }

    public static void quicksort(int a[], int low, int high) {
        if (low < high) {
            int n = partition(a, low, high);
            quicksort(a, low, n - 1);   // Recursively sort the left part
            quicksort(a, n + 1, high);  // Recursively sort the right part
        }
    }

    public static int partition(int a[], int low, int high) {
        int pivot = a[low];  // Choosing the first element as the pivot
        int i = low + 1;
        int j = high;
        while (i <= j) {
            // Move i to the right as long as a[i] is less than or equal to pivot
            while (i <= high && a[i] <= pivot)
                i++;
            // Move j to the left as long as a[j] is greater than pivot
            while (a[j] > pivot && j > low)
                j--;

            // Swap elements if i < j
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // Swap the pivot element into its correct position
        int temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;  // Return the index of the pivot
    }
}

