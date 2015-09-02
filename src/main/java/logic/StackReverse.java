package logic;

import java.util.Stack;

public class StackReverse
{

	static Stack<Integer> stack = new Stack<>();

	public static void main ( String[] args )
	{
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		reverseStack(stack);
		System.out.println(stack);

	}

	public static void appendStack ( Stack<Integer> s, Integer a )
	{
		if (s.isEmpty())
		{
			s.push(a);
		}
		else
		{
			Integer o = s.pop();
			appendStack(s, a);
			s.push(o);
		}
	}

	static void reverseStack ( Stack<Integer> lStack )
	{
		Integer temp = lStack.pop();
		if (!lStack.isEmpty())
		{
			reverseStack(lStack);
		}
		appendStack(lStack, temp);
	}
}
