import java.util.*;

public class TreeOrder {
	
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 3;
		Node n4 = new Node();
		n4.data = 4;
		Node n5 = new Node();
		n5.data = 5;
		Node n6 = new Node();
		n6.data = 6;

		n3.right = n4;
		n5.left = n3;
		n5.right = n6;
		n2.right = n5;
		n1.right = n2;

		Node root = n1;

		preOrder(root);
		System.out.println(" ");
		postOrder(root);
		System.out.println(" ");
		inOrder(root);
		System.out.println(" ");
		levelOrder(root);
	}

	public static void preOrder(Node root) {
		if(root == null) {
			return;
		}

		System.out.print(root.data + " ");

		if(root.left != null) {
			preOrder(root.left);
		}

		if(root.right != null) {
			preOrder(root.right);
		}
	}

	public static void postOrder(Node root) {
		if(root == null) {
			return;
		}

		if(root.left != null) {
			postOrder(root.left);
		}

		if(root.right != null) {
			postOrder(root.right);
		}

		System.out.print(root.data + " ");
	}

	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}

		if(root.left != null) {
			inOrder(root.left);
		}

		System.out.print(root.data + " ");

		if(root.right != null) {
			inOrder(root.right);
		}
	}

	public static void levelOrder(Node root) {
		if(root == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		StringBuilder sb = new StringBuilder();
		q.add(root);

		while(!q.isEmpty()) {
			Node temp = q.poll();
			sb.append(String.valueOf(temp.data)).append(" ");

			if(temp.left != null) {
				q.add(temp.left);
			}

			if(temp.right != null) {
				q.add(temp.right);
			}
		}

		System.out.println(sb.toString());
	}
}

class Node {
	int data;
	Node left;
	Node right;
}