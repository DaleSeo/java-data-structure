package seo.dale.datastructure.list.singly;

/**
 * @author Dale Seo
 */
public class SinglyLinkedList<E> {

	private ListNode<E> head;
	private int size;

	public SinglyLinkedList() {
		head = new ListNode<>(null);
		size = 0;
	}

	public boolean add(E data) {
		ListNode<E> node = head;
		for (int i = 0; i < size; i++) {
			node = node.getNext();
		}
		node.setNext(new ListNode(data));
		size++;
		return true;
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

	public boolean insert(int index, E data) {
		verifyIndex(index);

		ListNode<E> node = head;
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}

		ListNode<E> curr = new ListNode<>(data);
		curr.setNext(node.getNext());
		node.setNext(curr);
		size++;
		return true;
	}

	public int getSize() {
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
