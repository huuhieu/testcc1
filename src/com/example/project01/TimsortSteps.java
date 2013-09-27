package com.example.project01;

import java.util.Comparator;

public class TimsortSteps {
	public String Tim(int a[]) {
		String tmp;
		tmp = "Now's the time for showing step by step of Timsort\n";
		Integer[] newArr = new Integer[a.length];
		int j = 0;
		for (int value : a) {
			newArr[j++] = Integer.valueOf(value);
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		Timsort.sort(newArr, comparator);
		String steps = Timsort.stepsString.toString();
		tmp = tmp + steps;
		tmp = tmp + "\nSorted: ";
		for (int i = 0; i < newArr.length; i++) {
			tmp = tmp + " " + newArr[i];
		}
		tmp = tmp + "\n";
		return tmp;
	}
}