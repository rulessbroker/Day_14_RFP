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

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

//		linkedList.add(70);
//		linkedList.add(30);
//		linkedList.add(56);
		
		
		
		linkedList.append(56);
//		linkedList.append(30);
		linkedList.append(70);
		
		linkedList.insertAfter(56, 30);

		linkedList.print();
	}

}