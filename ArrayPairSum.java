import java.util.*;

public class ArrayPairSum {
	
	public static void main(String[] args) {	
	}

	/*
	Problem:
	Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
	say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
	
	Constrains:
	1. n is a positive integer, which is in the range of [1, 10000].
	2. All the integers in the array will be in the range of [-10000, 10000].

	Solution 1:
	Since we are going to add up min(ai, bi), we would like to minimize the difference between ai and bi.
	We can simply add up the sorted nums[0] and nums[i] where i is even.

	Time & Space complexity:
	Java implements Quicksort which is O(nlogn) time complexity and O(1) space complexity.

	Solution 2:
	Create a new array and represent the data using index and store the number of appearance as the data itself.
	
	For example, if nums = [1, 4, 2, 7, 2]
	
	We can store 1 at index 1, 4 at index 4 and so and so forth. 
	The newly created array length is 20001 as we need to cater the negative number as well.
	If we iterate through the array from index 0 to index length - 1, it is actually same as iterating through the sorted nums.

	For example, the newly created array would be something like this:
	data:  [...,     0,     1,     2,     0,     4,     0,     0,     1, ...]
	index: [..., 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, ...]
	
	"index - 10000" is equivalent to the data in nums and "data" is the number of consecutive appearance. -> [1, 2, 2, 4, 7]
	
	FInally, we can iterate through the new array. 
	For each index, we loop "data" times and data is decreased by 1 for each iteration  until "data" becomes 0.
	We need to create a flag to denote whether we need to take the current step into account.

	Time & Space complexity:
	In the first step, we need to loop through nums so it takes O(n).
	In the second step, we need to loop through the newly created array which takes another O(n).
	The sum of linear time complexity is linear time complexity.
	Therefore, this algorithm has O(n) time complexity.

	Since we need to create a new array to store the data and we need to double the length of nums to cater the negative number,
	the space complexity required should be O(2n) which is same as O(n).

	*/
	public static int naiveSolution(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;

		for(int i = nums.length - 2; i >= 0; i -= 2) {
            sum += nums[i];
        }

        return sum;
	}

	public static int arrayPairSum(int[] nums) {
		int[] exists = new int[20001];
		for(int i : nums) {
			exists[i + 10000]++;
		}

		int sum = 0;
		boolean odd = true;
		for(int i = 0; i < exists.length; i++) {
			while(exists[i] > 0) {
				if(odd) {
					sum += i - 10000;
				}

				odd = !odd;
				exists[i]--;
			}
		}

		return sum;
	}
}

