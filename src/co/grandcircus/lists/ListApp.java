package co.grandcircus.lists;


public class ListApp {

	public static void main(String[] args) {
		MyList list = new MyLinkedList();
		test(list);
		//list = new MyArrayList();
		//test(list);
	}
	
	private static void test(MyList list) {
		list.addAtBeginning("B");
		list.addAtBeginning("A");
		list.addAtEnd("C");
		list.addAtEnd("D");
		Node newNode = new Node();
		newNode.setData("E");
		list.insertAt(0, newNode);
		//boolean result = list.removeAt(1);
		// list.removeFromEnd();
		
		//System.out.println("Remove at result: " + result);
		System.out.println(list);
						
//		System.out.println(list.size());
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
	}

}
