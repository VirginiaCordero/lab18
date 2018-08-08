package co.grandcircus.lists;
public class MyLinkedList implements MyList {
	
	// head is the first node in the list. if null, the list is empty.
	private Node head = null;
	// for convenience, keep track of how many items are in the list
	private int length = 0;

	@Override
	public void addAtBeginning(String data) {
		// add a new node and set it as the new head
		head = new Node(data, head);
		length++;
	}
	
	@Override
	public void removeFromBeginning() {
		// find the second node and set it as the new head
		head = head.getNext();
		length--;
	}
	
	@Override
	public void addAtEnd(String data) {
		Node node = new Node(data, null);
		Node oldTail = getNodeAt(length - 1);
		oldTail.setNext(node);
		length++;
	}
		
	@Override
	public void removeFromEnd() {
		if (length < 2) {
			// The beginning is the end.
			removeFromBeginning();
		} else {
			// find the node right before the end.
			Node beforeTail = getNodeAt(length - 2);
			// set its next to null. This ends the list here.
			beforeTail.setNext(null);
			length--;
		}
	}
	
//	public void removeFromBeginning() {
//		// find the second node and set it as the new head
//		head = head.getNext();
//		length--;
//	
//	public boolean equals(Object obj) {
//	    if (obj == null) return false;
//	    if (obj == this) return true;
//	    if (!(obj instanceof ArrayTest)) return false;
//	    ArrayTest o = (ArrayTest) obj;
//	    return o.i == this.i;
//	}
	
	public boolean removeAt(int index) {
		if (index < length) {
			Node toRemove = getNodeAt(index);
			Node beforeOneToRemove = getNodeAt(index - 1);
			beforeOneToRemove.setNext(toRemove.getNext());	
			length--;
			return true;
		}
		return false;		
	}
	
	public boolean insertAt(int index, Node newNode) {
		if (index < length) {
			//cuando inserto un objeto nuevo, el primero o el antes del index tiene como next el nuevo objeto
			//donde esta el objeto nuevo, el objeto nuevo va a estar en el index que le voy a insertar
			//hacer que el antes del index tenga como next el nuevo objeto
			
			if (index == 0) {
				Node currentHead = head;
				head = newNode;
				newNode.setNext(currentHead);
				length++;				
			}
			
			Node beforeNewNode = getNodeAt(index - 1);
			Node afterNewNode = beforeNewNode.getNext();
			beforeNewNode.setNext(newNode);
			newNode.setNext(afterNewNode);	
			length++;
			return true;
		}	
		return false;	
	}
	
	
	
	
	
	@Override
	public String get(int index) {
		Node nodeAtIndex = getNodeAt(index);
		return getNodeAt(index).getData();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// start at the head
		Node node = head;
		// follow the links between nodes until it reaches the end 
		while (node != null) {
			sb.append(node.toString());
			node = node.getNext();
		}
		return sb.toString();
	}
	
	@Override
	public int size() {
		return length;
	}
	
	private Node getNodeAt(int index) {
		// start at the head
		Node node = head;
		// follow the links between nodes until it counts off the right number
		for (int i = 0; i < index; i++) {
			if (node == null) {
				// In case we run out of nodes before we get up to the desired index, return null
				return null;
			}
			node = node.getNext();
		}
		return node;
	}

}
