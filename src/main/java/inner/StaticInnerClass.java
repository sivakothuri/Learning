package inner;

public class StaticInnerClass
{
	public static void main(String[] args)
	{
		Test test = new StaticInnerClass.Test(1);
		System.out.println(test.getCounter());
	}
	
	static class Test
	{
		private int counter;

		Test(int counter)
		{
			this.counter = counter;
		}
		
		public int getCounter()
		{
			return counter;
		}
	}
}

