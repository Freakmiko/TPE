package tpe.Gruppe1_1.uebung01;

public interface BTree {

    /**
     * This method inserts the given Integer into
     * the tree and balances it if needed.
     * @param o The value to be inserted.
     * @return Returns true if the Integer was successfully inserted and
     *         false if the Integer was already in the tree.
     */
    boolean insert (Comparable o);

    /**
     * This method inserts all Integers in a file
     * into the tree and balances it if needed.
     * @param filename The Path of the file to be inserted.
     * @return Returns true if the Integer was successfully inserted and
     *         false if the Integer was already in the tree.
     */
    boolean insert (String filename);

    /**
     * This method checks if the Integer is
     * contained in the tree.
     * @param o The value to be checked
     * @return Returns true if the value is contained in the tree and false if it isn't.
     */
    boolean contains (Comparable o);

    /**
     * This method returns the size of the tree.
     * @return The size of the tree.
     */
    int size();

    /**
     * This method returns the height of the tree.
     * @return The height of the tree.
     */
    int height();

    /**
     * This method returns the largest Integer in the tree.
     * @return The largest Integer.
     */
    Comparable getMax();

    /**
     * This method returns the smallest Integer in the tree.
     * @return The smallest Integer.
     */
    Comparable getMin();

    /**
     * This method checks if the Tree is empty
     * @return Returns true if the Tree is empty and false if it isn't.
     */
    boolean isEmpty();

    /**
     * This method adds all the elements from otherTree and the current tree
     * into a new tree.
     * @param otherTree The tree from whose elements should be added.
     */
    void addAll(BTree otherTree);

    /**
     * This method prints the tree in-order
     * The natural order is contained as the left child of each
     * element is printed before the element thus printing numbers in order
     */
    void printInorder();

    /**
     * This method prints the tree post-order
     * All the children get printed completely before their parent
     */
    void printPostorder();

    /**
     * This method prints the tree pre-order
     * The parent node gets printed completely before its children
     */
    void printPreorder();

    /**
     * This method prints the tree level-order
     */
    void printLevelorder();

    /**
     * This method returns all the elements in the tree as a String in level-order
     * @return all the elements in level-order in a String
     */
    String getElements();

    /**
     * This method returns the order of the tree
     * @return the order of the tree
     */
    int getOrder();


    //Test
}
