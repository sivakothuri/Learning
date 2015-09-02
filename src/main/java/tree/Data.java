package tree;

public class Data implements Comparable<Data>
{
	private final Integer data;

	public Data ( Integer data )
	{
		this.data = data;
	}

	public Integer getData ()
	{
		return data;
	}

	@Override
	public int compareTo ( Data o )
	{
		return this.data.compareTo(o.data);
	}

	@Override
	public String toString ()
	{
		return "[" + data + "]";
	}
}
