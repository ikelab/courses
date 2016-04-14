package ds;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIter {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();

		for (int i = 0; i < 10; i++) {
			ll.add(i);
		}
		System.out.println(ll);
		
		for (int i: ll) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		ListIterator<Integer> li = ll.listIterator();
		int a = li.next();
		int b = li.next();
		int c = li.previous();
		System.out.println(a + " " + b + " " + c);
		
		while (li.hasNext()) {
			int x = li.next();
			if ((x % 3) == 0) {
				li.remove();
			}
		}
		System.out.println(ll);

		li = ll.listIterator();
		while (li.hasNext()) {
			int x = li.next();
			if ((x % 2) == 0) {
				li.add(x + 10);
			}
		}
		System.out.println(ll);
	}
}
