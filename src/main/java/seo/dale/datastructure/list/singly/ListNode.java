package seo.dale.datastructure.list.singly;

/**
 * @author Dale Seo
 */
public class ListNode<E> {

	private E data;
	private ListNode next;

	public ListNode(E data) {
		this.data = data;
	}

	public ListNode(E data, ListNode prev) {
		this.data = data;
		this.next = prev.next;
		prev.next = this;
	}

	public E getData() {
		return data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode node = this;
		while (node != null) {
			builder.append(node.data).append("->");
			node = node.next;
		}
		builder.setLength(builder.length() - 2);
		return builder.toString();
	}
}
