package recursion.f_linkedlist.sorting;

public class SortLinkedList {

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
	
	public Node mergeSort(Node head) {
		if (head == null || head.next == null)
        {
            return head;
        }
		
		Node middle = getMiddle(head);
		Node nextofmiddle = middle.next;
		middle.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextofmiddle);
		Node sortedList = merge(left, right);	
		return sortedList;
	}
	
	private Node getMiddle(Node head)
    {
        if (head == null)
            return head;
 
        Node slow = head;
        Node fast = head;
 
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
       
        return slow;
    }
	
	private Node merge(Node left, Node right) {
		if (left == null) {
			return right;
		}
		
		if (right == null) {
			return left;
		}
		
		if (left.data < right.data) {
			left.next = merge(left.next, right);
			return left;
		} 
		else {
			right.next = merge(left, right.next);
			return right;
		}
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
