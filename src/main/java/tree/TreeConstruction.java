package tree;

import java.util.Collection;

public class TreeConstruction
{
	private final Collection<Data> dataItems;

	private Node rootNode;

	public TreeConstruction ( Collection<Data> numbers )
	{
		this.dataItems = numbers;
	}

	private void constructTree ()
	{
		for (Data number : dataItems)
		{
			if (rootNode == null)
			{
				rootNode = new Node(null, number, null);
				continue;
			}
			createTreeItem(rootNode, number);

		}
	}

	private Node createTreeItem ( Node currentNode, Data number )
	{
		int result = number.compareTo(currentNode.data());
		if (result < 0)
		{
			Node leftNode = currentNode.left();
			if (leftNode == null)
			{
				leftNode = new Node(null, number, null);
				currentNode.left(leftNode);
				return leftNode;
			}
			return createTreeItem(leftNode, number);
		}
		else if (result > 0)
		{
			Node rightNode = currentNode.right();
			if (rightNode == null)
			{
				rightNode = new Node(null, number, null);
				currentNode.right(rightNode);
				return rightNode;
			}
			return createTreeItem(rightNode, number);
		}
		return currentNode;
	}

	public Node getTree ()
	{
		if (rootNode == null)
		{
			constructTree();
		}
		return rootNode;
	}
}
