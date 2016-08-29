package seo.dale.datastructure.list.singly;

import java.util.AbstractList;

/**
 * Implementation Tip: private getNode를 구현하여 여러 메소드에서 활
 * @author Dale Seo
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	private int size;
	private ListNode<E> head;

	public SinglyLinkedList() {
		head = new ListNode<>(null);
		size = 0;
	}

	public int size() {
		return size;
	}

	public E get(int index) {
		ListNode<E> node = getNode(index);
		return node.getData();
	}

	public boolean add(E element) {
		add(size, element);
		return true;
	}

	public void add(int index, E element ) {
		ListNode<E> prevNode = index == 0 ? head : getNode(index - 1);
		ListNode<E> newNode = new ListNode<>(element);
		newNode.setNext(prevNode.getNext());
		prevNode.setNext(newNode);
		size++;
	}

	public E remove(int index) {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> prev = index == 0 ? head : getNode(index - 1);
		ListNode<E> curr = prev.getNext();
		prev.setNext(curr.getNext());
		size--;
		return curr.getData();
	}

	public E set(int index, E element) {
		ListNode<E> node = getNode(index);
		node.setData(element);
		return element;
	}

	/**
	 * get the node at the index
	 */
	private ListNode<E> getNode(int index) {
		verifyIndex(index);
		ListNode<E> node = head.getNext();
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node;
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
		return head.getNext().toString();
	}

}
