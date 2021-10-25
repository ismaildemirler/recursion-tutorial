package recursion.b_number;

public class RecursionWithNumbers {
	
	/*
	 * Now, we want to look at recursion with numbers. And the thing that you will start to realize as
	 * we go through these sorts of problems is that the same blueprint holds true for all of them. 
	 */
	
	public String findBinary(int decimal, String result) {
		
		/*
		 * The first problem we want to look at is this idea of converting decimal base 10 values to binary,
		 * which is a base 2 number format, 1 and 0. So the question is how can we convert a number like 25 into 
		 * its binary counterpart. And it turns out, there is a very mechanical way of doing this. So let's take
		 * the number 233. And the formula here, as we will come to find is we can do a division by two and this
		 * is basically doing the floor operator. So it gets us an integer instead of a floating point value.
		 * 
		 * 233 / 2 = 116 --> rem = 1
		 * 
		 * And we get an output which is 116. And we have a remainder, that remainder is 1. And the mechanical
		 * process that we can follow to convert decimal to binary is we take the results of this operation 
		 * which is 116. And we divide that by 2.
		 * 
		 * 116 / 2 = 58 --> rem = 0
		 * 
		 * And we just keep evaluating and this is 58 and remainder is 0. Then we take 58 and divide by 2.
		 * The number we get is 29 and remainder is 0. We basically just keep taking the result in the output
		 * and dividing it by 2. At the last we are doing:
		 * 
		 * 3 / 2 = 1 --> rem = 1
		 * 
		 * 1 / 2 = 0 --> rem = 1
		 * 
		 * And notice we are keeping track of the remainders here. And the interesting property by doing these 
		 * operations gets us to a point where we can take all of those remainders. So notice, we have gotten 
		 * to this base case, which is zero. So now we are done. And if we take all of these remainders in order
		 * that they were basically pushed onto the stack, we can evaluate them and this is the result in 
		 * binary string for 233.
		 * 
		 * 1 1 1 0 1 0 0 1
		 *  
		 *  And the question is how can we convert it into some recursive operation?
		 */		
		
		/*
		 * Let's look at some of this code. Now notice, we said the first thing is we took 233, divided by 2 
		 * and we got some output. The remainder was 1. And so there are actually many ways of doing this 
		 * problem. So notice we are dealing with strings. As the result outputs, we are going to be 
		 * concatenating strings basically. And so what we consider here is we think about that base case.
		 * If i hit 0, then there is no longer reason for me to divide further. I will return my result.
		 * If i have not hit 0 yet, it means that i still have more division to do. And so the first thing that
		 * we do is we get that remainder. So when we look at 233, divided by 2 we want to store that remainder
		 * because that represents one of the binary digits that we care about, basically tells us if the calue 
		 * is even or odd. And this is the binary, this is the remainder that will contribute the result. So
		 * That is why we store this in the result. And notice, we just prepend this to result. Now what we do is
		 * again just call findBinary() and we shrink the problem space by half. We just propagate the result through.
		 * Now let's actually look at the call stack.
		 */
		
		if (decimal == 0) {
			return result;
		}
		
		result = decimal % 2 + result;
		return findBinary(decimal / 2, result);
		
		/*
		 * We can see what is going on for example in Eclipse by considering Debug Tab as Call Stack and reviewing
		 * operations in there, and Variables Tab to see how variables are changing in recursion operation.
		 */
	}

	public int sumOfNaturalNumbers(int input) {
		
		/*
		 * The next problem is the sum of natural numbers. And the idea of this problem is you take an
		 * input number like 10, and then you sum all the values up to 10. What we do here is actually
		 * just add them all up and we get some output and the output in this case would be 55. The 
		 * question is how can we build a succinct function that does this recursively. Now let's look 
		 * at a little snippet of code and try to understand what is happening behind the scenes.
		 */
		
		if (input <= 1) {
			return input;
		}
		
		return input + sumOfNaturalNumbers(--input);
		
		/*
		 * Of course for this problem the best solution is finding result by using mathematical formula which
		 * is n * (n + 1) / 2. But we are studying recursive operations. Again we can keep track of call stack
		 * by using Debug Tab and Variables by using Variables Tab.
		 */
	}
}