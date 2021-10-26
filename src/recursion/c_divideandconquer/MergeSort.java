package recursion.c_divideandconquer;

public class MergeSort {

	/*
	 * Merge Sort
	 * 
	 * Merge sort is poster child of divide and conquer when explaining this in a lot of computer 
	 * science classes. The idea is that we take in a bunch of unsorted values like the following:
	 * 
	 * 4, 1, 3, 2, 0, -1, 7, 10, 9, 20
	 * 
	 * And the idea is that we divide this array in such a way that we keep dividing. And then we
	 * merge up the sorted results to sort this array in ascending order. Firstly we split the array
	 * in half and we say we are going to focus on the left hand side. And remember before we even do
	 * the right hand side, we need to finish the left hand side first. Thats the order in which 
	 * recursion is going to operate here.
	 * 
	 * 4, 1, 3, 2, 0 
	 * is the left hand side of the array and what do we do we split this in half too. And we get:
	 * 
	 * 4, 1,
	 * is the left hand side of second splitting. And we will split again we get: 
	 * 
	 * 4 and 1 
	 * And the base case here is that you can not really soar just one value. And we compare 4 and 1
	 * and merge and sort them together just by a simple comparison operator. So they will be in 
	 * ascending order and we get:
	 * 
	 * 1, 4 
	 * Now we can look at the right hand side and we split these and we get 
	 * 
	 * 3 and 2 and 0
	 * compare and merge firstly two of them 2 and 0. And get 0, 2. Then compare and merge with 3.
	 * We get:
	 * 
	 * 0, 2, 3
	 * We compare 1, 4 and 0, 2, 3 blocks and merge. We get:
	 * 
	 * 0, 1, 2, 3, 4
	 * We have finished sorting the left hand side of the array. Same process will be executed on 
	 * the right hand side of the array. After handling right side of the array, final merging will
	 * be handled. So what we have done is we have just recursively merges all the results together
	 * from the recursive sub calls. And this is the final merge. Just to emphasize how this comparison
	 * works to ensure that these things get put back in sorted order, we do a linear comparison. 
	 * 
	 *  0, 1, 2, 3, 4   ---   -1, 7, 9, 10, 20
	 * /\                      /\
	 * ||                      ||
	 * 
	 * 0, 1, 2, 3, 4   ---     7, 9, 10, 20
	 * /\                      /\
	 * ||                      ||
	 * 
	 * And what that means is we basically have two pointers, starting with the left hand side and we 
	 * ask which number is smaller, and we know negative one is smaller, so we put this at the beginning.
	 * And increment the right pointer. And then we compare these two in second step. And so on, we will
	 * find the last state of the array and we have it sorted.
	 * 
	 * -1, 0, 1, 2, 3, 4, 7, 9, 10, 20
	 */
	
	public void mergeSort() {
		
		var array = new int[] { 4, 1, 3, 2, 0, -1, 7, 10, 9, 20 };
		
		System.out.println("Beginning Array: ");
		
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("***********************************");

		divide(array, 0, 9);
		
		System.out.println("Sorted Array: ");
		
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("***********************************");
	}
	
	private void divide(int[] array, int start, int end) {
		
		if(start < end) {
			int mid = (start + end) / 2;
			divide(array, start, mid);
			divide(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	
	private void merge(int[] array, int start, int mid, int end) {
		
		//build temp arrays to avoid modifying the original content.
				
		int leftSize = mid - start + 1;    
	    int rightSize = end - mid; 
	    
	    //Temporary Arrays
	    int[] leftArray = new int[leftSize];
	    int[] rightArray  = new int[rightSize];
		
	    /* copy data to temp arrays */  
	    for (int i = 0; i < leftSize; i++)  {
	    	leftArray[i] = array[start + i];   
	    } 
	    for (int j = 0; j < rightSize; j++) {
	    	rightArray[j] = array[mid + 1 + j];
	    } 
	    
	    int leftIndex = 0; /* initial index of first sub-array */  
	    int rightIndex = 0; /* initial index of second sub-array */   
	    int index = start;  /* initial index of merged sub-array */  
	      
	    while (leftIndex < leftSize && rightIndex < rightSize)    
	    {    
	        if(leftArray[leftIndex] <= rightArray[rightIndex])    
	        {    
	            array[index] = leftArray[leftIndex];    
	            leftIndex++;    
	        }    
	        else    
	        {    
	        	array[index] = rightArray[rightIndex];    
	        	rightIndex++;    
	        }    
	        index++;    
	    }    
	    while (leftIndex < leftSize)    
	    {    
	    	array[index] = leftArray[leftIndex];    
	    	leftIndex++;    
	    	index++;    
	    }    
	      
	    while (rightIndex < rightSize)    
	    {    
	    	array[index] = rightArray[rightIndex];    
	    	rightIndex++;    
	    	index++;    
	    }    
	}
}
