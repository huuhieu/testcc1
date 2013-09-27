package com.example.project01;

public class MergeSortSteps {
	private String str = "";
	private String result_str ="";
	private int step = 0;
	
	private void  mergeSort(int[] a, int x, int y) {
		if (x < y) {
			int z = (x + y) / 2;
			mergeSort(a, x, z);
			mergeSort(a, z + 1, y);
			merge(a, x, z, y);
		}		
		//return str;
	}
	
	public String mergeResult(int[] numbers) {
		String temp;
		mergeSort(numbers, 0, numbers.length - 1);
		for (int i = 0; i < numbers.length; i++) {
			result_str += Integer.toString(numbers[i]);
			result_str += " ";
		}
		temp = str + "Result: " + result_str;
		return (temp);
	}

	private void merge(int[] A, int a, int c, int b) {
		int i = a;
		int j = c + 1;
		int k = 0;
		int n = b - a + 1;
		int[] B = new int[n];

		step++;
		str += "Step " + Integer.toString(step) + ":\n( ";
		for (int index = a; index < c + 1; index++) {
			str += Integer.toString(A[index]);
			str += " ";
		}
		str += ") + ( ";
		for (int index = c + 1; index <= b; index++) {
			str += Integer.toString(A[index]);
			str += " ";
		}
		str += ")\n";

		while ((i < c + 1) && (j < b + 1))
			if (A[i] < A[j])
				B[k++] = A[i++];
			else
				B[k++] = A[j++];

		while (i < c + 1)
			B[k++] = A[i++];

		while (j < b + 1)
			B[k++] = A[j++];
		i = a;

		for (k = 0; k < n; k++)
			A[i++] = B[k];

		for (int index = a; index <= b; index++) {
			str += Integer.toString(A[index]);
			str += " ";
		}
		str += "\n\n";
	}
}
