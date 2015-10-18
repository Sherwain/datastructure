package practicewithkavan.trees;

import practicewithkavan.LinkList;


/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/22/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Heap <E extends Comparable> {
    private BinaryNode<E> root;
    private int depth;
    private int height;
    private int size;

    public Heap(){
        depth = 0;
        height = 0;
        size = 0;
    }

    public E add(E value){
        BinaryNode<E> node = new BinaryNode<E>(value);
        if (root == null){
            root = node;
        }
        else{
            insertNode(node);
        }
        setSize(getSize() + 1);
        setDepth(height() - 1);
        setHeight(height());
        return value;
    }

    private BinaryNode<E> findUnBalancedNode(BinaryNode<E> localRoot){
        if (localRoot.isLeaf())
            return localRoot;
        int leftTreeSize = getSizeOfTree(localRoot.getLeftChild(), 0);
        int rightTreeSize = getSizeOfTree(localRoot.getRightChild(), 0);
        int leftSubTreeDepth = getSubTreeDepth(localRoot, 0);
        boolean isLeftTreeFull = isSubTreeFull(localRoot.getLeftChild());
        if (leftTreeSize == rightTreeSize)
            return getLeftMostNode(localRoot);
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

    private BinaryNode<E> getLeftMostNode(BinaryNode<E> Node){
        if (Node.getLeftChild() == null)
            return Node;
        return   getLeftMostNode(Node.getLeftChild());
    }

    public LinkList<E> preOrder(){
        return preOrder(getRoot(), new LinkList<E>());
    }

    public LinkList<E> levelOrderTraversal(){
        return levelOrderTraversal(new LinkList<E>(), 0);
    }

    private LinkList<E> levelOrderTraversal( LinkList<E> list, int level){
        if (level == height)
            return list;
        list = getElementAtLevel(root, list, level, 0);
        level = level + 1;
        list = levelOrderTraversal(list, level);
        return list;
    }

    private LinkList<E> getElementAtLevel(BinaryNode<E> localRoot, LinkList<E> list, int level, int stop){
        if(localRoot == null)
            return list;
        if (level == stop){
            list.add(localRoot.getValue());
            return list;
        }
        stop = stop + 1;
        list = getElementAtLevel(localRoot.getLeftChild(), list, level, stop);
        list = getElementAtLevel(localRoot.getRightChild(), list, level, stop);
        return list;
    }

    public LinkList<E> preOrder(BinaryNode<E> localRoot, LinkList<E> list){
        if (localRoot == null)
            return list;
        list.add(localRoot.getValue());
        list = preOrder(localRoot.getLeftChild(), list);
        list = preOrder(localRoot.getRightChild(), list);
        return list;
    }

    private void insertNode(BinaryNode<E> node){
        BinaryNode<E> cur = findUnBalancedNode(getRoot());
        if (cur.getLeftChild() == null)
            cur.setLeftChild(node);
        else
            cur.setRightChild(node);
        node.setParent(cur);
        heapify(node);

    }

    private void heapify(BinaryNode<E> node){
        if (node == null)
            return;
        if(node.getParent() != null){
            if (node.getValue().compareTo(node.getParent().getValue()) > 0){
                if (node.getParent().getLeftChild() != null){
                    if (node.getParent().getLeftChild() == node){
                        node.getParent().setLeftChild(node.getLeftChild());
                        node.setLeftChild(node.getRightChild()); //swap nodes
                        node.setRightChild(node.getParent().getRightChild()); //swap nodes
                        node.getParent().setRightChild(node.getLeftChild());
                        node.setLeftChild(null); //set back left child to null
                        node.setLeftChild(node.getParent());
                    }
                }
                else {
                    if (node.getParent().getRightChild() == node){
                        node.getParent().setRightChild(node.getRightChild());
                        node.setRightChild(node.getParent().getLeftChild()); //hold nodes temporarily
                        node.getParent().setLeftChild(node.getLeftChild());
                        node.setLeftChild(node.getRightChild());
                        node.setRightChild(null); //set back right child to null
                        node.setRightChild(node.getParent()); //* Stay in the if
                    }
                }

                if (node.getParent().getLeftChild() != null)
                    node.getParent().getLeftChild().setParent(node.getParent());
                if (node.getParent().getRightChild() != null)
                    node.getParent().getRightChild().setParent(node.getParent());
                node.setParent(node.getParent().getParent());
                if (node.getRightChild() != null)
                    node.getRightChild().setParent(node);
                if (node.getLeftChild() != null)
                    node.getLeftChild().setParent(node);

                if (node.getParent() != null){
                    if (node.getParent().getLeftChild() != null){
                        if (node.getParent().getLeftChild() == node.getLeftChild())
                            node.getParent().setLeftChild(node);
                    }
                    if (node.getParent().getRightChild() != null)
                        if (node.getParent().getRightChild() == node.getLeftChild())
                            node.getParent().setRightChild(node);
                }
                else{
                    root = node;
                }
            }
            else
                return;
        }
        else
            return;
        heapify(node);
    }

    private int height(){
        return height(root, 0);
    }

    private int height(BinaryNode<E> localRoot, int cnt) {
        if (localRoot == null)
            return cnt;
        cnt = cnt + 1;
        cnt = Math.max (height(localRoot.getLeftChild(), cnt), height(localRoot.getRightChild(), cnt));
        return cnt;
    }

    private BinaryNode<E> getRoot() {
        return root;
    }

    private void setRoot(BinaryNode<E> root) {
        this.root = root;
    }

    public int getDepth() {
        return depth;
    }

    private void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int maxWith(){
        return 0;
    }

    private int maxDepth(){
        return 0;
    }

    private int minDepth(){
        return 0;
    }

    private LinkList<E> getElementsAtLevel(int level){
        return new LinkList<E>();
    }

    private int numberOfElementsAtLevel(int level){
        return 0;
    }

    private int countLeaves(){
        return 0;
    }
}
