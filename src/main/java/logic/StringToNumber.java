package logic;

public class StringToNumber
{
	public static long convertToNumber ( String str )
	{
		int len = str.length();
		long digit = 0;
		boolean isNeg = false;
		int i = 0;
		if (str.charAt(0) == '-')
		{
			isNeg = true;
			i++;
		}
		for (int j = i; j < len; j++)
		{
			char ch = str.charAt(j);
			int num = ch - '0';
			digit = digit * 10 + num;
		}
		if (isNeg)
			return -digit;
		return digit;
	}

	public static String convertNumberToString ( long number )
	{
		boolean isNeg = false;
		int len = 0;

		if (number < 0)
		{
			isNeg = true;
			len = 1;
		}

		long numb = number;
		while (numb != 0)
		{
			len++;
			numb = numb / 10;
			// number = -number;
		}
		char[] numbs = new char[len];
		int ctr = len - 1;

		while (number > 0)
		{
			int mod = (int) number % 10;
			numbs[ctr--] = (char) (mod + '0');
			number = number / 10;
		}
		if (isNeg)
			numbs[ctr] = '-';
		return new String(numbs);
	}

	public static void pascalTriangle ( int numOfLines )
	{
		for (int i = 1; i <= numOfLines; i++)
		{
			for (int j = 1; j <= numOfLines - i; j++)
			{
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void fibanacciSeries ( int n )
	{
		int f1 = 0, f2 = 1, f3 = 0;
		System.out.print(f1 + " " + f2 + " ");
		for (int i = 1; i <= n; i++)
		{
			f3 = f1 + f2;
			System.out.print(f3 + " ");
			f1 = f2;
			f2 = f3;
		}
	}

	public static Long fibonacci ( Long n )
	{
		if (n == 0)
			return (long) 0;
		else if (n == 1)
			return (long) 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static boolean isFibanacciNumber ( int num )
	{
		int f1 = 0, f2 = 1, f3 = 1;
		boolean isFibanacciNum = false;
		while (f3 < num)
		{
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		if (f3 == num)
		{
			isFibanacciNum = true;
		}
		return isFibanacciNum;
	}

	public static boolean isPallindromeNumber ( int num )
	{
		boolean isPalim = false;
		int revNum = 0;
		int newNum = num;

		while (newNum > 0)
		{
			int reminder = newNum % 10;
			revNum = revNum * 10 + reminder;
			newNum = newNum / 10;
		}
		if (num == revNum)
			isPalim = true;
		return isPalim;
	}

	public static int findDuplicate ( int[] arrs )
	{
		int len = arrs.length;
		for (int i = 1; i < len; i++)
		{
			arrs[i] = arrs[i] ^ arrs[i - 1] ^ i;
		}

		return arrs[len - 1];
	}

	public static void main ( String[] args )
	{
		/*
		 * System.out.println("convertToNumber : " + convertToNumber("-12345"));
		 * System.out.println("convertNumberToString : " +
		 * convertNumberToString(12345));
		 * System.out.println("pascalTriangle : \n"); pascalTriangle(10);
		 * System.out.println("Fibonacci : "); fibanacciSeries(2);
		 * System.out.println("Long Fibonacci : " + fibonacci((long) 3));
		 * System.out.println("isFibanacciNumber : " + isFibanacciNumber(89));
		 * System.out.println("isPallindromeNumber : " +
		 * isPallindromeNumber(121));
		 */

		System.out.println("Duplicate : " + findDuplicate(new int[] { 1, 2, 2, 3, 3 }));
	}

}
