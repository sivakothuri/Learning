package collections;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * <b>The difference between HashMap and HashTable are</b>
 * 
 * <p>
 * Both collections implements Map. Both collections store value as key-value
 * pairs. The key differences between the two are
 * </p>
 * 
 * <ol>
 * <li>
 * Hashmap is not synchronized in nature but hshtable is.
 * <li>
 * </li>
 * Another difference is that iterator in the HashMap is fail-safe while the
 * enumerator for the Hashtable isn't. Fail-safe - if the Hashtable is
 * structurally modified at any time after the iterator is created, in any way
 * except through the iterator's own remove method, the iterator will throw a
 * ConcurrentModificationException </li>
 * <li>
 * HashMap permits null values and only one null key, while Hashtable doesn't
 * allow key or value as null.</li>
 * </ol>
 * 
 * @author ksiva
 * 
 */
public class HashTableAndHashMap
{

	public static void main(String[] args)
	{
		HashTableAndHashMap htm = new HashTableAndHashMap();
		htm.hashTable();
		htm.hashMap();
	}

	private void hashTable()
	{

		Hashtable<String, String> ht = new Hashtable<>();
		ht.put("first", "one");
		ht.put("first", "one");
		System.out.println("Hash Table :" + ht);

		// It does not allows null either key or value
		try
		{
			ht.put(null, "Value");
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			ht.put("key", null);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void hashMap()
	{
		// HashMap permits null values and only one null key
		// Even if we insert multiple null in key it will overwrites it.
		HashMap<String, String> hm = new HashMap<>();
		hm.put(null, null);
		hm.put(null, null);
		hm.put("first", "one");
		hm.put("second", "two");
		hm.put("third", null);
		hm.put("fourth", null);

		System.out.println("Hash Map :" + hm);
	}

}
