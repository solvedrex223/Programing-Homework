//A01350928
//Javier Emiliano Escobedo Padilla
//05/09/2018
//Estructura de Datos Grupo 1
package src;

public class MyLinkedList<E> {
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
		for (int i = 0; i < elements.length;i++) {
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
		return (E) this.head.getData();
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
	
	public static void main(String[] args) {
		
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
	
	
}
