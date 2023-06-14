package sorters;

import java.util.Arrays;

public class DualPivotQuickSort {

	private int[] data;
	
	public int[] sort(int[] data) {
		this.data = Arrays.copyOfRange(data, 0, data.length);
		quicksort(0, data.length-1);
		return this.data;
	}
	
	private void quicksort(int left, int right) {

	}	

	private void swap(int i, int j) {

	}
	
	private int[] partition(int left, int right) {
	    int[] pivot = null;
	    
	    return pivot;
	}
}
