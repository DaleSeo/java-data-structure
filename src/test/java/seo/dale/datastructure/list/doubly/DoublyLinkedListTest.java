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

		longList = new DoublyLinkedList<>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longList.add(i);
		}
		System.out.println(longList);
	}

	@Test
	public void testSize() {

	}

	@Test
	public void testGet() {
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

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

		// test longer list contents
		for(int i = 0; i< LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check " + i + " element", i, longList.get(i).intValue());
		}

		// test off the end of the longer array
		try {
			longList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			longList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testAddEnd() {
		int oldSize = shortList.size();
		boolean d = shortList.add("D");

		assertEquals("True must be returned.", true, d);
		assertEquals("The size must increment.", oldSize + 1, shortList.size());
		assertEquals("The element must be added at the end.", "D", shortList.get(shortList.size() - 1));

		Object n = emptyList.add(null);

		assertEquals("True must be returned.", true, n);
		assertEquals("The size must increment.", 1, emptyList.size());
		assertEquals("The element must be added at the end.", null, emptyList.get(0));
	}

	@Test
	public void testAddAtIndex() {
		try {
			emptyList.add(1, null);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.add(4, "D");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.add(-1, "Z");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		emptyList.add(0, null);
		assertEquals("Check element at the index.", null, emptyList.get(0));
		assertEquals("Check size is correct.", 1, emptyList.size());

		int oldSize = longList.size();
		longList.add(2, 101);
		assertEquals("Check element at the index.", 101, longList.get(2).intValue());
		assertEquals("Check size is correct.", oldSize + 1, longList.size());
	}



}