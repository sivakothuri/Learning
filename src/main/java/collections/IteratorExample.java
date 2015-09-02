package collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator interface is extended from Enumeration and has an extra method
 * called 'remove()'. We can do manipulation while it is iteration over
 * collection.And this is fail fast,when we are iterating over it if some one
 * else is modified then it throws concurrent modification exception.
 * 
 * @author ksiva
 * 
 */
public class IteratorExample
{
	public static void main(String[] args)
	{
		ArrayList<String> names = new ArrayList<>();
		names.add("siva");
		names.add("phani");
		names.add("kumar");
		names.add("kothuri");
		System.out.println("Before iteration :" + names);
		
		Iterator<String> nameIterator = names.iterator();

		while (nameIterator.hasNext())
		{
			String name = nameIterator.next();
			if (name.equals("phani"))
			{
				nameIterator.remove();
			}
			System.out.println(name);
		}
		System.out.println("After iteration :" + names);

	}
}
