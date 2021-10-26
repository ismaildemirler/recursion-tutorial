package recursion.c_divideandconquer;

public class BinarySearch {

	/*
	 * Divide & Conquer 
	   
	   1. Divide problem into several smaller subproblems. Normally subproblems are similar to 
	      the original.
	      
	   2. Conquer the subproblems by solving them recursively 
	      Base case: Solve small enough problems by brute force
	   
	   3. Combine the solutions to get a solution to the subproblems and finally a solution to
	      the original problem.
	   
	   4. Divide and Conquer algorithms are normally recursive.
	 */
	
	/*
	 * Now in this lesson, we want to talk about divide and conquer algorithms, which are really
	 * great demonstrations of recursion. And the blueprint that we think about for dividing 
	 * conquer holds through so we know, still divide a large problem into several small problems.
	 * Divide and conquer is all about we divide them into subproblems. We independently solve them
	 * and then we actually merge the results to solve some holistic problem. We merge them together
	 * and say this is the solution. They are typically recursive. 
	 */
	
	public int binarcySearchExample() {
		
		/*
		 * And let's look at the first one which is binary search. 
		 */
		
		int[] array = { -1, 5, 22, 23, 32, 43, 55, 63, 65, 76 };
		
		return binarySearch(array, 0, 9, 65);
		
		/*
		 * Let's call above array. The first thing that we say is we are going to start with the left and
		 * right index, so far the left index is 0 and the right index 9. Because we have 10 elements in 
		 * the array. And the whole purpose of binary search is to find a value in this array. 
		   - So we know that 0 is less than the length of the array. So we did not hit our base case and 
		     we calculate the midpoint. 
		   - The midpoint is the left and right index added together and divided by 2. We check and we say
		     okay is that midpoint? The answer that we are looking for is another sort of base case. Have 
		     we hit or find the number which is searching? And the answer is no. 
		   - We ask one of the questions, the first question that we ask is the number that we are looking
		     for on the left half of the array, or on the right half of the array? Remember we have just
		     found the midpoint so we can consider everything in the left and in the right of the midpoint
		     because the input data is sorted. If it is on the left half then we completely discard right
		     half. And notice, the way that we do is we change the bounds of the problem. So the left half
		     stays the same.
		   - The starting point on the left stays the same. But we only consider up to the midpoint -1.
		     And so that is our ability to shrink our decision space and completely discard the right half in
		     each recursion or each recursive invocation.
		   - If we get to the other evaluation, this is basically saying the value we are looking for is on 
		     the right half. And what this allows us to do is we only consider the starting point to be the
		     midpoint plus one all the way to the end. So we completely discard the left half of the array.
		   
		 * And for the rest of this problem indeed is also a recursive call.
		 */
		
		/*
		 * So look at the first stack frame in the call stack:
		   int[] array = { -1, 5, 22, 23, 32, 43, 55, 63, 65, 76 };
		   
		   ||								||
		   ||								||
		   || binarySearch(array, 0, 9, 65) ||           
		   ||_______________________________||
		   ||_______________________________||
		   
		   We start with 0 and our upper bound index for the right variable is 9. We are searching for 65.
		   So our midpoint is 32 here and 32 is not the number that we are looking for. So what we can do
		   is we can discard the entire left half of the search space because 65 is greater than midpoint.
		   And it turns out, we add another stack frame to the call stack and notice how parameters have
		   changed.
		   
		   || 								||
		   || binarySearch(array, 5, 9, 65) ||
		   ||								||
		   || binarySearch(array, 0, 9, 65) ||           
		   ||_______________________________||
		   ||_______________________________||
		   
		   Now for the left, the starting bound which is the left is five which is the index where 43 is.
		   And the upper bound is 9. which is the original length of the array that we are working with.
		   Again we calculate the midpoint, the midpoint on this sub array is 63 and we say 65 is greater
		   than 63. So we can completely discard the left half of the array. The stack frame the start bound 
		   is 8th index and upper bound is 9th index.
		   
		   ||                               ||
		   || binarySearch(array, 8, 9, 65) || --> returns 8
		   || 								||
		   || binarySearch(array, 5, 9, 65) || --> returns 8
		   ||								||
		   || binarySearch(array, 0, 9, 65) || --> returns 8          
		   ||_______________________________||
		   ||_______________________________||
		   
		   And again recalculate the midpoint. The midpoint at this point actually is the number we are
		   searching for. So we have hit the base case. And this is the solution. We can just return this
		   value 65 which is in 8th index.
		 */
	}
	
	private int binarySearch(int[] array, int left, int right, int numberSearching) {
		
		if (left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		
		if (numberSearching == array[mid]) {
			return mid;
		}
		
		if (numberSearching < array[mid]) {
			return binarySearch(array, left, mid - 1, numberSearching);
		}
		
		return binarySearch(array, mid + 1, right, numberSearching);
	}
}
