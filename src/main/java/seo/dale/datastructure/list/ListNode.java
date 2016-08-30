package seo.dale.datastructure.list;

/**
 * @author Dale Seo
 */
public class ListNode<E> {

	E data;
	ListNode next;
	ListNode prev;

	ListNode(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode node = this;
		while (node != null) {
			builder.append(node.data).append(" ");
			node = node.next;
		}
		builder.setLength(builder.length() - 2);
		return builder.toString();
	}
}
