package ds;

public class ListPos {

	public static void main(String[] args) {
		LinkedPositionalList<Integer> ll = new LinkedPositionalList<>();

		for (int i = 0; i < 10; i++) {
			ll.addLast(i);
		}
		System.out.println(ll);

		for (int i: ll) {
			System.out.print(i + " ");
		}
		System.out.println();

		Position<Integer> p = ll.first();
		int a = p.getElement();
		p = ll.after(p);
		int b = p.getElement();
        p = ll.after(p);
        p = ll.before(p);
		int c = p.getElement();
		System.out.println(a + " " + b + " " + c);
	}
}
