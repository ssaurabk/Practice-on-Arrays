package com.practice.array;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

  //  Input:
  //    2
  //    7
  //    1 101 2 3 100 4 5
  //    4
  //    10 5 4 3
  //
  //    Output:
  //    106
  //    10
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      System.out.println(getMaximumSumIncreasingSubsequence(arr));
    }
  }

  private static int getMaximumSumIncreasingSubsequence(int[] arr) {
    int n = arr.length;
    int[] msis = arr.clone();
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) msis[i] = msis[j] + arr[i];
      }
    }
    return max(msis);
  }

  private static int max(int[] msis) {
    int max = 0;
    for (int num : msis) if (num > max) max = num;
    return max;
  }
}
