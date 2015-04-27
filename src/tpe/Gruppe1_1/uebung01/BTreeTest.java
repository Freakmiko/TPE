package tpe.Gruppe1_1.uebung01;

import static org.junit.Assert.*;

import org.junit.*;

public class BTreeTest {

	// Empty Tree
	private BTree emptyTree = new BTreeImplementation(2);
	// Tree with 2 Nodes
	private BTree smallTree = new BTreeImplementation(2);
	// Tree with 3 Nodes
	private BTree bigTree = new BTreeImplementation(2);
	// Tree for testing cloneDeep und addAll
	private BTree otherTree = new BTreeImplementation(2);

	private BTree stringTree = new BTreeImplementation(2);

	@Before
	public void beforeTest() throws Exception {
		// Inserts the elements into "SmallTree".
		smallTree.insert(2);
		smallTree.insert(4);
		smallTree.insert(6);
		smallTree.insert(8);
		smallTree.insert(12);
		smallTree.insert(14);
		smallTree.insert(16);
		smallTree.insert(18);
		// Inserts the elements into "BigTree".
		bigTree.insert(10);
		bigTree.insert(20);
		bigTree.insert(25);
		bigTree.insert(30);
		bigTree.insert(40);
		bigTree.insert(50);
		bigTree.insert(60);
		bigTree.insert(70);
		bigTree.insert(75);
		bigTree.insert(80);
		bigTree.insert(90);
		bigTree.insert(100);
		// Inserts the elements into "OtherTree".
		otherTree.insert(5);
		otherTree.insert(15);
		otherTree.insert(35);


		stringTree.insert('A');
		stringTree.insert('B');
		stringTree.insert('G');
		stringTree.insert('J');
		stringTree.insert('Z');
		stringTree.insert('X');
		stringTree.insert('O');

	}

	@Test
	public void containsTest() throws Exception {
		assertEquals(false, emptyTree.contains(1));
		assertEquals(false, smallTree.contains(1));
		assertEquals(true, smallTree.contains(2));
		assertEquals(false, bigTree.contains(5));
		assertEquals(true, bigTree.contains(20));
		assertEquals(false, otherTree.contains(2));
		assertEquals(true, otherTree.contains(5));
		assertEquals(true, stringTree.contains('Z'));
		assertEquals(false, stringTree.contains('R'));
	}

	@Test
	public void sizeTest() throws Exception{
		assertEquals(0, emptyTree.size());
		assertEquals(8, smallTree.size());
		assertEquals(12, bigTree.size());
		assertEquals(3, otherTree.size());
		assertEquals(7, stringTree.size());
	}

	@Test
	public void heightTest() throws Exception {
		assertEquals(0, emptyTree.height());
		assertEquals(2, smallTree.height());
		assertEquals(2, bigTree.height());
		assertEquals(1, otherTree.height());
		assertEquals(2, stringTree.height());
	}

	@Test
	public void getMaxTest() throws Exception {
		assertEquals(-1, emptyTree.getMax());
		assertEquals(18, smallTree.getMax());
		assertEquals(100, bigTree.getMax());
		assertEquals(35, otherTree.getMax());
		assertEquals('Z', stringTree.getMax());
	}

	@Test
	public void getMinTest() throws Exception{
		assertEquals(-1, emptyTree.getMin());
		assertEquals(2, smallTree.getMin());
		assertEquals(10, bigTree.getMin());
		assertEquals(5, otherTree.getMin());
		assertEquals('A', stringTree.getMin());
	}

	@Test
	public void isEmptyTest() throws Exception {
		assertEquals(true, emptyTree.isEmpty());
		assertEquals(false, smallTree.isEmpty());
		assertEquals(false, bigTree.isEmpty());
		assertEquals(false, otherTree.isEmpty());
		assertEquals(false, stringTree.isEmpty());
	}

