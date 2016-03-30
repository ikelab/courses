package ds;


class OurIntNode2 {
	Integer element;
	OurIntNode2 next;
	
	OurIntNode2(Integer e, OurIntNode2 n) {
		element = e;
		next = n;
	}
}


public class OurIntSinglyLinkedList2 {

	OurIntNode2 head = null;
	OurIntNode2 tail = null;

	public OurIntSinglyLinkedList2() {
	}

	public Integer first() {
		if (head == null)
			return null;  // nothing to return
		return head.element;
	}

	public Integer last() {
		if (tail == null)
			return null;  // nothing to return
		return tail.element;
	}

	public void addFirst(Integer e) {
		OurIntNode2 newNode = new OurIntNode2(e, head);

		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
	}
	
	public void addLast(Integer e) {
		OurIntNode2 newNode = new OurIntNode2(e, null);
		
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	public Integer removeFirst() {
		if (head == null)
			return null; // nothing to remove
		
		Integer answer = head.element;
		
		head = head.next;
		if (head == null) {
			tail = null;
		}
		
		return answer;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		OurIntNode2 walk = head;
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
