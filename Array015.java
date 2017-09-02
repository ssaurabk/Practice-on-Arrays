package com.practice.array;
//Details: https://goo.gl/DLW4p4
public class Array015 {

	public static void main(String[] args) {
		int[] array = {5,5,5,5,1, 5, 0,0,0,0, 0,0, 1, 0};
		int lengthLongestContinousChar = getLongestContinousCharLength(array);
		System.out.println(lengthLongestContinousChar);
		System.out.println(getLongestContinousCharLength(array)==6);
		
	}

	private static int getLongestContinousCharLength(int[] array) {
		int count0 = 0;
		int count1 = 0;
		int maxCount1 = 0;
		int maxCount0 = 0;
		int i = 0;
		while (i < array.length) {
			if (array[i] == 0) {
				count0++;
				count1 = 0;
				if (count0 > maxCount0)
					maxCount0 = count0;
			} else if (array[i] == 1) {
				count1++;
				count0 = 0;
				if (count1 > maxCount1)
					maxCount1 = count1;

			} else {
				count0++;
				if (count0 > maxCount0)
					maxCount0 = count0;
				count1++;
				if (count1 > maxCount1)
					maxCount1 = count1;

			}
			i++;
		}
		return maxCount0 > maxCount1 ? maxCount0 : maxCount1;
	}

}