	@Test
	public void addAllSimpleTest() throws Exception {
		// Inserts the "OtherTree" into "EmptyTree".
		emptyTree.addAll(otherTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(true, emptyTree.contains(5));
		assertEquals(true, emptyTree.contains(15));
		assertEquals(false, emptyTree.contains(25));
		assertEquals(true, emptyTree.contains(35));
		assertEquals(3, emptyTree.size());
		assertEquals(1, emptyTree.height());
	}

	@Test
	public void addAllSimpleEmptyTreeTest() throws Exception {
		// Inserts the "EmptyTree" into "EmptyTree".
		emptyTree.addAll(emptyTree);
		// is testing whether the size and the height of the tree is correct.
		assertEquals(0, emptyTree.size());
		assertEquals(0, emptyTree.height());
	}

	@Test
	public void addAllOtherEmptyTreeTest() throws Exception {
		// Inserts the "EmptyTree" into "OtherTree".
		otherTree.addAll(emptyTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(true, otherTree.contains(5));
		assertEquals(true, otherTree.contains(15));
		assertEquals(false, otherTree.contains(25));
		assertEquals(true, otherTree.contains(35));
		assertEquals(3, otherTree.size());
		assertEquals(1, otherTree.height());
	}

	@Test
	public void addAllSmallTreeTest() throws Exception {
		// Inserts "SmallTree" into "OtherTree".
		otherTree.addAll(smallTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(11, otherTree.size());
		assertEquals(2, otherTree.height());
		assertEquals(true, otherTree.contains(2));
		assertEquals(true, otherTree.contains(4));
		assertEquals(true, otherTree.contains(5));
		assertEquals(true, otherTree.contains(6));
		assertEquals(true, otherTree.contains(8));
		assertEquals(true, otherTree.contains(12));
		assertEquals(true, otherTree.contains(14));
		assertEquals(true, otherTree.contains(15));
		assertEquals(true, otherTree.contains(16));
		assertEquals(true, otherTree.contains(18));
		assertEquals(true, otherTree.contains(35));
	}

	@Test
	public void cloneDeepSimpleEmptyTreeTest() throws Exception {
		// Creates a deep copy of "EmptyTree" in "EmptyTree".
		emptyTree = BTreeImplementation.cloneDeep(emptyTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(0, emptyTree.size());
		assertEquals(0, emptyTree.height());
		assertEquals(true, emptyTree.isEmpty());
	}

	@Test
	public void cloneDeepEmptyTreeTest() throws Exception {
		// Creates a deep copy of "OtherTree" in "EmptyTree".
		emptyTree = BTreeImplementation.cloneDeep(otherTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(3, emptyTree.size());
		assertEquals(1, emptyTree.height());
		assertEquals(true, emptyTree.contains(5));
		assertEquals(true, emptyTree.contains(15));
		assertEquals(true, emptyTree.contains(35));
	}

	@Test
	public void cloneDeepSimpleTreeTest() throws Exception {
		// Creates a deep copy of "EmptyTree" in "OtherTree".
		otherTree = BTreeImplementation.cloneDeep(emptyTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(0, otherTree.size());
		assertEquals(0, otherTree.height());
		assertEquals(true, otherTree.isEmpty());
	}

	@Test
	public void cloneDeepSmallTreeTest() throws Exception {
		// Creates a deep copy of "OtherTree" in "SmallTree".
		smallTree = BTreeImplementation.cloneDeep(otherTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(3, smallTree.size());
		assertEquals(1, smallTree.height());
		assertEquals(true, smallTree.contains(5));
		assertEquals(true, smallTree.contains(15));
		assertEquals(true, smallTree.contains(35));
		assertEquals(false, smallTree.contains(2));
		assertEquals(false, smallTree.contains(18));
	}

	@Test
	public void cloneDeepTest() throws Exception {
		// Creates a deep copy of "OtherTree" in "SmallTree".
		smallTree = BTreeImplementation.cloneDeep(otherTree);
		// is testing whether element is contains, the size and the height of the tree is correct.
		assertEquals(3, smallTree.size());
		assertEquals(1, smallTree.height());
		assertEquals(true, smallTree.contains(5));
		assertEquals(true, smallTree.contains(15));
		assertEquals(true, smallTree.contains(35));
		assertEquals(false, smallTree.contains(2));
		assertEquals(false, smallTree.contains(18));
		// Inserts one element into "OtherTree".
		otherTree.insert(150);
		// testing whether "SmallTree" is incorrectly changed.
		assertEquals(3, smallTree.size());
		assertEquals(1, smallTree.height());
		assertEquals(true, smallTree.contains(5));
		assertEquals(true, smallTree.contains(15));
		assertEquals(true, smallTree.contains(35));
		assertEquals(false, smallTree.contains(2));
		assertEquals(false, smallTree.contains(18));
		// testing whether "OtherTree" is incorrectly changed..
		assertEquals(1, otherTree.height());
		assertEquals(4, otherTree.size());
		assertEquals(true, otherTree.contains(5));
		assertEquals(true, otherTree.contains(15));
		assertEquals(true, otherTree.contains(35));
		assertEquals(true, otherTree.contains(150));

	}
}