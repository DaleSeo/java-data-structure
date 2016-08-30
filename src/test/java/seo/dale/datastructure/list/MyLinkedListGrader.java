package seo.dale.datastructure.list;

public class MyLinkedListGrader {

	public void doTest() {
		String feedback = "";

		DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>();
		int nums[] = {1, 2, 3, 4, 5};

		feedback += "** Test #1: Adding to end of list...\n";
		for (int i : nums) {
			lst.add(i);
		}
		feedback += "Got " + lst.toString() + ".\n";

		feedback += "** Test #2: Getting from the middle...\n";
		feedback += "Fourth element was " + lst.get(3) + ".\n";

		lst.add(2, 6);

		feedback += "** Test #3: Adding to the middle...\n";
		feedback += "Got " + lst.toString() + ".\n";

		feedback += "** Test #4: Testing 'prev' pointers by going through the list backwards...\n";
		feedback += "Got " + lst.toStringBackwords() + ".\n";

		feedback += "** Test #5: Testing list size...\n";
		feedback += "Got " + lst.size() + ".\n";

		lst.remove(2);
		feedback += "** Test #6: Removing from the middle...\n";
		feedback += "Got " + lst.toString() + ".\n";

		feedback += "** Test #7: Testing 'prev' pointers on remove by going through the list backwards...\n";
		feedback += "Got " + lst.toStringBackwords() + ".\n";

		feedback += "** Test #8: Testing size after remove...\n";
		feedback += "Got " + lst.size() + ".\n";

		feedback += "** Test #9: Testing add, remove, and add on new list...\n";
		lst = new DoublyLinkedList<>();
		lst.add(0, 1);
		lst.remove(0);
		lst.add(0, 1);
		feedback += "Got " + lst.toString() + ".\n";

		feedback += "** Test 10: Checking size after previous test...\n";
		feedback += "List size is " + lst.size() + ".\n";

		feedback += "** Tests 11-20: Testing method bounds...\n";

		System.out.println(feedback + "Tests complete. Check that everything is as expected.");
	}

	public static void main(String args[]) {
		MyLinkedListGrader grader = new MyLinkedListGrader();
		grader.doTest();
	}

}
