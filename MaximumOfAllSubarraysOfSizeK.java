package com.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MaximumOfAllSubarraysOfSizeK {
  private static int comp = 0;
  //  Given an array and an integer k, find the maximum for each and every contiguous subarray of
  // size k.
  //
  //  Input:
  //  The first line of input contains an integer T denoting the number of test cases. The
  // description of T test cases follows.
  //  The first line of each test case contains a single integer 'N' denoting the size of array and
  // the size of subarray 'k'.
  //  The second line contains 'N' space-separated integers A1, A2, ..., AN denoting the elements of
  // the array.
  //
  //  Output:
  //  Print the maximum for every subarray of size k.
  //
  //  Constraints:
  //  1 ≤ T ≤ 200
  //  1 ≤ N ≤ 100
  //  1 ≤ k ≤ N
  //  0 ≤A[i]<1000
  //
  //  Example:
  //
  //  Input:
  //  2
  //  9 3
  //  1 2 3 1 4 5 2 3 6
  //  10 4
  //  8 5 10 7 9 4 15 12 90 13
  //
  //  Output:
  //  3 3 4 5 5 5 6
  //  10 10 10 15 15 90 90
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      findMaximumOfAllSubarraysOfSizeK(arr, k);
      System.out.println("comp: " + comp);
    }
  }

//  private static void findMaximumOfAllSubarraysOfSizeK(int[] arr, int k) {
//    List<Integer> list = new ArrayList<Integer>();
//    for (int i = 0; i < k; i++) list.add(arr[i]);
//    Collections.sort(list);
//    System.out.print(list.get(list.size() - 1) + " ");
//    int i = 0;
//    while (k < arr.length) {
//      list.remove(new Integer(arr[i]));
//      i++;
//      list.add(arr[k]);
//      k++;
//      Collections.sort(list);
//      System.out.print(list.get(list.size() - 1) + " ");
//    }
//
//    System.out.println();
//  }

    private static void findMaximumOfAllSubarraysOfSizeK(int[] arr, int k) {
  
      if (k > arr.length) return;
      int max = findMax(arr, 0, k);
      System.out.print(max + " ");
      int i = 1;
      int j = k;
      while (j < arr.length) {
        if (max == arr[i - 1]) max = findMax(arr, i, j);
        if (max < arr[j]) max = arr[j];
        System.out.print(max + " ");
        i++;
        j++;
      }
      System.out.println();
    }
  
    private static int findMax(int[] arr, int low, int high) {
      int max = 0;
      for (int i = low; i < high; i++) {
        if (max < arr[i]) max = arr[i];
        comp++;
      }
      return max;
    }
}
