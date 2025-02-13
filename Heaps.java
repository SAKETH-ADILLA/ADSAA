import java.util.*;
import java.lang.*;
public class Heaps {
	public static boolean insert(int [] a, int n){
		int i=n;
		int item=a[n];
		//int root=Math.floorDiv(i,2);
		while(i>1 && item>a[Math.floorDiv(i,2)]){
			a[i]=a[Math.floorDiv(i,2)];
			i=Math.floorDiv(i,2);
		}
		a[i]=item;
		return true;
	}
	public static int delMax(int a [],int i, int n){
		int x;
		if( n==0){
			System.out.println("Heap is empty");
			return -1;
		}
		x=a[1];
		a[i]=a[n];
		adjust(a,1,n-1);
		return x;
	}
	
	public static void adjust( int []a ,int i, int n){
		int j=2*i;
		int item=a[i];
		while(j<=n){
			if(j<n && (a[j] < a[j+1])) 
				j=j+1;
			if(item>=a[j])
				break;
			a[Math.floorDiv(j,2)]=a[j];
			j=2*j;
		}
		a[Math.floorDiv(j,2)] =item;
	}
	
	public static void sort(int a[] ,int n){
		
		for(int i=n;i>0;i--){
			int x=delMax(a,1,i);
			a[i]=x;
		}
	}
	
	public static void heapify(int a[], int n){
		for(int i=Math.floorDiv(n,2);i>=1;i--){
			adjust(a,i,n);
		}
	}
			
	public static void heapSort(int a[],int n){
		heapify(a,n);
		for(int i=n;i>1;i--){
			int temp=a[i];
			a[i]=a[1];
			a[1]=temp;
			adjust(a,1,i-1);
		}
	}
	
	public static void main(String [] args) {
		int []a ={0,12,21,134,14,55,34,18};

		for(int i=1;i<a.length;i++)
			insert(a,i);
			
		for(int i=1;i<a.length;i++)
			System.out.print(a[i] + " ");
			
		int del=delMax(a,1,a.length-1);
		System.out.println();
		System.out.println("deleted element is: " + del);
		System.out.println();
		System.out.print("After deletion heap is :");
		for(int i=1;i<a.length-1;i++)
			System.out.print(a[i] + " ");
		
		System.out.print("\nSORTED HEAPS:");
		sort(a,a.length-2);
		for(int i=1;i<a.length-1;i++)
			System.out.print(a[i] + " ");

		
		System.out.println();
		System.out.print("Heap sort using heapify :");
		heapSort(a,a.length-2);
		for(int i=1;i<a.length-1;i++)
			System.out.print(a[i] + " ");
		
	}	
}
