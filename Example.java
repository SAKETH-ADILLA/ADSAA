import java.util.*;
public class Example{
	public static void mergesort(int a[]){
		if(a.length < 2)
			return;
		int mid = a.length/2;
		int left[] = new int [mid];
		int right[] = new int[a.length - mid];
		for(int i =0; i< mid; i++)
			left[i] = a[i];
		for(int i = mid; i< a.length; i++)
			right[i - mid] = a[i];
		mergesort(left);
		mergesort(right);
		merge(a, left, right);
	}
	public static void merge(int a[], int left[], int right[]){
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length){
			if(left[i] <= right[j])
				a[k] = left[i++];
			else 
				a[k] = right[j++];
			k++;
		}
		while(i < left.length)
			a[k++] = left[i++];
		while(j < right.length)
			a[k++] = right[j++];
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Size of the Array: ");
		int n = in. nextInt();  
		int a[] = new int[n];
		System.out.println("Enter Elements: ");
		for(int i = 0; i < n; i++)
			a[i] = in.nextInt();
		long start = System.nanoTime();
		mergesort(a);
		long end = System.nanoTime();
		for(int i =0; i < n; i++)
			System.out.println(a[i] + " ");
		System.out.println( "Totoal Time Taken : " + (end - start) +"ns");
	}
}
