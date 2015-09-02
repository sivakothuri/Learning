package Numaric;

public class RemoveTrailingZeros {

	public static void main(String[] args) {
		
		System.out.println("10.21 : "+ fmt(10.21));
		System.out.println("10.21000 : "+fmt(10.21000));
		System.out.println("10.0002 : "+ fmt(10.0002));
		System.out.println("10.0000 : "+ fmt(10.0000));
		System.out.println("10 : "+fmt(10));
		
		
	}
	
	public static String fmt(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}
}
