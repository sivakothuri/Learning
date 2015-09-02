package collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>
 * From this class we will understand how sorting will work using the comparable
 * interface.
 * </p>
 * 
 * <p>
 * <b>{@link Comparable}</b> Compares values and returns an int which tells
 * if the values compare less than, equal, or greater than. If your class
 * objects have a natural order, implement the Comparable<T> interface and
 * define this method. All Java classes that have a natural ordering implement
 * this (String, Double, BigInteger, ...).
 * </p>
 * 
 * @author ksiva
 * 
 */
public class ComparableTest
{
	public static void main(String[] args)
	{
		ComparableTest test = new ComparableTest();
		test.go();
	}
	
	public void go()
	{
		ArrayList<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee(1, "siva");
		Employee e2 = new Employee(2, "phani");
		Employee e3 = new Employee(3, "kumar");
		Employee e4 = new Employee(0, "kothuri");
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println("Before Sorting");
		System.out.println( employees );
		
		Collections.sort(employees);
		System.out.println("After Sorting");
		System.out.println( employees );
		
		
	}
}

/**
 * <p>
 * The Comparable interface is basically used to sort the given collection of
 * objects. And has a method compareTo ,which will be used to compare the
 * current object with the given object.
 * </p>
 * 
 * <p>
 * But there are some limitations with it.
 * <ul>
 * <li>We can sort with only one field.</li>
 * <li>It can not be useful if the class we are referring is from a jar file.</li>
 * </ul>
 * </p>
 * 
 * @author ksiva
 * 
 */

class Person
{
	final int id;

	final String name;

	Person ( int id, String name )
	{
		this.id = id;
		this.name = name;
	}
}

class Employee extends Person implements Comparable<Person>
{
	
	Employee(int id,String name)
	{
		super(id, name);
	}

	@Override
	public int compareTo ( Person o )
	{
		int result =0;
		
		//To compare objects using name 
		result =  name.compareTo(o.name);
		//To compare object using id
		//result = id - o.id;
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Id : "+id+" Name : "+name+"\n";
	}
}