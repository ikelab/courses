package ds;

public class SinglyLinkedList_Test {
	
	public static void main(String[] args) {
		// Using integer elements.
		SinglyLinkedList<Integer> a = new SinglyLinkedList<>();
		
		a.addFirst(1);
		a.addLast(2);
		a.addFirst(3);
		a.addLast(4);
		
		System.out.println(a);
		
		int x = a.removeFirst();
		System.out.println(x);
		System.out.println(a.removeFirst());
		
		System.out.println(a);
		
		// Using string elements.
		SinglyLinkedList<String> b = new SinglyLinkedList<>();
		
		b.addFirst("Fisrt");
		b.addLast("Second");
		b.addFirst("Third");
		b.addLast("Fourth");
		
		System.out.println(b);
		
		String y = b.removeFirst();
		System.out.println(y);
		System.out.println(b.removeFirst());
		
		System.out.println(b);
	}
}
