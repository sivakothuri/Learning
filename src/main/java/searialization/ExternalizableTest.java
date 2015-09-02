package searialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * <p>
 * Externalize interface extends Serializable interface.Only the identity of the
 * class of an Externalizable instance is written in the serialization stream
 * and it is the responsibility of the class to save and restore the contents of
 * its instances.
 * </p>
 * 
 * <p>
 * Unlike serialization(will store all the properties of class and associated
 * objects also), here we have to specify which properties has to be saved. And
 * while Retrieving also we need to read in the follow the same order in which
 * we have saved it.
 * </p>
 * 
 * <p>
 * When an Externalizable object is reconstructed, an instance is created using
 * the public no-arg constructor, then the readExternal method called. So every
 * class which is implementing must have public no-arg constructor.
 * </p>
 * 
 * @author ksiva
 * 
 */
public class ExternalizableTest
{
	public static void main(String args[])
	{

		// create a Car object
		Car car = new Car("Mitsubishi", 2009);
		Car newCar = null;

		// serialize the car
		try
		{
			FileOutputStream fo = new FileOutputStream("tmp");
			try (ObjectOutputStream so = new ObjectOutputStream(fo))
			{
				so.writeObject(car);
				so.flush();
			}
		} catch (Exception e)
		{
			System.out.println(e);
			System.exit(1);
		}

		// de-serialize the Car
		try
		{
			FileInputStream fi = new FileInputStream("tmp");
			try (ObjectInputStream si = new ObjectInputStream(fi))
			{
				newCar = (Car) si.readObject();
			}
		} catch (Exception e)
		{
			System.out.println(e);
			System.exit(1);
		}

		/*
		 * Print out the original and new car information
		 */
		System.out.println("The original car is ");
		System.out.println(car);
		System.out.println("The new car is ");
		System.out.println(newCar);
	}
}

class Automobile implements Externalizable
{

	/*
	 * Instead of making thse members private and adding setter and getter
	 * methods, I am just giving default access specifier. You can make them
	 * private members and add setters and getters.
	 */
	String regNo;
	String mileage;

	/*
	 * A public no-arg constructor
	 */
	public Automobile()
	{
	}

	Automobile(String rn, String m)
	{
		regNo = rn;
		mileage = m;
	}

	@Override
	public void writeExternal ( ObjectOutput out ) throws IOException
	{
		out.writeObject(regNo);
		out.writeObject(mileage);
	}

	@Override
	public void readExternal ( ObjectInput in ) throws IOException,
			ClassNotFoundException
	{
		regNo = (String) in.readObject();
		mileage = (String) in.readObject();
	}

}

class Car extends Automobile
{

	String name;
	int year;

	/*
	 * mandatory public no-arg constructor
	 */
	public Car()
	{
		super();
	}

	Car(String n, int y)
	{
		super("AP 09 BY 2371","60 KMPL");
		name = n;
		year = y;
	}

	/**
	 * Mandatory writeExernal method.
	 */
	@Override
	public void writeExternal ( ObjectOutput out ) throws IOException
	{
		/*
		 * Since the superclass does not implement the Serializable interface we
		 * explicitly do the saving.
		 */
		super.writeExternal(out);

		// Now the subclass fields
		out.writeObject(name);
		out.writeInt(year);
	}

	/**
	 * Mandatory readExternal method.
	 */
	@Override
	public void readExternal ( ObjectInput in ) throws IOException,
			ClassNotFoundException
	{
		super.readExternal(in);

		// Now the subclass fields
		name = (String) in.readObject();
		year = in.readInt();
	}

	/**
	 * Prints out the fields. used for testing!
	 */
	@Override
	public String toString ()
	{
		return ("Reg No: " + regNo + "\n" + "Mileage: " + mileage +"\n"+ "Name: "
				+ name + "\n" + "Year: " + year);
	}
}
