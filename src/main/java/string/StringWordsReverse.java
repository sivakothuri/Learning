package string;
import java.util.Stack;


public class StringWordsReverse
{
	public static void main(String[] args)
	{
		char[] st = "siva phani kumar".toCharArray(); 
		System.out.println("Before :"+ new String(st));
		reverseWords(st);
		System.out.print("After :");
		reversePrint(st);
	}
	
	private static void reverseWords(char[] st)
	{
		int start = 0;
		for(int i=0;i<st.length;i++)
		{
			if(st[i]==' ')
			{
				reverse(st,start,i-1);
				start = i+1;
			}
			
			if(i==st.length-1)
			{
				reverse(st,start,i);
				start = i+1;
			}
			
		}
	}
	
	private static void reverse(char[] st,int begin,int end)
	{
		char temp;
		//int begin = 0, len = st.length-1;
		while(begin < end)
		{
			temp = st[begin];
			st[begin++] = st[end];
			st[end--] = temp;
		}
		System.out.println(st);
	}
	
	private static void reversePrint(char[] st)
	{
		int count = st.length;
		while(count>0)
		{
			System.out.print(st[--count]);
		}
		
	}
	
	public static void main2(String[] args)
	{
		String a = "Neil Peart rocks YYZ";
		Stack<String> stack = new Stack<>();
		String[] temp;
		String delimiter = " ";
		// given string will be split by the argument delimiter provided.
		temp = a.split(delimiter);
		// push substring to stack
		for (int i = 0; i < temp.length; i++)
		{
			stack.push(temp[i]);
		}
		System.out.println("\nOriginal string: " + a);
		System.out.print("Reverse word string: ");
		while (!stack.empty())
		{
			System.out.print(stack.pop());
			System.out.print(" ");
		}
		System.out.println("\n");
	}
	
	 public static  void main3(String[] args)
	 {
		    String s = "Neil Peart rocks YYZ";
		    String[] str =s.split(" ");
		    StringBuffer buffer = new StringBuffer();
		    for(int i=str.length-1;i>=0;i--)
		    {
		        buffer.append(str[i]);
		        buffer.append(" ");
		    }
		    System.out.println("\nOriginal string: " + s);
		    System.out.println("Reverse word string:"+buffer.toString());
		    }
}

