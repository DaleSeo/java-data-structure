package seo.dale.datastructure.list;

/**
 * @author Dale Seo
 */
class ListNode<E> {

	E data;
	ListNode next;
	ListNode prev;

	ListNode(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data == null ? "" : data.toString();
	}
}
