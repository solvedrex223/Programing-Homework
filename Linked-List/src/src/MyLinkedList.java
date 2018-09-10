// Javeier Emiliano Escobedo Padilla
// A01350928
// Grupo 1
// Estructura de Datos
// 10/09/2018
package src;

import java.util.NoSuchElementException;

public class MyLinkedList <E>{
	private Node<E> head,
	tail;
	private int size;

	public MyLinkedList () {
		this.head = this.tail = null;
		this.size = 0;
	}
	//Tarea: convertir arreglo a linkedlist
	public MyLinkedList (E[]elements) {
		Node <E> next = new Node <> (null);
		size = elements.length;
		for (int i = 0; i < size;i++) {
			if (i == 0) {
				Node <E> nvo = new Node<> (elements [i]);
				head = nvo;
				next = nvo;
			}
			else if (i == elements.length -1) {
				Node <E> nvo = new Node <> (elements [i]);
				tail = nvo;
			}
			else {
				Node <E> nvo = new Node <> (elements[i],next);
				next.setNext(nvo);
				next = nvo;
			}
		}
	}

	public E first () throws NoSuchElementException {
		try {
		return this.head.getData();
		}
		catch (NullPointerException ex) {
			throw new NoSuchElementException("No se puede regresar el primer elemento de una lista vacia");
		}
	}

	public E last () throws NoSuchElementException {
		try {
			return this.tail.getData();
			}
			catch (NullPointerException ex) {
				throw new NoSuchElementException("No se puede regresar el ultimo elemento de una lista vacia");
			}
	}
	
	public int size () {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void insertAtFirst (E data) {
		Node<E> nvo = new Node<> (data,head);
		this.head = nvo;
		if (this.size == 0) {
			this.tail = nvo;
		}
		this.size++;

	}

	public void addLast (E data) {
		if (this.size != 0) {
			Node<E> nvo = new Node<> (data,null);
			this.tail.setNext(nvo);
			this.tail = nvo;
			this.size++;
		}
		else {
			this.insertAtFirst(data);
		}
	}

	//Tarea
	public void insertAt (E data, int pos) throws IndexOutOfBoundsException { //Si pos < 0 o mayor a size
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException ("El indice no esta dentro del rango de la lista");
		}
		else if (pos == 0){
			this.insertAtFirst(data);
		}
		else if (pos == size-1){
			this.addLast(data);
		}
		else {
			Node <E> pre = head;
			for (int i = 0; i < pos-1; i++) {
				pre = pre.next();
			}
			Node <E> tmp = new Node <> (data,pre.next());
			pre.setNext(tmp);
			size++;		
		}
	}
	
	
	public E removeFirst () throws NoSuchElementException {
		try {
		E tmp = this.head.getData();
		this.head = this.head.next();
		if (this.size == 1) {
			this.tail= null;
		}
		this.size--;
		return tmp;
		}
		catch (NullPointerException ex) {
			throw new NoSuchElementException ("You can´t remove the first element of an empty list");
		}
	}
	
	public E removeLast ()  throws NoSuchElementException{
		try{
			E tmp = this.tail.getData();
			Node <E> next = head;
			while (next.next() != this.tail) {
				next = next.next();
			}
			this.tail = next;
			this.tail.setNext(null);
			if (this.size == 1) {
				this.head= null;
			}
			this.size--;
			System.out.println(tmp.toString());
			return tmp;
		}
		catch (NullPointerException ex) {
			throw new NoSuchElementException("You can´t remove the last element of an empty list");
		}
	}
	
	public String toString() {
		String tmp = "";
		Node <E> current = this.head;
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				tmp = tmp + current.getData();
				current = current.next();
			}
			else {
				tmp = tmp + "," + current.getData();
				current = current.next();
			}
		}
		return tmp;
	}
	
	public E removeAt(int x) {
		if (x < 0 || x >= size) {
			throw new IndexOutOfBoundsException ("El indice no esta dentro del rango de la lista");
		}
		else {
			Node <E> tmp = this.head;
			if (x == 0){
				tmp = tmp.next();
				E data = head.getData();
				this.head.setNext(null);
				this.head = tmp;
				size--;	
				return data;
			}
			else if (x == size-1){
				for (int i = 0;i < x - 1; i++){
					tmp = tmp.next();
				}
				E data = tail.getData();
				tail.setNext(null);
				tail = tmp;
				size--;	
				return data;
			}
			else {
				for (int i = 0;i < x - 1; i++){
					tmp = tmp.next();
				}
				Node <E> tmp2 = tmp.next();
				tmp.setNext(tmp2.next());
				tmp2.setNext(null);
				size--;	
				return tmp2.getData();
			}
		}
	}
	public E getAt (int x) {
		if (x < 0 || x >= size) {
			throw new IndexOutOfBoundsException ("El indice no esta dentro del rango de la lista");
		}
		else if (x == 0){
			return this.head.getData();
		}
		else if (x == size-1){
			return this.tail.getData();
		}
		else {
			Node <E> tmp = this.head;
			for (int i = 0;i <= x - 1; i++){
				tmp = tmp.next();
			}
			return tmp.getData();
		}
	}
	public void setAt (E data, int x) {
		if (x < 0 || x >= size) {
			throw new IndexOutOfBoundsException ("El indice no esta dentro del rango de la lista");
		}
		else if (x == 0){
			this.head.setData(data);
		}
		else if (x == size-1){
			this.tail.setData(data);
		}
		else {
			Node <E> tmp = this.head;
			for (int i = 0;i <= x - 1; i++){
				tmp = tmp.next();
			}
			tmp.setData(data);
		}
	}


	public static void main(String[] args) {
		MyLinkedList <Integer> lista = new MyLinkedList<>();
		for (int i = 0;i < 10; i++) {
			lista.insertAtFirst(i*5);
		}
		System.out.println(lista.toString());
		System.out.println(lista.removeAt(3));
		System.out.println(lista.getAt(1));
		lista.setAt(9,1);
		System.out.println(lista.getAt(1));
		System.out.println(lista.toString());
	}
}

class Node <E>{

	private E data;
	private Node<E> ref;


	public E getData() {
		return data;
	}


	public void setData(E data) {
		this.data = data;
	}


	public Node<E> next() {
		return ref;
	}


	public void setNext(Node<E> ref) {
		this.ref = ref;
	}


	public Node(E data, Node<E> ref) {
		this.data = data;
		this.ref = ref;
	}


	public Node(E data) {
		this(data,null);
	}
	public String toString () {
		return this.getData().toString();
	}
}
