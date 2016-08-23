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
		assertEquals(0, list.getSize());

		list.add("A");

		System.out.println(list.toString());
		assertEquals(1, list.getSize());

		list.add("B");
		list.add("C");

		System.out.println(list.toString());
		assertEquals(3, list.getSize());
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
		assertEquals(2, list.getSize());

		assertEquals("A", list.remove(0));
		assertEquals(1, list.getSize());

		try {
			list.remove(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		assertEquals("B", list.remove(0));
		assertEquals(0, list.getSize());

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
			list.insert(-1, "D");
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		list.insert(2, "D");
		System.out.println(list);
		assertEquals(4, list.getSize());

		list.insert(0, "E");
		System.out.println(list);
		assertEquals(5, list.getSize());

		try {
			list.insert(5, "F");
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