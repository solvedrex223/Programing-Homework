package Examen1;

import java.util.Random;

public class Sorts {

	//private Random r = new Random (System.currentTimeMillis());
	
	public  <E extends Comparable<E>> void bubbleSort (E [] arr){
		int cont = arr.length-1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < cont;j++) {
				if (arr[j].compareTo(arr[j+1]) > 0 ) {
					E temp = arr[j];
					E temp2 = arr[j+1];
					arr[j] = temp2;
					arr[j+1] = temp;
				}
			}
			cont--;
		}
	}
	
	public <E extends Comparable <E>> void quickSort (E [] arr) {
		this.quickSort(arr, 0, arr.length - 1);
	}
	
	public <E extends Comparable <E>> void quickSort (E [] arr, int low, int high) {
		if (low < high) {
			int pivote = this.partition (arr,low,high);
			this.quickSort(arr, pivote + 1, high);
			this.quickSort(arr,low,pivote - 1);
			
		}
	}
	
	private <E extends Comparable <E>> void swap (E [] arr, int i, int j) {
		E tmp4 = arr[i], 
		  tmp5 = arr[j];
		arr[i] = tmp5;
		arr[j] = tmp4;
	}
	
	public <E extends Comparable <E>> int partition (E [] arr, int low, int high) {
		//int pivote = r.nextInt(high - low) + low;
		this.swap(arr, low, high);
		E tmp = arr [low];
		int i = low + 1;
		/*if (pivote == low) {
			i = low + 1;
		}
		else {
			i = low;
		}
		*/
		//boolean ord = true;		
		for (int j = low + 1; j < high + 1; j++) {
			if (arr[j].compareTo(tmp) < 0) {
				this.swap(arr, i, j);
				i++;
				//ord = false;
			}
			/*else if (arr[i].compareTo(tmp) > 0) {
				j--;
			}
			else {
				i++;
			}
			*/
		}
		
		this.swap(arr, i - 1, low);
		return i - 1;
		
	}
	
	public <E extends Comparable <E>> void mergeSort (E [] arr) {
		int medio = arr.length / 2;
		this.mergeSort(arr, 0, medio);
		this.mergeSort(arr, medio + 1 , arr.length - 1);
	}
	
	public <E extends Comparable <E>> void mergeSort (E [] arr,int low, int high) {
		if (low < high) {
			int medio = (high - low) / 2;
			this.mergeSort(arr, low, medio);
			this.mergeSort(arr, medio + 1, high);
			this.merge(arr,low,medio,high);
		}
	}
	
	public <E extends Comparable <E>> void merge (E [] arr,int low,int medio, int high) {
		E [] left = new E [medio - low];
	}
}
