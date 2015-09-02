package questions;

/**
 * You are given an array of integers (both positive and negative). Find the
 * continuous sequence with the largest sum. Return the sum.<br/>
 * EXAMPLE Input: {2, -8, 3, -2, 4, -10} Output: 5 (i.e., {3, -2, 4} )
 * 
 * @author skothuri
 *
 */
public class MaxSum {
	public static void main(String[] args) {
		int[] numbers = { 2, -8, 3, -2, 4, -10 };
		System.out.println("MaxSum of continuous numbers: " + getMaxSum(numbers));

	}

	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}
}
