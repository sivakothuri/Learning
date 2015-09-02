package thread;

public class ThreadPriorities
{

	public static void main(String[] args)
	{
		ThreadPriorities tp = new ThreadPriorities();
		tp.doTest();
	}

	private void doTest()
	{
		class TestRunnable implements Runnable
		{
			@Override
			public void run ()
			{
				for (int i = 1; i <= 5; i++)
				{
					System.out.println(Thread.currentThread() + " : " + i);
				}
			}
		}

		Thread t1 = new Thread(new TestRunnable(), "First Thread");
		t1.setPriority(1);

		Thread t2 = new Thread(new TestRunnable(), "Second Thread");
		t2.setPriority(10);

		t1.start();
		t2.start();
	}
}