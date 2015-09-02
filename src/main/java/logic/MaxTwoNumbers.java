package logic;

public class MaxTwoNumbers {
	public static void main(String[] args) {

		System.out.println("Max of two numbers 5,10 :" + getMax(5, 10));
		System.out.println("Max of two numbers 10,5 :" + getMax(10, 5));
	}

	static int getMax(int a, int b) {
		int c = a - b;
		int k = (c >>> 31);// & 0x1;
		int max = a - k * c;
		return max;
	}

}
