package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * <p>
 * From this class we will understand how sorting will work using the comparator
 * interface.
 * </p>
 * 
 * <p>
 * <b>Comparator interface.</b> Compares values of two objects. This is
 * implemented as part of the Comparator<T> interface, and the typical use is to
 * define one or more small utility classes that implement this, to pass to
 * methods such as sort() or for use by sorting data structures such as TreeMap
 * and TreeSet. You might want to create a Comparator object for the following.
 * </p>
 * <dl>
 * <dt>Multiple comparisions.</dt>
 * <dd>-To provide several different ways to sort somthing. For example, you
 * might want to sort a Person class by name, ID, age, height, ... You would
 * define a Comparator for each of these to pass to the sort() method.</dd>
 * <dt>System class.</dt>
 * <dd>- To provide comparison methods for classes that you have no control
 * over. For example, you could define a Comparator for Strings that compared
 * them by length.</dd>
 * <dt>Strategy pattern.</dt>
 * <dd>- To implement a Strategey pattern, which is a situation where you want
 * to represent an algorithm as an object that you can pass as a parameter, save
 * in a data structure, etc.</dd>
 * </dl>
 * 
 * <p>
 * If your class objects have one natural sorting order, you may not need this.
 * </p>
 * 
 * @author ksiva
 * 
 */
public class ComparatorTest
{
	public static void main(String[] args)
	{
		new ComparatorTest().go();
	}

	public void go()
	{
		ArrayList<Order> orders = new ArrayList<>();

		Order o1 = new Order(700, 2000, "Banana");
		Order o2 = new Order(200, 9000, "Apple");
		Order o3 = new Order(700, 6000, "Mango");
		Order o4 = new Order(300, 8000, "Orange");
		Order o5 = new Order(500, 4000, "Grapes");

		orders.add(o1);
		orders.add(o2);
		orders.add(o3);
		orders.add(o4);
		orders.add(o5);

		System.out.println("Before Sorting");
		System.out.println(orders);

		System.out.println("After Quantity Sort");
		Collections.sort(orders, new QtyComparator());
		System.out.println(orders);

		
		System.out.println("After Price Sort");
		//To reverse the order we need to use 'Collections.reverseOrder'
		Comparator<Order> priceComparator = Collections.reverseOrder(new PriceComparator());
		Collections.sort(orders, priceComparator);
		System.out.println(orders);
	}
}

class Order
{
	final int qty;
	final int price;
	final String name;

	Order(int qty, int price, String name)
	{
		this.qty = qty;
		this.price = price;
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Qty : " + qty + " Price : " + price + " Name : " + name + "\n";
	}
}

class QtyComparator implements Comparator<Order>
{
	@Override
	public int compare(Order o1, Order o2)
	{
		// To sort objects in the ascending order.(o1-o2)
		return (o1.qty) - (o2.qty);
	}
}

class PriceComparator implements Comparator<Order>
{
	@Override
	public int compare(Order o1, Order o2)
	{
		// To sort objects in the descending order.(o2-o1)
		return (o2.price) - (o1.price);
	}
}