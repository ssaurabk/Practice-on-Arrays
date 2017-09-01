package com.practice.array;

import java.util.Scanner;

public class EquilibrumPoint {

  /** @param args */
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      System.out.println(getEqulibrumPoint(arr, n));
    }
  }

  private static int getEqulibrumPoint(int[] arr, int n) {
    int sum = 0;
    int lsum = 0;
    for (int num : arr) sum = sum + num;
    for (int i = 0; i < n; i++) {
      sum = sum - arr[i];
      if (lsum == sum) return i + 1;
      lsum = lsum + arr[i];
    }
    return -1;
  }
}
