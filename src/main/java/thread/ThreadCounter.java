package thread;

public class ThreadCounter
{
	public static void main(String[] args) throws InterruptedException
	{
		Counter counter = new Counter();
		System.out.println("Initial Counter Value : "+counter.getValue());
		
		Thread t1= new  Thread(new IncrementCounter(counter));
		Thread t2 = new Thread(new DecrementCounter(counter));
		
		t1.start();
		t2.start();
		
		// t1.join();
		t2.join();
		
		System.out.println("Counter Value After Thread Execution : "+counter.getValue());
	}
	
	
}

class IncrementCounter implements Runnable
{
	Counter counter;
	IncrementCounter(Counter counter)
	{
		this.counter = counter;
	}
	
	@Override
	public void run ()
	{
		for(int i=0;i<100;i++)
		{
			counter.increment();
		}
	}
}

class DecrementCounter implements Runnable
{
	Counter counter;
	DecrementCounter(Counter counter)
	{
		this.counter = counter;
	}
	
	@Override
	public void run ()
	{
		for(int i=0;i<100;i++)
		{
			counter.decrement();
		}
	}
}

class Counter
{
	private int c;
	
	public void increment()
	{
		c++;
	}
	
	public void decrement()
	{
		c--;
	}
	
	public int getValue()
	{
		return c;
	}
}
