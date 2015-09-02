package producerconsumer;
//An incorrect implementation of a producer and consumer. 
class IQ
{
	int n;

	synchronized int get()
	{
		System.out.println("Got: " + n);
		return n;
	}

	synchronized void put(int input)
	{
		this.n = input;
		System.out.println("Put: " + input);
	}
}

class IProducer implements Runnable
{
	IQ q;

	IProducer(IQ q)
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

class IConsumer implements Runnable
{
	IQ q;

	IConsumer(IQ q)
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

class IncorrectProducerConsumer
{
	public static void main(String args[])
	{
		IQ q = new IQ();
		IProducer producer = new IProducer(q);
		IConsumer consumer = new IConsumer(q);
		System.out.println(producer + "" + consumer);
		System.out.println("Press Control-C to stop.");
	}
}
