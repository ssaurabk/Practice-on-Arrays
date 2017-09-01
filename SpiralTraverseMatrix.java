package com.practice.array;

import java.util.Scanner;

public class SpiralTraverseMatrix {

  //  Input:
  //    1
  //    1 2 3 4
  //    5 6 7 8
  //    9 10 11 12
  //    13 14 15 16
  //    Output:
  //    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    int m;
    int n;
    while (testcases-- > 0) {
            n = in.nextInt();
            m = in.nextInt();

      int[][] matrix = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          matrix[i][j] = in.nextInt();
        }
      }
      printSpiral(matrix);
    }
  }

  private static void printSpiral(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int i = 0;
    int j = 0;
    while (i < n && j < m) {
      for (int k = i; k < n; k++) {
        System.out.print(matrix[j][k] + " ");
      }
      j++;
      for (int k = j; k < m; k++) {
        System.out.print(matrix[k][n - 1] + " ");
      }
      n--;
      for (int k = n - 1; k >= i; k--) {
        System.out.print(matrix[m - 1][k] + " ");
      }
      m--;
      for (int k = m - 1; k >= j; k--) {
        System.out.print(matrix[k][i] + " ");
      }
      i++;
    }
    System.out.println(); 
  }
}
