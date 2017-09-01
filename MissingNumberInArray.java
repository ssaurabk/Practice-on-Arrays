package com.practice.array;

import java.util.Scanner;

public class MissingNumberInArray {

  /** @param args */
  //  public static void main(String[] args) {
  //    Scanner in = new Scanner(System.in);
  //    int testcases = in.nextInt();
  //    while (testcases-- > 0) {
  //      int n = in.nextInt();
  //      int[] arr = new int[n];
  //      for (int i = 0; i < n - 1; i++) arr[i] = in.nextInt();
  //      System.out.println(getMissingNumber(arr, n));
  //    }
  //  }
  public static void main(String[] args) {
    int n = 5;
    int[] arr = {1, 2, 4, 5};
    System.out.println(getMissingNumber(arr, n));
  }

  private static int getMissingNumber(int[] arr, int n) {
    int xorArray = arr[0];
    for (int i = 1; i < n-1; i++) xorArray = xorArray ^ arr[i];
    int xorAll = 1;
    for (int i = 2; i <= n; i++) xorAll = xorAll ^ i;
    return xorAll ^ xorArray;
  }
}
