package com.example.project01;

public class CountingSortSteps {
	public String CountingSort(int a[]) {

		if (a.length == 1) {
	
			return ("Step1\n" + printArray(a) + "," + printArray(a));

		} else {
			int max = a[0], min = a[0];
			
			String tmp = " ";
			for (int i = 1; i < a.length; i++) {
				if (a[i] > max) {
					max = a[i];
					
				} else if (a[i] < min) {
					min = a[i];
					
				}
			}
			int numValues = max - min + 1;

			int[] counts = new int[numValues];
			tmp += "Step 1: Index elements in array";
			for (int i = 0; i < a.length; i++) {
				
				counts[a[i] - min]++;
			
				tmp += "\nElement " + (a[i] - min) + " Index " + (i + 1);
			}
			tmp += "\n\nStep2: Count terms matched of each number";
			for (int i = 0; i < numValues; i++) {
				
				if (counts[i] != 0)

					tmp += " \nElement " + (i + min) + " appears " + counts[i];
			}

			tmp += " \nSorted array: \n";
			for (int i = 0; i < numValues; i++) {
				
				for (int j = 0; j < counts[i]; j++) {
					
					if (counts[i] != 0)
						tmp += (i + min) + " ";
				}
			}

			return tmp;
		}
	}


	public String printArray(int[] arr) {

		String tmp = "(";
		for (int i = 0; i < arr.length; i++) {
			tmp = tmp + " " + arr[i];
		}
		return tmp + ")";
	}
}
