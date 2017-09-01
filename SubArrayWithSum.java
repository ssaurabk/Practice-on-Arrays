package com.practice.array;

import java.util.Scanner;

public class SubArrayWithSum {
	// Input:
	// 2
	// 5 12
	// 1 2 3 7 5
	// 10 15
	// 1 2 3 4 5 6 7 8 9 10
	//
	// Output:
	// 2 4
	// 1 5
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcases = scanner.nextInt();
		while (testcases-- > 0) {
			int n = scanner.nextInt();
			int sum = scanner.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scanner.nextInt();
			findSubarrayWithSum(arr, sum);
		}

	}

	private static void findSubarrayWithSum(int[] arr, int sum) {
		int currSum = arr[0];
		int start = 0;
		for (int i = 1; i < arr.length; i++) {
			int num = arr[i];
			currSum = currSum + num;
			while (currSum > sum) {
				currSum = currSum - arr[start];
				start++;
			}
			if (currSum == sum) {
				int j = i + 1;
				System.out.println(start + 1 + " " + j);
				return;
			}
		}
		System.out.println("-1");

	}

}
