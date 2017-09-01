package com.practice.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortingElementsByFrequency {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		while (testcases-- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			printArraySortedByFrequency(arr);
		}

	}

	private static void printArraySortedByFrequency(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Pair> set = new TreeSet<Pair>();
		for (int num : arr) {
			if (map.get(num) == null)
				map.put(num, 1);
			else {
				int f = map.get(num);
				map.put(num, f + 1);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			set.add(new Pair(entry.getKey(), entry.getValue()));
		}
		int i = 0;
		for (Pair pair : set) {
			int f = pair.frequency;

			while (f-- > 0) {
				arr[i] = pair.number;
				i++;

			}
		}
		display(arr);

	}

	private static void display(int[] arr) {
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}

}
class Pair implements Comparable<Pair> {
	int number;
	int frequency;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}
	public Pair(int number, int frequency) {
		super();
		this.number = number;
		this.frequency = frequency;
	}
	@Override
	public boolean equals(Object obj) {
		Pair pair = (Pair) obj;
		return this.number == pair.number;
	}
	@Override
	public int compareTo(Pair o) {
		if (this.frequency == o.frequency)
			return this.number - o.number;
		return o.frequency - this.frequency;
	}

}
