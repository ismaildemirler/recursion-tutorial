package recursion.f_linkedlist.merging;

public class MergeLinkedList {
	
	private Node head;
	
	public class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}
		
		public Node getNext() {
			return next;
		}
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public static Node merge(Node a, Node b) {
		
		if (a == null) {
			return b;
		}
		
		if (b == null) {
			return a;
		}
		
		if (a.data < b.data) {
			a.next = merge(a.next, b);
			return a;
		} 
		else {
			b.next = merge(a, b.next);
			return b;
		}
	}
	
	public static void printLinkedList(Node head) {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.getNext();
		}
		System.out.println("null");
		System.out.println("");
	}
}
