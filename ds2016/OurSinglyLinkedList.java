package ds;


public class OurSinglyLinkedList<E> {

	static class OurNode<E> {
		E element;
		OurNode<E> next;
		
		OurNode(E e, OurNode<E> n) {
			element = e;
			next = n;
		}
	}

	OurNode<E> head = null;
	OurNode<E> tail = null;

	public OurSinglyLinkedList() {
	}

	public E first() {
		if (head == null)
			return null;  // nothing to return
		return head.element;
	}

	public E last() {
		if (tail == null)
			return null;  // nothing to return
		return tail.element;
	}

	public void addFirst(E e) {
		OurNode<E> newNode = new OurNode<E>(e, head);

		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
	}
	
	public void addLast(E e) {
		OurNode<E> newNode = new OurNode<E>(e, null);
		
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	public E removeFirst() {
		if (head == null)
			return null; // nothing to remove
		
		E answer = head.element;
		
		head = head.next;
		if (head == null) {
			tail = null;
		}
		
		return answer;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		OurNode<E> walk = head;
		while (walk != null) {
			sb.append(walk.element);
			if (walk.next != null)
				sb.append(", ");
			walk = walk.next;
		}
		sb.append(")");
		return sb.toString();
	}
}
