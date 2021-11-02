package recursion;

import recursion.a_string.RecursionWithString;
import recursion.b_number.RecursionWithNumbers;
import recursion.c_divideandconquer.BinarySearch;
import recursion.c_divideandconquer.MergeSort;
import recursion.d_fibonacci.Fibonacci;
import recursion.f_linkedlist.RecursionWithLinkedList;

public class Recursion {

	/*
	 * Recursion Subject
	 * 
	 * ATM Analogy
	 * The best way to talk about it is through this analogy, let's imagine that you are 
	 * waiting in line to withdraw money out of an ATM. And for this example, let' assume
	 * you are end of this line and you want to know 'How many people are in front of me?'
	 * And this kind of brute force, one option is I could run to front and maybe count one by one. 
	 * And maybe I store these counts in some auxiliary notebook that i have some external variable that
	 * you can imagine and then you run down this line and you get back and you say, okay 
	 * you got answer but i did a lot of work. And we want to think how can I be lazy? 
	 * What is the least amount of work that I can do and sort of break this problem down in some 
	 * sort of sub structure? And so what i do I tap on person's shoulder in front of me, 
	 * and i asked a very simple question, I say what number are you? And this person answers me 
	 * that he does not know. Next process is that he asks 'what number are you? to person 
	 * in front of him. This process continues and it continues up until we hit some stopping condition.
	 * This condition is the guy which is the beginning of the line. He answers that he is number 1.
	 * And every person answers the question by adding 1 because they count themselves.
	 * At the end process comes to me and i add 1 to answer and i can find what number i am.
	 * 
	 * And now it turns out that we can model this problem with this simple blueprint
	 * 1) What is the least amount of work I can do?
	 * 2) When would the process complete?
	 * 
	 * It just so happens that we can actually write this problem in a very simplified, minimal 
	 * piece of code. And the function that we have is just this get my positin in line.
	 * 
	   public int getMyPositionInLine(Person person) {
	   		if(person.nextInLine == null) {
	   			return 1;
	   		}
	   		
	   		return 1 + getMyPositionInLine(person.nextInLine);
	   }
	   
	  * Notice the return values in integer. And we say if the next person in line is null, then 
	  * we must be the first person in line. This kind of base case, nobody is in line, then you are
	  * the first person in line.	 
	  * 
	  * Essay Revision Analogy
	  * Let's talk about another example, you writing an essay and submitted to professor. And he say,
	  * 'this essay is not good enough i want you to make revisions'. And the essay gets passed back to the student.
	  * This process can actually continue over and over until professor say that 'okay it is good'. 
	  * This kind of recursive strategy that can be developed. We can look at a simple piece of code.
	  * 
	    function revise(essay) {
	    	read(essay);
	    	getFeedBackOn(essay);
	    	applyChangesTo(essay);
	    	revise(essay) unless essay.complete?;
	    }
	    
	  * So again, like what is recursion, recursion is nothing more than a method that calls itself.
	    
	    public void recursion(int someValue) {
	   		if(someValue == 10) { //Base Case
	   			return;
	   		}
	   		
	   		return recursion(someValue + 1); //Recursive call
	    }
	  
	  * and to be more precise, it is usually a method that maybe returns a value, maybe it does not.
	  * But it is conditioned on some parameter, such that when you hit some conditional at some point
	  * in time, you can actually stop recursing, some base case. Let's discuss some of the trade offs.
	  * 
	  * Why & Why Not
	  * 
	  * Pros:
	    - Bridges the gap between elegance and complexity
	    - Reduces the need for complex loops and auxiliary data structures
	    - Can reduce time complexity easily with memoization
	    - Works really well with recursive structures like JSON Objects, trees and graphs
	  * Cons:
	    - Slowness due to CPU overhead
	    - Can lead to out of memory errors / stack overflow exceptions
	    - Can be unnecessarily complex if poorly constructed.
	 */
	
