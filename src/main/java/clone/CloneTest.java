package clone;

/**
 * <p>
 * This example demonstrates how to clone an object.
 * </p>
 * <p>
 * If we want to clone an object the class must implement the {@link Cloneable}
 * interface. After that we have to over right the clone method of it. <br/>
 * Cloning an object with out implementing {@link Cloneable} interface with
 * throws {@link CloneNotSupportedException}
 * </p>
 * 
 * <p>
 * Cloning can be of two types
 * </p>
 * <dl>
 * <dt>Shallow Copy</dt>
 * <dd>If we clone an object it will clone only the primitive data types of
 * class, all other objects will copy only the references.</dd>
 * <dt>Deep Copy</dt>
 * <dd>Cloning the entire object hierarchy is called as a Deep Copy.<br/>
 * To achieve this all the object reference classes also has to implement the
 * {@link Cloneable} interface.</dd>
 * </dl>
 * 
 */
public class CloneTest
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Employee emp = new Employee("Amardeep", 50000);
		emp.setDepartment(new Department("IT"));
		Employee emp1 = (Employee)emp.clone();
		emp1.raiseSalary(20);
		emp1.updateDepartment();
		System.out.println("Employee=" + emp);
		System.out.println("copy=" + emp1);
	}
}

class Employee implements Cloneable
{
	private String name;
	private double salary;
	private Department dept;
	
	public Employee(String str, double dou)
	{
		name = str;
		salary = dou;
	}

	public void setDepartment(Department dept)
	{
		this.dept = dept;
	}
	
	public void updateDepartment()
	{
		dept.appendNew();
	}
	
	@Override
	public Object clone () throws CloneNotSupportedException
	{
		Employee cloned = (Employee)super.clone();
		cloned.dept = (Department) dept.clone();
		return cloned;
	}

	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public String toString ()
	{
		return "[name=" + name + ",salary=" + salary + "]"
				+ ((dept != null) ? dept.toString() : "");
	}
}

class Department implements Cloneable
{
	String dept;
	public Department(String dept)
	{
		this.dept = dept;
	}
	
	public void appendNew()
	{
		dept = dept + "_NEW"; 
	}
	
	@Override
	public Object clone () throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	@Override
	public String toString ()
	{
		return "[dept = " + dept + "]";
	}
}
