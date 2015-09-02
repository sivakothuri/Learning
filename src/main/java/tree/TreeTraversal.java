package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal
{
	public static void preOrder ( Node root )
	{
		if (root == null)
		{
			return;
		}
		System.out.print(root.data());
		preOrder(root.left());
		preOrder(root.right());
	}

	public static void preOrderMyOwnVersion ( Node root )
	{
		Stack<Node> stack = new Stack<>();
		Node u = root;
		while (u != null)
		{
			// process u;
			System.out.print(u.data());

			Node left = u.left();
			if (left != null)
			{
				stack.push(u);
				u = left;
				continue;
			}
			if (u.right() != null)
			{
				u = u.right();
				continue;
			}

			Node temp = null;
			if (!stack.isEmpty())
			{
				temp = stack.pop();
			}
			while (temp != null && temp.right() == null)
			{
				if (!stack.isEmpty())
				{
					temp = stack.pop();
				}
			}

			if (temp != null)
			{
				u = temp.right();
			}
			else
			{
				u = null;
			}
		}
	}

	public static void preOrderWithOutRecursion ( Node root )
	{
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty())
		{
			Node node = stack.pop();
			System.out.print(node.data());
			if (node.right() != null)
			{
				stack.push(node.right());
			}
			if (node.left() != null)
			{
				stack.push(node.left());
			}
		}
	}

	public static void inOrder ( Node root )
	{
		if (root == null)
		{
			return;
		}
		inOrder(root.left());
		System.out.print(root.data());
		inOrder(root.right());
	}

	public static void inOrderWithOutRecursion ( Node root )
	{
		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (!stack.isEmpty() || current != null)
		{
			if (current != null)
			{
				stack.push(current);
				current = current.left();
			}
			else
			{
				current = stack.pop();
				System.out.print(current.data());
				current = current.right();
			}
		}
	}

	public static void postOrder ( Node root )
	{
		if (root == null)
		{
			return;
		}
		postOrder(root.left());
		postOrder(root.right());
		System.out.print(root.data());
	}

	public static void postOrderWithOutRecursion ( Node root )
	{
		Stack<Node> stack = new Stack<>();
		Node current = root;
		stack.push(root);
		while (!stack.isEmpty())
		{
			Node right = current.right();
			if (right != null)
			{
				stack.push(current);
				current = right;
			}

			Node left = current.left();
			if (left != null)
			{
				stack.push(left);
				current = left;
			}
			if (left == null && right == null)
			{
				System.out.println(current.data());
			}
			else if (!stack.isEmpty())
			{
				Node temp = stack.pop();
				System.out.println(temp.data());
			}


			// System.out.println(current.data());
		}

	}

	public static void levelOrder ( int level, Node... root )
	{
		if (root.length == 0)
		{
			return;
		}

		List<Node> childs = new ArrayList<>();
		System.out.print("\n Level " + level + " : ");
		for (Node node : root)
		{
			System.out.print(node.data() + " ");

			Node left = node.left();
			Node right = node.right();

			boolean isLeaf = true;
			if (left != null)
			{
				childs.add(left);
				isLeaf = false;
			}
			if (right != null)
			{
				childs.add(right);
				isLeaf = false;
			}
			
			if (isLeaf)
			{
				System.out.print("is Leaf ");
			}

		}
		levelOrder(++level, childs.toArray(new Node[childs.size()]));
	}

	public static void breadthFirstTraversal ( Node root )
	{
		Queue<Node> q = new LinkedList<>();
		if (root != null)
		{
			q.add(root);
		}
		while (!q.isEmpty())
		{
			Node u = q.remove();
			System.out.print(u.data());

			Node left = u.left();
			Node right = u.right();

			if (left != null)
			{
				q.add(left);
			}
			if (right != null)
			{
				q.add(right);
			}

			if (left == null && right == null)
			{
				System.out.println("is Leaf");
			}
		}

	}
}
