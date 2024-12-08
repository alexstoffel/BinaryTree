import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function

        BSTNode node = this.getRoot();
        // This will return true if it is in tree
        while (node != null){
            if(node.getVal() == val){
                return true;
            }else if(val < node.getVal()){
                node = node.getLeft();
            }else{
                node = node.getRight();
            }
        }
        return false;

    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        inOrderFunction(this.getRoot(), nodes);

        // return the arrayList
        return nodes;
    }

    // helper function for getInorder
    private void inOrderFunction(BSTNode node, ArrayList<BSTNode> arr){
        // return nothing if null
        if (node == null){
            return;
        }

        // left, node, right format
        inOrderFunction(node.getLeft(), arr);
        arr.add(node);
        inOrderFunction(node.getRight(), arr);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        getPreorderFunction(this.getRoot(), nodes);

        // return the arrayList
        return nodes;
    }

    // helper function for getPreorder
    private void getPreorderFunction(BSTNode node,ArrayList<BSTNode> arr){
        if (node == null){
            return;
        }

        // preorder format: node, left, right
        arr.add(node);
        getPreorderFunction(node.getLeft(), arr);
        getPreorderFunction(node.getRight(), arr);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        getPostorderFunction(this.getRoot(), nodes);

        // return the arrayList
        return nodes;
    }

    // getPostorder helper function
    private void getPostorderFunction(BSTNode node, ArrayList<BSTNode> arr){
        if (node == null){
            return;
        }

        // posterOrder format: left, right, root
        getPostorderFunction(node.getLeft(), arr);
        getPostorderFunction(node.getRight(), arr);
        arr.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        BSTNode current = this.getRoot();

        // wait until we get to the bottom of a branch, and put val there
        while (current != null){
            if (val < current.getVal()){
                // if it is empty, fill it in
                if (current.getLeft() == null){
                    current.setLeft(new BSTNode(val));
                    break;
                }
                current = current.getLeft();
            }else if(val > current.getVal()){
                // if it is empty, fill it in
                if (current.getRight() == null){
                    current.setRight(new BSTNode(val));
                    break;
                }
                current = current.getRight();
            }else{
                break;
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
