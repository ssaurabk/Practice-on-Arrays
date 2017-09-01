package com.practice.array;

import java.util.Scanner;

public class FindSingleElementInSortedArray {

  // Given a sorted array of integers, every element appears twice except for one. Find that single
  // one in linear time complexity and without using extra memory.
  //
  // Input:
  // The first line of input consists number of the test cases. The description of T test cases is
  // as follows:
  // The first line of each test case contains the size of the array, and the second line has the
  // elements of the array.

  // Output:
  // In each separate line print the number that appears only once in the array.
  //
  // Constraints:
  // 1 ≤ T ≤ 70
  // 1 ≤ N ≤ 100
  // 0 ≤ A[i] ≤ 100000
  //
  // Example:
  //
  // Input:
  //
  // 1
  // 11
  // 1 1 2 2 3 3 4 50 50 65 65
  //
  // Output:
  //
  // 4
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      printSingleOccuringElement(arr);
    }
  }

  private static void printSingleOccuringElement(int[] arr) {
    boolean found = false;
    if (arr.length % 2 == 0) {
      System.out.println("All elements occur Twice");
      return;
    }
    for (int i = 0; i < arr.length - 1; i = i + 2) {
      if (arr[i] != arr[i + 1]) {
        System.out.print(arr[i]);
        found = true;
        break;
      }
    }
    if (!found) System.out.print(arr[arr.length - 1]);
    System.out.println();
  }
}
