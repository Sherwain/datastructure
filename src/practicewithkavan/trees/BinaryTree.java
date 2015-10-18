package practicewithkavan.trees;

import datastructures.Queue;
import practicewithkavan.LinkList;

import java.util.ArrayList;
//import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/15/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree <E extends Comparable> {
    private BinaryNode<E> root;
    private BinaryNode<E> cur;
    private int level;
    private int height;
    private int nodes;
    private int depth;

    public BinaryTree(){
        root = null;
        level = height = depth = nodes = 0;
    }

    public BinaryNode<E> getRoot() {
        return root;
    }

    private void setRoot(BinaryNode<E> root) {
        this.root = root;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    private void setDepth(int depth){
        this.depth = depth;
    }

    public int getDepth(){
        return depth;
    }

    public int getNodes() {
        return nodes;
    }

    private void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public LinkList<E> preOrderTraversal(){
        return preOrderTraversal(getRoot(), new LinkList<E>());
    }

    public LinkList<E> inOrderTraversal(){
        return inOrderTraversal(getRoot(), new LinkList<E>());
    }

    public LinkList<E> postOrderTraversal(){
        return postOrderTraversal(getRoot(), new LinkList<E>());
    }

    public LinkList<E> levelOrderTraversal(){
        return levelOrderTraversal(getRoot(), new LinkList<E>(), 0);
    }

    private LinkList<E> levelOrderTraversal(BinaryNode<E> localRoot, LinkList<E> list, int level){
        if (localRoot == null)
            return list;
        list = getElementAtLevel(getRoot(), list, level, 0);
        level = level + 1;
        list = levelOrderTraversal(localRoot.getRightChild(), list, level);
        return list;
    }

    private LinkList<E> getElementAtLevel(BinaryNode<E> localRoot, LinkList<E> list, int level, int stop){
        if (level == stop){
            list.add(localRoot.getValue());
            return list;
        }
        stop = stop + 1;
        list = getElementAtLevel(localRoot.getLeftChild(), list, level, stop);
        list = getElementAtLevel(localRoot.getRightChild(), list, level, stop);
        return list;
    }

    private LinkList<E> preOrderTraversal(BinaryNode<E> node, LinkList<E> list){
        if (node == null)
            return list;
        list.add(node.getValue());
        list = preOrderTraversal(node.getLeftChild(), list);
        list = preOrderTraversal(node.getRightChild(), list);
        return list;
    }

    private LinkList<E> postOrderTraversal(BinaryNode<E> r, LinkList<E> list){
        if (r == null)
            return list;
        list = postOrderTraversal(r.getLeftChild(), list);
        list = postOrderTraversal(r.getRightChild(), list);
        list.add(r.getValue());
        return list;
    }

    private LinkList<E> inOrderTraversal(BinaryNode<E> r, LinkList<E> list){
        if (r == null)
            return list;
        list = inOrderTraversal(r.getLeftChild(), list);
        list.add(r.getValue());
        list = inOrderTraversal(r.getRightChild(), list);
        return list;
    }

    public void addComplete(E data){
        BinaryNode<E> bNode = new BinaryNode<E>();
        bNode.setValue(data);
        if (root == null) root = bNode;
        else if (level <= 1 && nodes <= 2 )//add to root node if it is not full
            addTo(bNode,  root, (root.getLeftChild() != null));
        else{ //find next available slot to add the node if root node is full
            cur = findUnBalancedNode(root); //pass the level and the root node to get unbalanced node
            addTo(bNode,  cur, (cur.getLeftChild() != null));
        }
        nodes = nodes + 1;
        setLevel(log(nodes));
        setDepth(log(nodes));
        setHeight(log(nodes) + 1);
    }

    //this function adds to the tree
    private void addTo(BinaryNode<E> node, BinaryNode<E> rootNode, boolean right){
        if (right)
            rootNode.setRightChild(node);
        else
            rootNode.setLeftChild(node);
        node.setParent(rootNode);
    }

    private BinaryNode<E> getLeftMostNode(BinaryNode<E> Node){
        if (Node.getLeftChild() == null)
            return Node;
        return   getLeftMostNode(Node.getLeftChild());
    }

    private int log(int x){
        int base = 2;
        return (int) (Math.log(x) / Math.log(base));
    }

    private boolean isBalanced(BinaryNode<E> node){
        return    (node.getLeftChild() != null && node.getRightChild()!= null);
    }

    public boolean isFull(){
        return isFull(root, true);
    }

    private boolean isFull(BinaryNode<E> rootNode, boolean val){
        if (rootNode == null)
            return true;
        if (!rootNode.isLeaf() && (rootNode.getLeftChild() == null || rootNode.getRightChild() == null))
            return false;
        if (!val)
            return false;
        val = isFull(rootNode.getLeftChild(), val);
        val = isFull(rootNode.getRightChild(), val);
        return val;
    }

    private BinaryNode<E> findUnBalancedNode(BinaryNode<E> localRoot){
        if (localRoot.isLeaf())
            return localRoot;
        int leftTreeSize = getSizeOfTree(localRoot.getLeftChild(), 0);
        int rightTreeSize = getSizeOfTree(localRoot.getRightChild(), 0);
        int leftSubTreeDepth = getSubTreeDepth(localRoot, 0);
        boolean isLeftTreeFull = isSubTreeFull(localRoot.getLeftChild());
        if (leftTreeSize == rightTreeSize){
            return getLeftMostNode(localRoot);
        }
        if (leftSubTreeDepth == 1)
            return localRoot;

        if (!isLeftTreeFull)
            return findUnBalancedNode(localRoot.getLeftChild());
        else
            return findUnBalancedNode(localRoot.getRightChild());
    }

    private boolean isSubTreeFull(BinaryNode<E> subTree){
        int depth = getSubTreeDepth(subTree, 0); //get the depth of the tree
        int size = getSizeOfTree(subTree, 0); //get the size of the tree
        return (Math.pow(2, depth+1) - 1) == size;
    }

    private int getSubTreeDepth(BinaryNode<E> node, int subTreeDepth) {
        if (node.isLeaf())
            return subTreeDepth;

        subTreeDepth = subTreeDepth + 1;
        return getSubTreeDepth(node.getLeftChild(), subTreeDepth);
    }


    private int getSizeOfTree(BinaryNode<E> subTree, int count){
        if (subTree == null)
            return count;
        count++;
        count = getSizeOfTree(subTree.getLeftChild(), count);
        count = getSizeOfTree(subTree.getRightChild(), count);
        return count;
    }


    public boolean isBalanced() {

        return (maxDepth() - minDepth()) <= 1;
    }


    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(BinaryNode<E> root) {
        // Exit condition for recursion
        if (null == root) {
            return 0;
        }
        // recursively find the max depth of left and right child and select the
        // maximum depth among them
        return 1 + Math.max(maxDepth(root.getLeftChild()), maxDepth(root.getRightChild()));
    }


    public int minDepth() {
        return minDepth(root);
    }

    private int minDepth(BinaryNode<E> root) {
        // Exit condition for recursion
        if (null == root) {
            return 0;
        }
        // recursively find the minimum depth of left and right child and select
        // the minimum depth among them
        return 1 + Math.min(minDepth(root.getLeftChild()), minDepth(root.getRightChild()));
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves (BinaryNode<E> localRoot){
        if (localRoot == null)
            return 0;
        if (localRoot.isLeaf())
            return 1;
        return countLeaves(localRoot.getLeftChild()) + countLeaves(localRoot.getRightChild());
    }

    public LinkList<E> levelOrder(){
        Queue<BinaryNode<E>> queue = new Queue<BinaryNode<E>>();
        queue.enqueue(root);
        return levelOrder(queue, new LinkList<E>());
    }

    private LinkList<E> levelOrder(Queue<BinaryNode<E>> queue, LinkList<E> list){
        if (queue.isEmpty()){
            return list;
        }
        BinaryNode<E> val = queue.peek();
        if (val.getLeftChild() != null)queue.enqueue(val.getLeftChild());
        if (val.getRightChild() != null) queue.enqueue(val.getRightChild());
        list.add(queue.dequeue().getValue());
        return levelOrder(queue, list);
    }
}