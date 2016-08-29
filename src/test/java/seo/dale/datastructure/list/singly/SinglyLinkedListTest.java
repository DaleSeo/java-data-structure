package seo.dale.datastructure.list.singly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Dale Seo
 */
public class SinglyLinkedListTest {

	private static final int LONG_LIST_LENGTH = 10;

	private SinglyLinkedList<Object> emptyList;
	private SinglyLinkedList<String> shortList;
	private SinglyLinkedList<Integer> longList;

	@Before
	public void setUp() throws Exception {
		emptyList = new SinglyLinkedList<>();

		shortList = new SinglyLinkedList<>();
		shortList.add("A");
		shortList.add("B");
		shortList.add("C");

		longList = new SinglyLinkedList<>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longList.add(i);
		}
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
			assertEquals("Check "+i+ " element", (Integer)i, longList.get(i));
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
	public void testRemove() {
		String a = shortList.remove(0);
		assertEquals("Check a is correct ", "A", a);
		assertEquals("Check element 0 is correct ", "B", shortList.get(0));
		assertEquals("Check size is correct ", 2, shortList.size());

		try {
			shortList.remove(3);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
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
	public void testSize() {
		assertEquals("The size must be correct.", 0, emptyList.size());
		assertEquals("The size must be correct.", 3, shortList.size());
		assertEquals("The size must be correct.", 10, longList.size());

		longList.add(101);
		longList.add(1, 102);
		assertEquals("The size must increment after adding an element.", 12, longList.size());
		System.out.println(longList);

		longList.remove(1);
		assertEquals("The size must decrement after removing an element.", 11, longList.size());
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


	@Test
	public void testSet() {
		try {
			emptyList.set(0, null);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.set(3, "D");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.add(-1, "Z");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		int oldSize = shortList.size();
		shortList.set(1, "BB");
		assertEquals("The data must be updated.", "BB", shortList.get(1));
		assertEquals("The data must not change.", oldSize, shortList.size());
//		System.out.println(shortList);

		oldSize = longList.size();
		longList.set(3, 33);
		assertEquals("The data must be updated.", 33, longList.get(3).intValue());
		assertEquals("The data must not change.", oldSize, longList.size());
//		System.out.println(longList);
	}

}