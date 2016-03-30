package ds;


class OurIntNode1 {
	Integer element;
	OurIntNode1 next;
}


public class OurIntSinglyLinkedList1 {

	OurIntNode1 head = null;
	OurIntNode1 tail = null;

	public OurIntSinglyLinkedList1() {
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
		OurIntNode1 newNode = new OurIntNode1();
		newNode.element = e;
		newNode.next = head;

		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
	}
	
	public void addLast(Integer e) {
		OurIntNode1 newNode = new OurIntNode1();
		newNode.element = e;
		
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
		OurIntNode1 walk = head;
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
