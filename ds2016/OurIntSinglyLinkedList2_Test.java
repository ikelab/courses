package ds;


public class OurIntSinglyLinkedList2_Test {
	
	public static void main(String[] args) {
		OurIntSinglyLinkedList1 a = new OurIntSinglyLinkedList1();
		
		a.addFirst(1);
		a.addLast(2);
		a.addFirst(3);
		a.addLast(4);
		
		System.out.println(a);
		
		int x = a.removeFirst();
		System.out.println(x);
		System.out.println(a.removeFirst());
		
		System.out.println(a);
	}
}
