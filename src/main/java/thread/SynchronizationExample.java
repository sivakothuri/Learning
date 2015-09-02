package thread;
/**
 * We can get understanding of object lock when an synchronized method or block
 * is executing, all other synchronized blocks will not be executed until the
 * lock get released on the object.
 * 
 * @author ksiva
 * 
 */
public class SynchronizationExample 
{
	public static void main(String[] args) 
	{
		PrintMessage pm = new PrintMessage();
		Thread t1 = new Thread(new Run1(pm),"First");
		Thread t2 = new Thread(new Run2(pm),"Second");
						
		t1.start();
		t2.start();		
	}
}

class Run1 implements Runnable
{
	PrintMessage pm;

	Run1(PrintMessage pm)
	{
		this.pm = pm;
	}

	@Override
	public void run()
	{
		pm.message1();		
	}
}

class Run2 implements Runnable
{
	PrintMessage pm;

	Run2(PrintMessage pm)
	{
		this.pm = pm;
	}

	@Override
	public void run()
	{
		pm.message2();
	}

}

class PrintMessage
{
	public synchronized void message1()
	{
		printMessage("printMessage.message1()");
		/*try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}*/
		printMessage("End : PrintMessage.message1()");
	}
	
	public synchronized void message2()
	{
		printMessage("printMessage.message2()");
		/*try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}*/
		printMessage("End : PrintMessage.message2()");
	}
	
	private void printMessage(String msg)
	{
		System.out.println(Thread.currentThread()+msg);
	}
}