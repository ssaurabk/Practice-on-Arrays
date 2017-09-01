package com.practice.array;

import java.util.Scanner;

public class ReverseArrayInGroups {

  //  Given an array, reverse every sub-array formed by consecutive k elements.
  //
  // Input:
  //
  // The first line of input contains a single integer T denoting the number of test cases. Then T
  // test cases follow. Each test case consist of two lines. The first line of each test case
  // consists of an integer N, where N is the size of array.The second line of each test case
  // contains N space separated integers denoting array elements.The third line of each test case
  // consists of an integer K.
  //
  // Output:
  // Corresponding to each test case, in a new line, print the modified array.
  //
  // Constraints:
  //
  // 1 ≤ T ≤ 100
  // 1 ≤ N ≤ 500
  // 1 ≤ A[i] ≤ 500
  //
  // Example:
  //
  // Input
  // 1
  // 5
  // 1 2 3 4 5
  // 3
  //
  // Output
  // 3 2 1 5 4
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      int k = in.nextInt();
      printreversedArray(arr, k);
    }
  }

  private static void printreversedArray(int[] arr, int k) {
    if (k > arr.length) return;
    int i = 0;
    int j;
    while (i < arr.length) {
      j = (i + k) > arr.length ? arr.length - 1 : i + k - 1;
      int last = j + 1;
      while (i < j) {
        swap(arr, i, j);
        i++;
        j--;
      }
      i = last;
    }
    display(arr);
  }

  private static void display(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
