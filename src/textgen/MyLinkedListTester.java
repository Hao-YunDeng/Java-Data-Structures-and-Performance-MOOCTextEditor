/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		System.out.println("Before removing: "+ list1);
		int a = list1.remove(0);
		System.out.println("after removing data at index 0: "+ list1);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		System.out.println("Before adding: "+ list1);
		boolean addEnd = list1.add(99);
		System.out.println("after adding at end: "+ list1);
		assertEquals("add: Check return is true", true, addEnd);
		assertEquals("add: Check last element", (Integer)99, list1.get(3));
		assertEquals("add: Check size", 4, list1.size());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("size: check emptyList has size 0", 0, emptyList.size());
		assertEquals("size: check shortList has size 2", 2, shortList.size());
		emptyList.add(1);
		assertEquals("size: check emptyList has size 1 after adding one element", 
				1, emptyList.size());		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		int preSize = list1.size();
		System.out.println("Before adding: "+ list1);
		list1.add(2, 100);
		System.out.println("after adding 100 at index 2: "+ list1);
		
		assertEquals("addAtIndex: Check element added", (Integer)100, list1.get(2));
		assertEquals("addAtIndex: Check element before", (Integer)21, list1.get(1));
		assertEquals("addAtIndex: Check element after", (Integer)42, list1.get(3));
		assertEquals("addAtSize: Check size updated", preSize + 1, list1.size());	
		
		try {
			list1.add(-1, 404);
			fail("Check out of bounds: negative index");
		}
		catch (IndexOutOfBoundsException e) {		
		}
		try {
			list1.add(list1.size()+1, 404);
			fail("Check out of bounds: index larger than size");
		}
		catch (IndexOutOfBoundsException e) {			
		}	
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			list1.set(-1, 404);
			fail("Check out of bounds: negative index");
		}
		catch (IndexOutOfBoundsException e) {			
		}
		try {
			list1.set(list1.size()+1, 404);
			fail("Check out of bounds: index larger than size");
		}
		catch (IndexOutOfBoundsException e) {			
		}	
		try {
			list1.set(2, null);
			fail("Check null");
		}
		catch (NullPointerException e) {
		}
		
		System.out.println("Before setting: "+ list1);
		int oldData = list1.set(0, 1);
		System.out.println("after setting: "+ list1);
		assertEquals("set: check list1 idx 0 has old value of 65", 65, oldData);
		assertEquals("set: check list1 idx 0 has new value of 1", (Integer)1, list1.get(0));
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
