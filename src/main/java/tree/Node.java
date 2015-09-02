package tree;

public class Node
{
	private Node left;

	private final Data data;

	private Node right;

	public Node ( Node left, Data data, Node right )
	{
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public Node left ()
	{
		return left;
	}

	public void left ( Node leftNode )
	{
		this.left = leftNode;
	}

	public Data data ()
	{
		return data;
	}

	public Node right ()
	{
		return right;
	}

	public void right ( Node rightNode )
	{
		this.right = rightNode;
	}

	@Override
	public String toString ()
	{
		return "Node [data=" + data + "]";
	}

}