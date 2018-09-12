package Examen1;

public class Main {
	
	public static void main(String[] args) {
	
		Integer [] arr = {6,7,1,3,4,9,5,49,8,16};
		Sorts srt = new Sorts ();
		srt.quickSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
