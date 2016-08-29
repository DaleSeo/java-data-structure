package seo.dale.datastructure.list.singly;

import java.util.AbstractList;

/**
 * @author Dale Seo
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	private ListNode<E> head;
	private int size;

	public SinglyLinkedList() {
		head = new ListNode<>(null);
		size = 0;
	}

	public boolean add(E element) {
		ListNode<E> node = head;
		for (int i = 0; i < size; i++) {
			node = node.getNext();
		}
		node.setNext(new ListNode(element));
		size++;
		return true;
	}

	public void add(int index, E element ) {
		verifyIndex(index);

		ListNode<E> node = head;
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}

		ListNode<E> curr = new ListNode<>(element);
		curr.setNext(node.getNext());
		node.setNext(curr);
		size++;
	}

	public E get(int index) {
		verifyIndex(index);

		ListNode<E> node = head.getNext();
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node.getData();
	}

	public E remove(int index) {
		verifyIndex(index);

		ListNode<E> prev = head;
		ListNode<E> curr = head.getNext();
		for (int i = 0; i < index; i++) {
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(curr.getNext());
		size--;
		return curr.getData();
	}

	public E set(int index, E element)
	{
		// TODO: Implement this method
		return null;
	}

	public int size() {
		return size;
	}

	private void verifyIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public String toString() {
		if (size < 1) {
			return "[EMPTY]";
		}
		return head.getNext().toString();
	}
}
