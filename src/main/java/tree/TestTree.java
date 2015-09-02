package tree;

import java.util.ArrayList;
import java.util.Collection;

public class TestTree
{
	public static void main ( String[] args )
	{

		Collection<Data> dataItems = new ArrayList<>();
		Integer[] numbers = { 5, 3, 4, 6, 7, 2, 8, 1 };
		for (Integer number : numbers)
		{
			dataItems.add(new Data(number));
		}

		TreeConstruction construction = new TreeConstruction(dataItems);
		Node root = construction.getTree();

		/*
		 * System.out.println("Pre Order"); TreeTraversal.preOrder(rootNode);
		 * System.out.println("\nPre Order With out recursion");
		 * TreeTraversal.preOrderWithOutRecursion(rootNode);
		 */

		// System.out.println("\nIn Order");
		// TreeTraversal.inOrder(root);

		// System.out.println("\nIn Order Without Recursion");
		// TreeTraversal.inOrderWithOutRecursion(root);

		System.out.println("\nPost Order");
		TreeTraversal.postOrder(root);

		System.out.println("\nPost Order Without Recursion");
		TreeTraversal.postOrderWithOutRecursion(root);

		/*
		 * System.out.println("\nLevel Order"); TreeTraversal.levelOrder(0,
		 * rootNode);
		 */

	}
}

