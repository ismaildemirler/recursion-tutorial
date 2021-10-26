package recursion.f_linkedlist;

import recursion.f_linkedlist.reversal.ReverseLinkedList;
import recursion.f_linkedlist.reversal.ReverseLinkedList.Node;

public class RecursionWithLinkedList {

	/*
	 * LinkedLists are really common data structures used to store data that is not necessarily
	 * contiguously stored in memory. And it turns out you can do a lot of cool recursion on
	 * these sort of things.
	 */
	
	public void reversalLinkedList() {
		
		/*
		 * Reverse LinkedList
		  
		   public ListNode reverseList(ListNode head) {
		       if(head == null) || head.next == null) {
		           return head;
		       }
		       
		       ListNode p = reverseList(head.next);
		       head.next.next = head;
		       head.next = null;
		       return p;
	       }
	       
		 * We are going to look at LinkedList reversal. Now the idea is that we have some sort of
		 * LinkedList. Let's say we have values:
		   
		   1 -> 2 -> 3 -> 4 -> 5 -> 6
		 * in sorted like this. And we will just have a bunch of pointers. And the idea is that head
		 * node changes from 1 which is pointing 2, 2 is pointing 3, 4, 5 so on. Instead, we want 6
		 * towards 5, 5 to 4, and so on. When look at the code above, this reversal code, we asked
		 * if the head node is null, if we pass a null value or the next value from the head is null,
		 * then we just return the head. This kind of brings us back to that idea of considering base
		 * case. What is the smallest thing I could pass in? I can just return null. And that would be
		 * a reversed list. And for the same, if i just passed a single node, where there was no 
		 * next node, then i could just return head again. Now, the question is how do i even start the
		 * reversal? What is the unit of work i need to do and that is what we are going to look at.
		 * So we start with 1, the head node that we pass in the first iteration is 1. And we don't hit
		 * the base case. And so on recursion line, we see that we call reverse list head.next. And that
		 * immediately pushes us to the next node. We have one stack frame on the call stack. Now we are
		 * looking at 2 and this is not null either and it also does not have a pointer which is pointing
		 * null. So we execute recursion line again at another stack frame on the call stack. And that 
		 * gets us 3. And this process continues all the way until we get to 6. When 6 gets passed in as
		 * a parameter, we say is it null? The answer is no. But the next value is null. And we return
		 * head, which is just 6. and 6 is returned as the node to the previous value. So this is the
		 * base case. We return this to 5. So now p has been evaluated to number 6. And we are saying 
		 * that since the number 5 is the current head node, we are saying 5.next equals 5. And it turns
		 * out what that means we are basically just what i want to do is take 6 and have it to point
		 * back to 5. Because head next to 6, and head.next which is 6.next is going to be pointing to 5.
		 * And think 5 is the head node. We want to say the next pointers, next position points back to
		 * ourself. Now the problem is that 5 is also pointing to 6. This would be cause to circular 
		 * dependency. And so what we can say 5.next can point to nothing. So we can do 5.next = null;
		 * And what we return is 6 because we want 6 to be new head. And 6 will get propagated down the
		 * call stack. That is why we return p here. So now we return and we get to 4. When we look at 4,
		 * we know that p is 6. Here we are saying for 4, next node is 5. and i want 5 pointing to 4. And
		 * we do same thing we take 5 points to 4. To avoid the cyclic dependency we drop pointer from 4
		 * to 5. What will you return is 6. Because again, 6 gets propagated through and 6 is always going
		 * to be P in this case. And so now i return. And i know 6 is P, but head.next is 4. So i say
		 * head.next.next equals 3. Again we dropped the cyclic dependency and we get rid of this connection.
		 * And now I return P, still 6. I return to 2 and i say 2's next value which is 3 i want 3.next
		 * points to 2. After doing same things for 1 we are done.
		 */
		
		ReverseLinkedList linkedList = new ReverseLinkedList();
		
		Node node1 = linkedList.new Node(1);
		Node node2 = linkedList.new Node(2);
		Node node3 = linkedList.new Node(3);
		Node node4 = linkedList.new Node(4);
		Node node5 = linkedList.new Node(5);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		System.out.println("LinkedList Before Reverse: ");
		linkedList.printLinkedList(node1);
		
		System.out.println("******************************");
		
		Node reversed = linkedList.reverse(node1);
		System.out.println(" ");

		System.out.println("LinkedList After Reverse: ");
		linkedList.printLinkedList(reversed);
		System.out.println("******************************");
	}

	public void sortLinkedList() {
		
	}
	
	public void mergeLinkedList() {
		
	}
}
