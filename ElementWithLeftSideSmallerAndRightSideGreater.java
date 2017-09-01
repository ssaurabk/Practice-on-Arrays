package com.practice.array;

import java.util.Scanner;

public class ElementWithLeftSideSmallerAndRightSideGreater {
  //  Given an unsorted array of size N. Find the first element in array such that all of its left
  // elements are smaller and all right elements to it are greater than it.
  //
  //  Note: Left and right side elements can be equal to required element. And extreme elements
  // cannot be required element.
  //
  //  Input:
  //  The first line of input contains an integer T denoting the number of test cases. Then T test
  // cases follow. Each test case consists of two lines. First line of each test case contains an
  // Integer N denoting size of array and the second line contains N space separated array elements.
  //
  //  Output:
  //  For each test case, in a new line print the required element. If no such element present in
  // array then print -1.
  //
  //  Constraints:
  //  1<=T<=100
  //  3<=N<=106
  //  1<=A[i]<=106
  //
  //  Example:
  //  Input:
  //  3
  //  4
  //  4 2 5 7
  //  3
  //  11 9 12
  //  6
  //  4 3 2 7 8 9
  //
  //  Output:
  //  5
  //  -1
  //  7
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      System.out.println(getRequiredElement(arr));
    }
  }

  private static int getRequiredElement(int[] arr) {
    int[] leftMax = new int[arr.length];
    leftMax[0] = arr[0];
    int rightMin = arr[arr.length - 1];
    int reqElement = -1;
    for (int i = 1; i < arr.length; i++)
      leftMax[i] = leftMax[i - 1] > arr[i - 1] ? leftMax[i - 1] : arr[i - 1];
    for (int i = arr.length - 2; i > 0; i--) {
      if (leftMax[i] < arr[i] && rightMin > arr[i]) {
        reqElement= arr[i];
      }
      rightMin = rightMin > arr[i] ? arr[i] : rightMin;
    }
    return reqElement;
  }
}
