package seo.dale.datastructure.list.doubly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Dale Seo
 */
public class DoublyLinkedListTest {

	private static final int LONG_LIST_LENGTH = 10;

	private DoublyLinkedList<Object> emptyList;
	private DoublyLinkedList<String> shortList;
	private DoublyLinkedList<Integer> longList;

	@Before
	public void setUp() throws Exception {
		emptyList = new DoublyLinkedList<>();
		System.out.println(emptyList);

		shortList = new DoublyLinkedList<>();
		shortList.add("A");
		shortList.add("B");
		shortList.add("C");
		System.out.println(shortList);
	}

	@Test
	public void testSize() {

	}

	@Test
	public void testGet() {
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.get(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}

}