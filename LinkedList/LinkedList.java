package com.bridgelabz.LinkedList;

import com.practice.workshop.K;
import com.practice.workshop.Node;

public class LinkedList<K> {

	private Node<K> head;
	private Node<K> tail;

	public void add(K key) {
		Node<K> node = new Node<>(key);
		if (head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.setNext(head);
			head = node;
		}
	}

	public void print() {
		Node<K> n = head;
		while (!n.equals(tail)) {
			System.out.print(n.getData() + " -> ");
			n = n.getNext();
		}
		System.out.println(tail.getData());

	}

	public void append(K key) {
		Node<K> node = new Node<>(key);
		if (head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = node;
		}
	}

	public void insert(K key) {
		Node<K> node = new Node<>(key);
		node.setNext(tail);
		head.setNext(node);
	}

	public void insertAfter(K previousData, K data) {
		Node newNode = new Node(data);
		Node<K> tempNode = head;
		while (!tempNode.getData().equals(previousData)) {
			tempNode = tempNode.getNext();
		}
		newNode.setNext(tempNode.getNext());
		tempNode.setNext(newNode);
	}

	public K pop() {
		K deleteData = head.getData();
		this.head = head.getNext();
		return deleteData;
	}

	public K popLast() {
		Node tempNode = head;
		while (!(tempNode.getNext().equals(tail))) {
			tempNode = tempNode.getNext();
		}
		K deleteData = (K) tempNode.getNext().getData();
		this.tail = tempNode;
		return deleteData;
	}

	public Node<K> search(K searchData) {
		Node tempNode = head;
		while (!(tempNode.getData().equals(searchData))) {
			tempNode = tempNode.getNext();
		}
		return tempNode;
	}
	
	public void delete(K deleteData) {
		Node<K> tempNode = head;
		while (!tempNode.getData().equals(deleteData)) {
			tempNode = tempNode.getNext();
		}
		Node<K> previousNode = head;
		while (!previousNode.getNext().getData().equals(deleteData)) {
			previousNode = previousNode.getNext();
		}
		previousNode.setNext(tempNode.getNext());
	}


	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.add(70);
		linkedList.add(30);
		linkedList.add(56);

		System.out.println(linkedList.search(30).getData());
		
		linkedList.print();
		
		linkedList.insertAfter(30, 40);
		
		linkedList.print();
		
		linkedList.delete(40);

//		System.out.println(linkedList.popLast());

//		linkedList.append(56);
//		linkedList.append(30);
//		linkedList.append(70);

//		System.out.println(linkedList.pop());

		linkedList.print();
	}

}