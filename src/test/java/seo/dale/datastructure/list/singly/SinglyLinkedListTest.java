package seo.dale.datastructure.list.singly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Dale Seo
 */
public class SinglyLinkedListTest {

	@Test
	public void testAdd() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		System.out.println(list.toString());
		assertEquals(0, list.size());

		list.add("A");

		System.out.println(list.toString());
		assertEquals(1, list.size());

		list.add("B");
		list.add("C");

		System.out.println(list.toString());
		assertEquals(3, list.size());
	}

	@Test
	public void testGet() {
		SinglyLinkedList<String> list = createTestList();

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}

	@Test
	public void testRemove() {
		SinglyLinkedList<String> list = createTestList();
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		assertEquals("C", list.remove(2));
		assertEquals(2, list.size());

		assertEquals("A", list.remove(0));
		assertEquals(1, list.size());

		try {
			list.remove(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		assertEquals("B", list.remove(0));
		assertEquals(0, list.size());

		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testInsert() {
		SinglyLinkedList<String> list = createTestList();
		try {
			list.add(-1, "D");
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		list.add(2, "D");
		System.out.println(list);
		assertEquals(4, list.size());

		list.add(0, "E");
		System.out.println(list);
		assertEquals(5, list.size());

		try {
			list.add(5, "F");
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}

	private SinglyLinkedList<String> createTestList() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		return list;
	}

}