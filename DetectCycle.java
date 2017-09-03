import java.util.*;

public class DetectCycle {
	
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 3;
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n2;

		Node head = n1; // LinkedList that contains cycle

		System.out.println(hasCycle(head));

	}

	public static boolean hasCycle(Node head) {
		if(head == null || head.next == null) {
			return false;
		}

		Node headA = head;
		Node headB = head.next;

		while(headA != headB) {
			if(headB.next == null) {
				return false;
			} else {
				headA = headA.next;
				headB = headB.next.next;
			}
		}

		return true;
	}

}

class Node {
	int data;
	Node next;
}