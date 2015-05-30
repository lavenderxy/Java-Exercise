package studio9;
import studio9.List;

public class DoublyLinkedListOfInts implements List<Integer> {
	
	private ListNode head;
	private ListNode tail;

	
	public DoublyLinkedListOfInts(){
		head = new ListNode();
		tail = new ListNode();
	}
	
	public void addFirst(Integer x) {		
		ListNode p = new ListNode(x);
		p.next=head.next;
		head.next=p;
	}


	public void addLast(Integer x) {	
		ListNode p = new ListNode(x);
		
		ListNode q = head.next;
		while (q.next !=null){
			q=q.next;
		}
		q.next=p;
	}

	public boolean remove(Integer x) {
		
		return false;
	}

	public Integer get(Integer i) throws IndexOutOfBoundsException {
		
		return null;
	}

	
	public Integer size() {
		
		return null;
	}


	public boolean isEmpty() {
		
		return false;
	}
	
}
