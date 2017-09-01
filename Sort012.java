package com.practice.array;

import java.util.Scanner;

public class Sort012 {
	// Input :
	//
	// 2
	// 5
	// 0 2 1 2 0
	// 3
	// 0 1 0
	//
	//
	// Output:
	//
	// 0 0 1 2 2
	// 0 0 1
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcases = scanner.nextInt();
		while (testcases-- > 0) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scanner.nextInt();
			display(getSortedArray(arr));
		}

	}

	private static void display(int[] arr) {
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

	}

	private static int[] getSortedArray(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;
		while (mid <= high) {
			switch (arr[mid]) {
				case 0 :
					arr = swap(arr, low, mid);
					low++;
					mid++;
					break;
				case 1 :
					mid++;
					break;
				case 2 :
					arr = swap(arr, mid, high);
					high--;
					break;
			}
		}
		return arr;
	}

	private static int[] swap(int[] arr, int low, int mid) {
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
		return arr;

	}

}
