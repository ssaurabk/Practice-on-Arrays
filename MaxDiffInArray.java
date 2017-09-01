package com.practice.array;

import java.util.Scanner;

public class MaxDiffInArray {

  /** @param args */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      printMaxDiff(arr);
    }
  }

  private static void printMaxDiff(int[] arr) {
    int maxDiff = arr[1] - arr[0];
    int min = arr[0];
    int buyDay = 0;
    int sellDay = 0;
    for (int i = 1; i < arr.length; i++) {
      if (maxDiff < arr[i] - min) {
        maxDiff = arr[i] - min;
        sellDay = i;
      } else if (arr[i] < min) {
        min = arr[i];
        buyDay = i;
      }
    }
//    System.out.println(maxDiff);
    System.out.println(buyDay + " " + sellDay);
  }
}
