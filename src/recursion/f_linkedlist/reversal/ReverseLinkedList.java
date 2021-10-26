package recursion.f_linkedlist.reversal;

public class ReverseLinkedList {

	public class Node {
		
		private int val;
		private Node next;
		
		public Node(int val) {
			this.val = val;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}
		
		public Node getNext() {
			return next;
		}
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
	
	public void printLinkedList(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.println(temp.val + " ");
			temp = temp.getNext();
		}
	}
}
