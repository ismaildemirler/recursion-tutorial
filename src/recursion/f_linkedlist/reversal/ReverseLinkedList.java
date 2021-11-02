package recursion.f_linkedlist.reversal;

public class ReverseLinkedList {

	private Node head;

	public class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
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
	
	public Node reverse(Node node) {
		
		if(node == null || node.next == null) {
			return node;
		}
		
		Node p = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return p;
	}
	
	public void printLinkedList(Node head) {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.getNext();
		}
		System.out.println("null");
		System.out.println("");
	}
}
