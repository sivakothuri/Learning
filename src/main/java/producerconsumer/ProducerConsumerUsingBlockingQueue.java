package producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue
{
	public static void main(String[] args)
	{
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1);
		Producer2 p = new Producer2(bq);
		Consumer2 c = new Consumer2(bq);
		new Thread(p).start();
		new Thread(c).start();
	}

}

class Consumer2 implements Runnable
{
	BlockingQueue<Integer> bq;

	public Consumer2(BlockingQueue<Integer> bq)
	{
		this.bq = bq;
	}

	@Override
	public void run()
	{

		while (true)
		{
			try
			{
				System.out.println("Got: " + bq.take());
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}
}

class Producer2 implements Runnable
{
	BlockingQueue<Integer> bq;

	public Producer2(BlockingQueue<Integer> bq)
	{
		this.bq = bq;
	}

	@Override
	public void run()
	{
		try
		{
			int i = 0;
			while (true)
			{
				bq.put(i++);
				System.out.println("Put: " + i);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}