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
		add(size, element);
		return true;
	}

	@Override
	public void add(int index, E element) {
		ListNode newNode = new ListNode<>(element);
		ListNode<E> node = index == size ? tail : getNode(index);
		node.prev.next = newNode;
		newNode.prev = node.prev;
		node.prev = newNode;
		newNode.next = node;
		size++;
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