	/*
	 * Call Stack
	 * This brings us to a topic that i think is often overlooked when learning recursion, which I think
	 * is one of the fundamental concepts that you really need to grasp to understand. Let's imagine that you
	 * go to work one day, the first thing that you want to do is check your email. But when you are checking 
	 * your mails, your boss interrupted you and he asked you to attend a meeting. But when you are in meeting
	 * your boss asked to meet investors, at this time boss interrupted again and he wanted you to help 
	 * a worker to developing a project. So when you have finished this you get back to investors and after that
	 * you got back to meeting and lastly you have finished checking your email. Ýt just so happens that this sort
	 * of idea is exactly when we are talking about invoking methods within our programs.
	 * Let's take a look at this simple program here.
	   
	   public String A() {
			return "hello " + B();
	   }
	
	    public String B() {
			return "my " + C();
	    }
	
      	public String C() {
		 	return "friends.";
	    }
	    
	  * We see that the program can not stop working until C() executes. We try to execute and get result of
	  * A() but firstly we have to execute and get result of B(). But when we want to execute and get result of B()
	  * we have to execute and get result of the C(). So after executing and getting result of C() then we are able
	  * to get result of B() and finally getting result of A(). So firstly C() get popped off stack, after B() get
	  * popped off the stack and then A() get popped off stack. We can see that Stack uses in LIFO (Last In First Out) 
	  * logic. And got my expected output.
	  * 
	  * An let's look at an example. Let's look at a call stack when we call these recursive calls,
	  * 
	    public String A() {
	    	return A();
	    }
	    
	  * This is just a program that calls itself and it will execute forever. It calls again and again, and it just 
	  * keeps happening because there is no stopping condition. And finally, there is going to be this point in time
	  * where i try and invoke again  and i get an error that is Stack Overflow. And this exception happens when we
	  * exceed the pre allocated buffer of memory that our program has. That is why we need a base case and we need 
	  * to return a value. So just like we saw previously for methods that are not recursive. We noticed that frames
	  * still grow and grow. And the only way for those frames to shrink in size is for them to return some value for
	  * them to stop invoking methods. The same holds true with recursion. We want to start off the first technical 
	  * component looking at recursion with Strings. And this is going to give us a really good idea of manipulating 
	  * input parameters on the call stack recursively. And the first problem we want to look at is this idea of 
	  * String reversal.
	  */
	
	public static void main(String[] args) {
		
		RecursionWithString recursionWithString = new RecursionWithString();
		String reversedString = recursionWithString.reverseString("I want to reverse this string");
		System.out.println("Reversed string by using recursive : " + reversedString);
		System.out.println("********************************************************");
		
		Boolean isPalindrome = recursionWithString.isPalindromeString("no melon no lemon");
		System.out.println("Is 'no melon no lemon' recursive? : " + isPalindrome);
		System.out.println("********************************************************");
		
		System.out.println("-----------------------------------------------------------");
		
		RecursionWithNumbers recursionWithNumbers = new RecursionWithNumbers();
		String binary = recursionWithNumbers.findBinary(233, "");
		System.out.println("Binary counterpart of 233 : " + binary);
		System.out.println("********************************************************");
		
		int sumOfNaturalNumbers = recursionWithNumbers.sumOfNaturalNumbers(15);
		System.out.println("Sum Of Natural Numbers Up To 15 : " + sumOfNaturalNumbers);
		System.out.println("********************************************************");
		
		System.out.println("-----------------------------------------------------------");
		
		BinarySearch binarySearch = new BinarySearch();
		int searchedIndex = binarySearch.binarcySearchExample();
		System.out.println("The searched index of the number: " + searchedIndex);
		System.out.println("********************************************************");
		
		System.out.println("-----------------------------------------------------------");
		
		Fibonacci fibonacci = new Fibonacci();
		long fibNumber = fibonacci.fib(20);
		System.out.println("Fibonacci Result: " + fibNumber);
		System.out.println("********************************************************");
		
		System.out.println("-----------------------------------------------------------");
		
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort();		

		System.out.println("-----------------------------------------------------------");
		
		RecursionWithLinkedList recursionWithLinkedList = new RecursionWithLinkedList();
		recursionWithLinkedList.reversalLinkedList();
		recursionWithLinkedList.mergeLinkedList();
		recursionWithLinkedList.sortLinkedList();
	} 
}
