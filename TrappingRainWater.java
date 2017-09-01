package com.practice.array;

public class TrappingRainWater {

	// Given n non-negative integers in array representing an elevation map
	// where the width of each
	// bar is 1, compute how much water it is able to trap after raining.
	// For example:
	// Input:
	// 3
	// 2 0 2
	// Output:
	// 2
	// Structure is like below
	// | |
	// |_|
	// We can trap 2 units of water in the middle gap.
	//
	// Below is another example.
	//
	//
	//
	// Input:
	// The first line of input contains an integer T denoting the number of test
	// cases. The
	// description of T test cases follows.
	// Each test case contains an integer N followed by N numbers to be stored
	// in array.
	//
	// Output:
	// Print trap units of water in the middle gap.
	//
	// Constraints:
	// 1<=T<=100
	// 3<=N<=100
	// 0<=Arr[i]<10
	//
	// Example:
	// Input:
	// 2
	// 4
	// 7 4 0 9
	// 3
	// 6 9 9
	//
	// Output:
	// 10
	// 0
	public static void main(String[] args) {
		// TODO(saukumar): Auto-generated method stub
		int arr[] = {6, 9, 9};
		int n = arr.length;
		int water1 = getWaterInThreetraversels(arr, n);
		int water2 = getWaterInOneTraversel(arr, n);
		System.out.println(water1);
		System.out.println(water2);
		if (water1 != water2)
			System.out.println("ERROR");
	}

	private static int getWaterInOneTraversel(int[] arr, int n) {
		int water = 0;
		int leftMax = 0;
		int rightMax = 0;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			if (arr[low] < arr[high]) {
				if (arr[low] > leftMax)
					leftMax = arr[low];
				else
					water = water + (leftMax - arr[low]);
				low++;
			} else {
				if (arr[high] > rightMax)
					rightMax = arr[high];
				else
					water = water + (rightMax - arr[high]);
				high--;
			}
		}
		return water;
	}

	private static int getWaterInThreetraversels(int[] arr, int n) {
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = arr[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}
		int water = 0;
		for (int i = 0; i < n; i++) {
			water = water + Math.min(left[i], right[i]) - arr[i];
		}

		return water;
	}

	/**
	 * @param array
	 * @return
	 */
	private static String display(int[] array) {
		String s = "";
		for (int a : array)
			s = s + " " + a;
		return s;
	}
}
