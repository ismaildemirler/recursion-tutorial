package recursion.d_fibonacci;

public class Fibonacci {

	/*
	 * Fibonacci (Non-Optimized)
	 * 
	 * Let's look at Fibonacci, a classical, mathematical and computer science problem that often 
	 * demonstrates the power of recursion. And we are going to be looking at the non optimized 
	 * version here. And we will add some optimization at the end. 
	 * F0 = 0, F1 = 1
	 * Fn = F(n-1) + F(n-2) 
	 * Above is mathematical expression of Fibonacci.
	 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
	 * 
	 * So let's kind of look at this and understand why it differs from the previous ones. Now we 
	 * are dividing and conquering. We are dividing this problem, we have fib(n - 1) that needs to 
	 * happen we add it to fib(n - 2). These are recursive calls. As we think back how the call stack
	 * works, we know that the recursion on the left needs to complete before we even consider starting
	 * the recursive call on the right. So fib(n - 1) could have a ton of different calls that need to
	 * complete before we even do the plus operator to fib(n - 2).
	 * 
	 * Let's assume we want to find fibonacci of 5 numbers.
	 *                          
	 *                          				     ________
	 * 						              ________	 ||f(5)||
	 *          	          ________    ||f(4)|| <---
	 *            ________    ||f(3)|| <---
	 * ________   ||f(2)|| <---
	 * ||f(1)|| <---
	 * ||    || --->   
	 *          returns 1
	 * 
	 * Until we hit base case and get a returning result first recursive function works. After that we got 
	 * a result and the second recursive function 2 - 2 = 0. So fib(0) works and we can see like below:,
	 * 
	 * 				                                 ________
	 * 						              ________	 ||f(5)||
	 *          	          ________    ||f(4)|| <---
	 *                        ||f(3)|| <---
	 *            ________
	 *            ||f(2)|| <---
	 * ________
	 * ||f(1)|| <---
	 * ||    || --->   
	 * ________   
	 * ||f(0)|| <---
	 * ||    || --->
	 * 
	 * It goes on like that. After fib(0) worked, fib(2) has finished its children, fib(1) works as child of
	 * fib(3). And fib(3) has finished its job. After that fib(4) will have fib(2) and fib(2) again have fib(1)
	 * and fib(0). But we have calculated fib(2), fib(1) and fib(0) earlier. So to be able to avoid these
	 * recalculation we will cover some optimization techniques later known as memoization. So after fib(5) 
	 * has fib(3) and children of fib(3) a constructure like binary tree shows up.
	 */                       
	
	public long fib(long n) {
		if((n == 0) || (n == 1)) {
			return n;
		}
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
