package searching;
public class BinarySearch
{

	// driver program to test above function
	public static void main(String[] args)
	{
		int arr[] = { 0, 1, 6, 9 };
		int n = arr.length;
		System.out.println("First missing element is: "
				+ findFirstMissing(arr, 0, n - 1));

	}

	private static int findFirstMissing(int array[], int start, int end)
	{

		if (start > end)
			return end + 1;

		if (start != array[start])
			return start;

		int mid = (start + end) / 2;

		if (array[mid] > mid)
			return findFirstMissing(array, start, mid);
		else
			return findFirstMissing(array, mid + 1, end);
	}

}
