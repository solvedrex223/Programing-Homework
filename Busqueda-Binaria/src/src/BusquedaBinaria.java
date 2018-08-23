package src;
import java.util.Arrays;

// A01350928
// Javier Emiliano Escobedo Padilla
// Estructura de Datos
// 23/08/2018

public class BusquedaBinaria <E>{
	
	public static <E extends Comparable<E>> int binarySearchRec(E[] valores,E valor) {
		Arrays.sort(valores);
		int max = valores.length - 1;
		return binarySearchRec(valores,valor,0,max);
	}

	private static <E extends Comparable<E>> int binarySearchRec(E[] valores,E valor,int min,int max) {
		int n = (max + min) / 2;
		if (valores [n].equals(valor)) {
			return n;
		}
		else if (min >= max) {
			return -1;
		}
		else if(valores[n].compareTo(valor) > 0) { 
			return binarySearchRec(valores, valor, min, n - 1);
		}
		else  {
			return binarySearchRec(valores, valor, n + 1, max);
		}
		
	}
	public static void main(String[] args) {
		Integer [] valores = {20,50,60,30};
		int res = binarySearchRec(valores,65);
		if (res != -1) {
			System.out.println(res);
		}
		else {
			System.out.println("El valor no se encontro");
		}
	}
}


