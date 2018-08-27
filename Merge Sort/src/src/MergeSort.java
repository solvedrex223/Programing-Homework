package src;

public class MergeSort {

	static Integer [] x = {4,6,7,2,3,1};
	public static <E extends Comparable <E>> void mergeSort (E [] arr) {
		int max = arr.length;
	}
	
	public static <E extends Comparable <E>> void mergeSort (E [] arr, int first, int last) {
		if (first < last - 1) {
			int mid = (last + first) / 2;
			if ((last + first) % 2 == 1) {
				mid++;
			}
			mergeSort (arr,first, mid);
			mergeSort (arr,mid + 1, last);
		}
		mezcla (arr,first,last);
	}
	
	public static <E extends Comparable <E>> void mezcla (E [] arr, int first, int last) {
		@SuppressWarnings("unchecked")
		E [] temp = (E[]) new Comparable [last - first + 1];
		int mid = (last + first) / 2;
		if ((last + first) % 2 == 1) {
			mid++;
		}
		int j = first;
		int k = mid;
		for (int i = 0; i < last - first; i++) {	
			if (j == ((last+ first) / 2 + 1)) {
				temp [i] = arr [k];
				k ++;
			}
			else if (k == last + 1) {
				temp [i] = arr [j];
				j++;
			}
			
			else if (arr [j].compareTo(arr [k]) > 0) {
				temp [i] = arr [k];
				k ++;
			}
			else {
				temp [i] = arr [j];
				j ++;
			}
		}
		for (int i = 0; i < last - first; i++) {
			x [i] = (Integer) temp [i] ;
		}
	
	}
	
	public static void main(String[] args) {
		mergeSort (x,0,5);
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
}
