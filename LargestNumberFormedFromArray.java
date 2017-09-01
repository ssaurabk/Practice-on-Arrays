package com.practice.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumberFormedFromArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		while (testcases-- > 0) {
			int n = in.nextInt();
			Integer[] arr = new Integer[n];
			String[] stringArray = new String[n];
			for (int i = 0; i < n; i++){
				arr[i] = in.nextInt();
				stringArray[i] = arr[i]+"";
			}
			System.out.println(getLargestNumber(stringArray));
		}

	}

	private static String getLargestNumber(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String i1 = o1 + o2;
				String i2 = o2 + o1;
				return i2.compareTo(i1);
			}
		});
		StringBuffer buffer = new StringBuffer();
		for(String num: arr){
			buffer.append(num);
		}
		return buffer.toString();
	}

}
