package com.practice.array;

import java.util.Scanner;

public class ConvertArrayInZigZagFashion {
  //
  //  Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in
  // O(n) time. The converted array should be in form a < b > c < d > e < f.The relative order of
  // elements is same in the output i.e you have to iterate on the original array only.
  //
  //  Input:
  //  The first line of input contains an integer T denoting the number of test cases. The
  // description of T test cases follows.
  //  The first line of each test case contains a single integer N denoting the size of array.
  //  The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of
  // the array.
  //
  //  Output:
  //  Print the array in Zig-Zag fashion.
  //
  //  Constraints:
  //  1 ≤ T ≤ 100
  //  1 ≤ N ≤ 100
  //  0 ≤A[i]<=10000
  //
  //  Example:
  //  Input:
  //  2
  //  7
  //  4 3 7 8 6 2 1
  //  4
  //  1 4 3 2
  //  Output:
  //  3 7 4 8 2 6 1
  //  1 4 2 3
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      printZigZagArray(arr);
    }
  }

  private static void printZigZagArray(int[] arr) {
    boolean flag = true;
    for (int i = 0; i < arr.length - 1; i++) {
      if (flag) {
        if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);
      } else {
        if (arr[i] < arr[i + 1]) swap(arr, i, i + 1);
      }
      flag = !flag;
    }
    display(arr);
  }

  private static void display(int[] arr) {
    for (int num : arr) System.out.print(num + " ");
    System.out.println();
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
