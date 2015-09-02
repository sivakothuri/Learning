package producerconsumer;

//A correct implementation of a producer and consumer. 
class Q
{
	int n;
	boolean valueSet = false;

	synchronized int get()
	{
		if (!valueSet)
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int input)
	{
		if (valueSet)
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				System.out.println("InterruptedException caught");
			}
		this.n = input;
		valueSet = true;
		System.out.println("Put: " + input);
		notify();
	}
}

class Producer implements Runnable
{
	Q q;

	Producer(Q q)
	{
		this.q = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run ()
	{
		int i = 0;
		while (true)
		{
			q.put(i++);
		}
	}
}

class Consumer implements Runnable
{
	Q q;

	Consumer(Q q)
	{
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run ()
	{
		while (true)
		{
			q.get();
		}
	}
}

class ProducerConsumer
{
	public static void main(String args[])
	{
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		System.out.println(p + "" + c);
		System.out.println("Press Control-C to stop.");
	}
}
