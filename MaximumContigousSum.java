package com.practice.array;

import java.util.Scanner;

public class MaximumContigousSum {

  /** @param args */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      System.out.println(getContinousSum(arr));
    }
  }

  /**
   * @param arr
   * @return
   */
  private static int getContinousSum(int[] arr) {
    int sumTillNow = 0;
    int maxSumTillNow = 0;
    for (int num : arr) {
      sumTillNow = sumTillNow + num;
      if (sumTillNow > maxSumTillNow) maxSumTillNow = sumTillNow;
      if (sumTillNow < 0) sumTillNow = 0;
    }
    // All number are negative the choose the max
    if (maxSumTillNow == 0) {
      return max(arr);
    }
    return maxSumTillNow;
  }

  private static int max(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) if (max < arr[i]) max = arr[i];
    return max;
  }
}
