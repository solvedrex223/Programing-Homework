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

	public E first () {
		return this.head.getData();
	}

	public E last ()
	{
		return this.tail.getData();
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
		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException ("El indice no esta dentro del rango de la lista");
		}
		else {
			Node <E> next = head;
			for (int i = 0; i < pos; i++) {
				if (i != pos -1) {
					next = next.next();
				}
				else {
					Node <E> nvo = new Node <> (data,next.next());
					next.setNext(nvo);
				}
			}
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
		System.out.println(tmp);
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
			}
			tmp = tmp + "," + current.getData();
			current = current.next();
		}
		return tmp;
	}
	
	public E removeAt(int x) {
		
	}
	public E getAt (int x) {
		
	}

	public static void main(String[] args) {
		MyLinkedList <Integer> lista = new MyLinkedList<>();
		for (int i = 0;i < 10; i++) {
			lista.insertAtFirst(i*5);
		}
		System.out.println(lista.toString());
		lista.removeFirst();
		lista.removeLast();
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
