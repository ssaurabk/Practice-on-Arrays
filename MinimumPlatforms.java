package com.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumPlatforms {

  //  Given arrival and departure times of all trains that reach a railway station, find the minimum
  // number of platforms required for the railway station so that no train waits.
  //
  //  Input:
  //
  //  First line will contain a number T, the number of test cases.
  //  Each test case will contain a number N, the number of trains.
  //  Next two lines will consist of N space separated time intervals denoting arrival and departure
  // times respectively.
  //  NOTE: Time intervals are in 24 hour format(hhmm),preceding zeros are insignificant.
  //  Consider the example for better understanding of input.
  //
  //  Output:
  //
  //  Print the required answer in separated line.
  //
  //  Constraints:
  //
  //  1<=T<=80
  //  1<=N<=5000
  //
  //  1<=A[i]<=5000
  //
  //  Example:
  //
  //  INPUT:
  //
  //  1
  //  6
  //  900  940 950  1100 1500 1800
  //  910 1200 1120 1130 1900 2000
  //
  //  OUTPUT:
  //
  //  3
  //
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testcases = in.nextInt();
    while (testcases-- > 0) {
      int n = in.nextInt();
      int[] arrival = new int[n];
      int[] departure = new int[n];
      for (int i = 0; i < n; i++) arrival[i] = in.nextInt();
      for (int i = 0; i < n; i++) departure[i] = in.nextInt();
      List<TrainTime> list = new ArrayList<TrainTime>();
      for (int i = 0; i < n; i++) {
        list.add(new TrainTime(arrival[i], departure[i]));
      }
      Collections.sort(list);
      System.out.println(getNumberOfPlatforms(list));
    }
  }

  private static int getNumberOfPlatforms(List<TrainTime> list) {
    int numPlatforms = 1;
    int maxNumPlatforms = 1;
    int j = 0;
    for (int i = 0; i < list.size(); i++) {
      j = i + 1;
      while (j < list.size() && list.get(i).getDepartureTime() > list.get(j).getArrivalTime()) {
        j++;
      }
      numPlatforms = j - i;
      if (numPlatforms > maxNumPlatforms) maxNumPlatforms = numPlatforms;
    }
    return maxNumPlatforms;
  }
}

class TrainTime implements Comparable<TrainTime> {
  private int arrivalTime;
  private int departureTime;

  public TrainTime(int arrivalTime, int departureTime) {
    super();
    this.arrivalTime = arrivalTime;
    this.departureTime = departureTime;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public int getDepartureTime() {
    return departureTime;
  }

  @Override
  public int compareTo(TrainTime trainTime) {
    return this.getArrivalTime() - trainTime.getArrivalTime();
  }

  @Override
  public String toString() {
    return "TrainTime [arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
  }
}
