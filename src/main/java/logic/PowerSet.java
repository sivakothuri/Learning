package logic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PowerSet
{

	public final static Set<Set<Integer>> powerSet ( Set<Integer> set )
	{
		Set<Set<Integer>> powerSet = new HashSet<>();
		powerSet.add(set);
		powerSet(set, powerSet, set.iterator());
		return powerSet;
	}

	public final static void powerSet ( Set<Integer> set, Set<Set<Integer>> powerSet, Iterator<Integer> iterator )
	{
		if (iterator.hasNext())
		{
			Integer exlude = iterator.next();
			Set<Integer> powThis = new HashSet<>();
			powThis.addAll(set);
			powThis.remove(exlude);

			powerSet(powThis, powerSet, powThis.iterator());
			powerSet(set, powerSet, iterator);
		}
	}

	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		System.out.println("PowerSet.main() " + powerSet(set).toString());

	}
}
