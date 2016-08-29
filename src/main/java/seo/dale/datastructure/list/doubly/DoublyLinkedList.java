package seo.dale.datastructure.list.doubly;

import java.util.AbstractList;

/**
 * @author Dale Seo
 */
public class DoublyLinkedList<E> extends AbstractList<E> {

	private int size;
	private ListNode<E> head;
	private ListNode<E> tail;

	public DoublyLinkedList() {
		this.size = 0;
		this.head = new ListNode<>(null);
		this.tail = new ListNode<>(null);
		head.next = tail;
		tail.prev = head;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) {
		ListNode<E> node = getNode(index);
		return node.data;
	}

	@Override
	public boolean add(E element) {
		ListNode newNode = new ListNode<>(element);
		if (tail.prev != null) {
			tail.prev.next = newNode;
		}
		tail.prev = newNode;
		size++;
		return true;
	}

	/**
	 * get the node at the index
	 */
	private ListNode<E> getNode(int index) {
		verifyIndex(index);

		if (index < size / 2) {
			ListNode<E> node = head.next;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			ListNode<E> node = tail.prev;
			for (int i = 0; i < size - 1 - index; i++) {
				node = node.prev;
			}
			return node;
		}
	}

	private void verifyIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public String toString() {
		if (size < 1) {
			return "";
		}
		return head.next.toString();
	}

}
