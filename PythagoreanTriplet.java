package com.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {

  //  Given an array of integers, write a function that returns true if there is a triplet (a, b, c)
  // that satisfies a2 + b2 = c2.
  //
  //      Input:
  //      The first line contains 'T' denoting the number of testcases. Then follows description of
  // testcases.
  //      Each case begins with a single positive integer N denoting the size of array.
  //      The second line contains the N space separated positive integers denoting the elements of
  // array A.
  //
  //      Output:
  //      For each testcase, print "Yes" or  "No" whtether it is Pythagorean Triplet or not.
  //
  //      Constraints:
  //      1<=T<=50
  //       1<=N<=100
  //       1<=A[i]<=100
  //
  //      Example:
  //      Input:
  //      1
  //      5
  //      3 2 4 6 5
  //      Output:
  //      Yes
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      System.out.println(isPythagoreanTriplet(arr, n));
    }
  }

  private static String isPythagoreanTriplet(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] * arr[i];
    }
    Arrays.sort(arr);
    for (int i = n - 1; i >= 2; i--) {
      int low = 0;
      int high = i - 1;
      while (low < high) {
        if (arr[low] + arr[high] == arr[i]) return "YES";
        else if (arr[low] + arr[high] > arr[i]) high--;
        else low++;
      }
    }
    return "NO";
  }
}
