package string;

public class SubString
{

	public static void main(String[] args)
	{
		String s1= new String("siva phani kumar");
		String s2 = s1.substring(5);
		String s3 = new String(s2);
		String s4 = s1.substring(0, s1.length());
		
		System.out.println(s1== s2);
		System.out.println(s2 == s3);
		System.out.println(s1 == s4);
		
		final char[] a1 ="abc".toCharArray();
		final char[] a2 = a1;
		
		Test2 t2 =  new Test2(a2);
		
		a2[1] = 'z';
		
		printCharArray(a1);
		t2.print();
	}
	
	static void printCharArray(char[] arr )
	{
		 for(int i=0;i<arr.length;i++)
		 {
			 System.out.print(arr[i]);
		 }
		 System.out.println();
	}
}

class Test2
{
	final char[] arr;
	Test2(char[] arr)
	{
		this.arr = arr;
	}
	
	public void print()
	{
		SubString.printCharArray(this.arr);
	}
}

