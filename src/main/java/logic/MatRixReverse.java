package logic;

public class MatRixReverse
{
	public static void main(String[] args)
	{
		int m = 2;
		int n = 4;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(i+" "+j);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		System.out.print("\n Transformed One : \n");
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				System.out.print(i+" "+j);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
	}
}
