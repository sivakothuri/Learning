package searialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <p>
 * When we serialize a class all the sub classes will automatically
 * serializable.
 * </p>
 * 
 * <p>
 * In the below example the Employee object has a reference to the Department
 * object , then Department also need to implement {@link Serializable} otherwise it
 * throws {@link java.io.NotSerializableException}.
 * </p>
 * 
 * <p>
 * If we define a property as transient , then while Serializing the property
 * will not get saved. And while retrieving it will give null/ default value
 * depending up on the type of the property.
 * </p>
 * 
 * @author ksiva
 * 
 */
public class SerializationTest
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		SerializationTest st = new SerializationTest();
		Employee emp= new Employee(10, "siva", new Department("IT"));
		
		st.persistEmployeeObject(emp);
		st.readEmployeeObject();
	}
	
	private void persistEmployeeObject(Employee emp) throws IOException
	{
		try (FileOutputStream fout = new FileOutputStream("emp.ser"))
		{
			try (ObjectOutputStream out = new ObjectOutputStream(fout))
			{
				out.writeObject(emp);
			}
		}
	}
	
	private void readEmployeeObject()  throws IOException, ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("emp.ser");
		try (ObjectInputStream in = new ObjectInputStream(fin))
		{
			Employee emp = (Employee) in.readObject();

			System.out.println("Employee Id : " + emp.getId() + "\nEmployee Name : " + emp.getName());
			System.out.println("Department Name : " + emp.getDepartment().getName());
		}
	}
}

class Employee implements Serializable
{
	private static final long serialVersionUID = -2413717913404265090L;
	private final int empId;
	private final transient String empName;
	private final Department department;
	
	public Employee(int empId, String empName , Department department)
	{
		this.empId = empId;
		this.empName = empName;
		this.department = department;
	}
	
	public int getId()
	{
		return empId;
	}
	
	public String getName()
	{
		return empName;
	}
	
	public Department getDepartment()
	{
		return department;
	}
}

class Department implements Serializable
{
	private static final long serialVersionUID = 8055878616982095510L;
	private String dept;

	public Department(String dept)
	{
		this.dept = dept;
	}

	public String getName()
	{
		return dept;
	}
}
