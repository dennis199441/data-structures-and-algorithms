import java.util.*;

public class BinarySearchTree {
	
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 3;
		Node n4 = new Node();
		n4.data = 4;
		Node n7 = new Node();
		n7.data = 7;

		n2.left = n1;
		n2.right = n3;
		n4.left = n2;
		n4.right = n7;

		Node root = n4;
		levelOrder(root);

		System.out.println("==================");
		root = Insert(root, 6);
		levelOrder(root);
	}

	public static Node Insert(Node root, int value) {
		if(root == null) {
			Node n = new Node();
			n.data = value;
			return n;
		} else if(root.data < value) {
			root.right = Insert(root.right, value);
		} else if(root.data > value) {
			root.left = Insert(root.left, value);
		}

		return root;
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

	public static Node lowestCommonAncestor(Node root, int v1, int v2) {
		if(v1 < root.data && v2 < root.data) {
			return lowestCommonAncestor(root.left, v1, v2);
		} 

		if (v1 > root.data && v2 > root.data){
			return lowestCommonAncestor(root.right, v1, v2);
		}     

		return root;
	}
}

class Node {
	int data;
	Node left;
	Node right;
}
