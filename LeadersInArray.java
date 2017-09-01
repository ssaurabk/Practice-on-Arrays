package com.practice.array;

import java.util.Scanner;
import java.util.Stack;

public class LeadersInArray {

  // Write a program to print all the LEADERS in the array. An element is leader if it is greater
  // than all the elements to its right side. The rightmost element is always a leader.
  //  Input:
  //    2
  //    6
  //    16 17 4 3 5 2
  //    5
  //    1 2 3 4 0
  //    Output:
  //    17 5 2
  //    4 0

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = in.nextInt();
      printLeaders(arr);
    }
  }

  private static void printLeaders(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int max = -1;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] > max) {
        max = arr[i];
        stack.push(max);
      }
    }
    while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    System.out.println();
  }
}
