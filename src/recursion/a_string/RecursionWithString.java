package recursion.a_string;

public class RecursionWithString {

	public String reverseString(String input) {
		
		/*
		 * We want to reverse a given String in this example.
		 * input: 'I want to reverse this string'
		 * output: 'gnirts siht esrever ot tnaw I'
		 */
		
		/*
		 * We always ask kind of these questions.
		   - What is the base case?
		     This means 'when can i no longer continue?
		     One letter reversed is itself. And that could be a really good base case for string reversal.
		     But we want to be even lazier. Like what is the laziest, like the least amount of work that
		     we could even consider thinking about. And that would be the empty string, the empty string
		     reversed is again just the empty string. And so if I passed in the empty string to this function
		     it would only make sense to get the empty string back. And so if we modify the code, we look at
		     this, we just have a simple base case where we evaluate if the input string is empty string,
		     then let's just return the empty string.
		     
		     public String reverseString(String input) {
		     	  if(input.equals("")) {
		     	  	  return "";
		     	  }
		     	  //What is the smallest amount of work I can do in each iteration?
		     }
		   
		   - What is the smallest amount of work I can do in each iteration?
		     Between each invocation, what is the small "unit" I can reverse?
		     And so we asked this question, a string is a bunch of characters. So maybe i can modify
		     a single character. We can pick a single character and continue. And it turns out when 
		     we write this code, we get a recursive call where we take that first character from the 
		     input string and we concatenate after the recursive call.
		     
		     public String reverseString(String input) {
		     	  if(input.equals("")) {
		     	  	  return "";
		     	  }
		     	  return reverseString(input.substring(1)) + input.charAt(0);
		     }
		     
		     Here, 'reverseString(input.substring(1))' shrinks the problem space. 
		     'input.charAt(0)' is the smallest unit of work to contribute.
		 */
		
		if(input.equals("")) {
			return "";
		}
		
		return reverseString(input.substring(1)) + input.charAt(0);
		    
		/* 
		 * 		     Call Stack
		 *   _____________________________
		 * ||_____________________________||
		 * ||                             ||
		 * ||   reverseString("") + "o"   || --> returns "o"
		 * ||_____________________________||
		 * ||                             ||
		 * ||   reverseString("o") + "l"  || --> returns "ol"
		 * ||_____________________________||
		 * ||_____________________________||
		 * ||                             ||
		 * ||  reverseString("lo") + "l"  || --> returns "oll"
		 * ||_____________________________||
		 * ||_____________________________||
		 * ||                             ||
		 * || reverseString("llo") + "e"  || --> returns "olle"
		 * ||_____________________________|| 
		 * ||_____________________________||
		 * ||	                          ||
		 * || reverseString("ello") + "h" || --> returns "olleh"
		 * ||_____________________________||
		 * ||_____________________________||
		 * 
		 * Let's say we have passed "Hello". We don't hit the base case, we immediately go to return line
		 * which is basically the recursive invocation with the shrunken down substring. And then we concatenate 
		 * the H. As we had discussed with call stacks, we can not pop this off the call stack until that
		 * recursive call has also completed which adds an additional stack frame to the call stack. 'H' waits
		 * for the stack completion to return. Again we don't hit the base case we shrink down that input string.
		 * But we concatenate the first character. We keep doing this. And it is nice because we don't need to 
		 * keep track of the H and E. It is all self managed for me in the stack frame on the call stack. After
		 * this process now we see that we get to a point where our input string has been whittled down to just the
		 * empty string and this is the base case for us. So we return the empty string. So that reverse string gets 
		 * evaluated the empty string from the base case, we end up just returning the empty string + 'o'.
		 * And now previous recursive call gets evaluated and now returns 'o' + 'l'. And popping things off the call
		 * stack. And when we get to last recursive call we get the string reversed that 'olleh'. This is the power
		 * of these recursive calls that us to return values back down the stack.
		 */
	}

	public Boolean isPalindromeString(String input) {
		input = input.trim().replace(" ", "");
		
		// Define the base case // Stopping condition
		if (input.length() == 0 || input.length() == 1) {
			return true;
		}
		
		// Do some work to shrink the problem space
		if(input.charAt(0) == input.charAt(input.length() - 1)) {
			return isPalindromeString(input.substring(1, input.length() - 1)); 
		}
		
		// Additional basecase to handle non-palindromes.
		return false;
		
		/*
		 * Let' look at the call stack to understand what is happening. We pass 'racecar' as an input string.
		 * 
		 * ||            ||
		 * ||            || 
		 * ||            ||
		 * ||            ||
		 * ||            ||
		 * ||            || 
		 * ||   racecar  ||
		 * ||____________||
		 * 
		 * And first thing we do is we evaluate this conditional this base case is the length is zero or one?
		 * Well, it is definitely not. And we now compare the first and last character for this input string.
		 * And if they are equal then we just call ourselves again, but we shrink that input string. And since
		 * r-r is equal we add another stack frame to the call stack.
		 * 
		 * ||            ||
		 * ||            || 
		 * ||            ||
		 * ||            ||
		 * ||    aceca   ||
		 * ||            || 
		 * ||   racecar  ||
		 * ||____________||
		 * 
		 * And we have shrunken down our input string we again, look at the base case and so on.
		 * 
		 * ||      e     || --> return true.
		 * ||            || 
		 * ||     cec    || --> because inner state returns true, returns true.
		 * ||            ||
		 * ||    aceca   || --> for same reason returns true.
		 * ||            || 
		 * ||   racecar  || --> and returns true.
		 * ||____________||  
		 */
	}
}
