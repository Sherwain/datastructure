package practicewithkavan.trees;

import datastructures.Queue;
import practicewithkavan.LinkList;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/16/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree<K extends Comparable>  {
    private BinaryNode<K> root;
    private int numberOfNodes;
    private int height;
    private int depth;

    public BinarySearchTree(){
        depth = 0;
        numberOfNodes = 0;
        height = 0;
        depth = 0;
        root = null;
    }

    public BinaryNode<K> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<K> root) {
        this.root = root;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(BinaryNode<K> root) {
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

    private int minDepth(BinaryNode<K> root) {
        // Exit condition for recursion
        if (null == root) {
            return 0;
        }
        // recursively find the minimum depth of left and right child and select
        // the minimum depth among them
        return 1 + Math.min(minDepth(root.getLeftChild()), minDepth(root.getRightChild()));
    }

    public void add2(K value){
        BinaryNode<K> node = new BinaryNode<K>(value);
        if (root == null)
            root = node;
        else{
            reorganizeSubTree(node, locateNode(node, root), false);
        }
        setNumberOfNodes(getNumberOfNodes() + 1);
        setHeight(height());
        setDepth(height() - 1);
    }

    public LinkList<K> inOrderTraversal(BinaryNode<K> r, LinkList<K> list){
        if (r == null)
            return list;
        inOrderTraversal(r.getLeftChild(), list);
        list.add(r.getValue());
        inOrderTraversal(r.getRightChild(), list);
        return list;
    }

    private void inOrderTraversal(BinaryNode<K> r){
        if (r == null)
            return ;
        inOrderTraversal(r.getLeftChild());
        System.out.print(r.getValue());

        inOrderTraversal(r.getRightChild());
    }

    private LinkList<K> preOrderTraversal(BinaryNode<K> node, LinkList<K> list){
        if (node == null)
            return null;
        list.add( node.getValue());
        preOrderTraversal(node.getLeftChild(), list);
        preOrderTraversal(node.getRightChild(), list);
        return list;
    }

    private LinkList<K> postOrderTraversal(BinaryNode<K> r, LinkList<K> list){
        if (r == null)
            return list;
        postOrderTraversal(r.getLeftChild(), list);
        postOrderTraversal(r.getRightChild(), list);
        list.add(r.getValue());
        return list;
    }

    public LinkList<K> inOrderTraversal(){
        return inOrderTraversal(getRoot(), new LinkList<K>());
    }

    public LinkList<K> preOrderTraversal(){
        return preOrderTraversal(getRoot(), new LinkList<K>());
    }

    public LinkList<K> postOrderTraversal(){
        return postOrderTraversal(getRoot(), new LinkList<K>());
    }

    public LinkList<K> levelOrderTraversal(){
        return levelOrderTraversal(new LinkList<K>(), 0);
    }

    private LinkList<K> levelOrderTraversal( LinkList<K> list, int level){
        if (level == height)
            return list;
        list = getElementAtLevel(root, list, level, 0);
        level = level + 1;
        list = levelOrderTraversal(list, level);
        return list;
    }

    private LinkList<K> getElementAtLevel(BinaryNode<K> localRoot, LinkList<K> list, int level, int stop){
        if (level == stop){
            if (localRoot != null)
                list.add(localRoot.getValue());
            return list;
        }
        if(localRoot == null)
            return list;
        stop = stop + 1;
        list = getElementAtLevel(localRoot.getLeftChild(), list, level, stop);
        list = getElementAtLevel(localRoot.getRightChild(), list, level, stop);
        return list;
    }

    private  BinaryNode<K> locateNode( BinaryNode<K> node, BinaryNode<K> rootNode){
        if (node.getValue().compareTo(rootNode.getValue()) >= 0)
            return checkRight(node, (rootNode));
        else
            return checkLeft(node, (rootNode));
    }

    private BinaryNode<K> checkLeft(BinaryNode<K> node, BinaryNode<K> subNode ){
        if (node.getValue().compareTo(subNode.getValue()) >= 0 && (subNode.getRightChild() == null || node.getValue().compareTo
                (subNode.getRightChild().getValue()) <= 0) || (subNode.getLeftChild() == null && subNode.getRightChild() == null)||
                (node.getValue().compareTo(subNode.getValue()) < 0 && subNode.getLeftChild() == null) )
            return subNode;

        if (node.getValue().compareTo(subNode.getValue()) < 0)
            return checkLeft(node, moveLeft(subNode));
        else
            return checkRight(node, moveRight(subNode));
    }

    private BinaryNode<K> checkRight(BinaryNode<K> node, BinaryNode<K> subNode ){
        if (node.getValue().compareTo(subNode.getValue()) < 0 && (subNode.getLeftChild() == null || node.getValue().compareTo
                (subNode.getLeftChild().getValue()) > 0) || (subNode.getLeftChild() == null && subNode.getRightChild() == null) ||
                (node.getValue().compareTo(subNode.getValue()) >= 0 && subNode.getRightChild() == null) ){
            return subNode;
        }
        if (node.getValue().compareTo(subNode.getValue()) >= 0)
            return checkRight(node, subNode.getRightChild());
        else
            return checkLeft(node, subNode.getLeftChild());
    }

    public boolean remove(K value){
        BinaryNode<K> node = getBinarySearchNode(value, getRoot());
        if(node == null)
            return false;
        else{
            if (node.getRightChild() != null)//check to the right of node for null
                node.getRightChild().setParent(node.getParent());//set the parent
                if (node.getParent() != null) //make nodes prev parent now points to node prev right child
                    node.getParent().setRightChild(node.getRightChild());
            else
                 if (node.getLeftChild() != null)
                    node.getLeftChild().setParent(node.getParent());
                    if (node.getParent() != null)
                        node.getParent().setLeftChild(node.getLeftChild());
            node = null;
            setNumberOfNodes(getNumberOfNodes() - 1);
            setHeight(height());
            setDepth(height() - 1);
            return true;
        }
    }

    public K minValue(){
        return getLeftMostNode(getRoot()).getValue();
    }

    public K maxValue(){
        return getRightMostNode(getRoot()).getValue();
    }

    private BinaryNode<K> getLeftMostNode(BinaryNode<K> node) {
        if (node.getLeftChild() == null)
            return node;
        return getLeftMostNode(node.getLeftChild());
    }

    private BinaryNode<K> getRightMostNode(BinaryNode<K> node) {
        if (node.getRightChild() == null)
            return node;
        return getRightMostNode(node.getRightChild());
    }

    public boolean search(K value){
        if (getBinarySearchNode(value, getRoot()) != null) return true;
        else return false;
    }

    public boolean add(K value){
        boolean val = true;
        if (root == null)
            root = new BinaryNode<K>(value);
        else
            val = insertAndBalance(value, root);
        setNumberOfNodes(getNumberOfNodes() + 1);
        setHeight(height());
        setDepth(height() -1);

        return val;
    }

    private boolean insert(K value, BinaryNode<K> rootNode) {
        if (value.compareTo(rootNode.getValue()) < 0 ){
            if (rootNode.getLeftChild() == null){
                rootNode.setLeftChild(rootNode);
                return true;
            }
            else
                return insert(value, rootNode.getLeftChild());
        }
        else{
            if (rootNode.getRightChild() == null){
                rootNode.setRightChild(rootNode);
                return true;
            }
            else
                return insert(value, rootNode.getRightChild());
        }
    }

    private BinaryNode<K> getBinarySearchNode(K value, BinaryNode<K> rootNode){
        if (rootNode == null) return null;

        if (value.compareTo(rootNode.getValue()) == 0){
            return rootNode;
        }
        if (value.compareTo(rootNode.getValue()) >= 0)
            return getBinarySearchNode(value, rootNode.getRightChild());
        else
            return getBinarySearchNode(value, rootNode.getLeftChild());
    }

    private BinaryNode<K> moveRight(BinaryNode<K> node){
        return node.getRightChild();
    }

    private BinaryNode<K> moveLeft(BinaryNode<K> node){
        return node.getLeftChild();
    }

    public int minHeight() {
        return minHeight(root, 0);
    }

    private int minHeight(BinaryNode<K> localRoot, int cnt) {
        if (localRoot == null)
            return cnt;

        cnt = cnt + 1;
        return Math.min(minHeight(localRoot.getRightChild(), cnt), minHeight(localRoot.getLeftChild(), cnt));
    }

    public int height(){
         return height(root, 0);
    }

    public boolean isBalanced(){
        return height() - minHeight() <= 1;
    }

    private int height(BinaryNode<K> r, int cnt){
        if (r == null)
            return cnt;
        cnt = cnt + 1;
        return Math.max (height(r.getRightChild(), cnt), height(r.getLeftChild(), cnt));
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves (BinaryNode<K> localRoot){
        if (localRoot == null)
            return 0;
        if (localRoot.isLeaf())
            return 1;
        return countLeaves(localRoot.getLeftChild()) + countLeaves(localRoot.getRightChild());
    }


    private boolean insert2(K value, BinaryNode<K> localRoot){
        if (localRoot == null){
            root = new BinaryNode<K>(value);
             return true;
        }

        if (value.compareTo(localRoot.getValue()) >= 0){
            if (localRoot.getRightChild() == null){
                localRoot.setRightChild(new BinaryNode<K>(value));
                localRoot.getRightChild().setParent(localRoot);
                return true;
            }
            else
                return insert2(value, localRoot.getRightChild());
        }
        else {
            if (localRoot.getLeftChild() == null){
                localRoot.setLeftChild(new BinaryNode<K>(value));
                localRoot.getLeftChild().setParent(localRoot);
                return true;
            }
            else
                return insert2(value, localRoot.getLeftChild());
        }
    }

    public LinkList<K> elementsAtLevel(int level){
        return elementsAtLevel(new LinkList<K>(), root, level - 1, 0);
    }

    private LinkList<K> elementsAtLevel(LinkList<K> list, BinaryNode<K> localRoot, int level, int cnt){
        if (localRoot == null)
            return list;
        if (level == cnt){
            list.add(localRoot.getValue());
        }
        cnt = cnt + 1;
        list = elementsAtLevel(list, localRoot.getLeftChild(), level, cnt);
        list = elementsAtLevel(list, localRoot.getRightChild(), level, cnt);
        return list;
    }

    public int width(){
        return width(-1, 0);
    }

    private int width(int level, int curMax) {
        if (height < level)
            return curMax;
        level = level + 1;
        curMax = levelCount(0, root, level, 0, curMax);
        return width(level, curMax);
    }

    public int levelCount(int level){
        return levelCount(0, root, level - 1, 0);
    }

    private int levelCount(int levelCount, BinaryNode<K> localRoot, int level, int cnt, int max){
        if (localRoot == null || cnt > level)
            if (levelCount > max)
                return levelCount;
             else
                return max;
        if (level == cnt)
            levelCount = levelCount + 1;
        cnt = cnt + 1;
        levelCount = levelCount(levelCount, localRoot.getLeftChild(), level, cnt);
        levelCount = levelCount(levelCount, localRoot.getRightChild(), level, cnt);
        return levelCount;
    }

    private int levelCount(int levelCount, BinaryNode<K> localRoot, int level, int cnt){
        if (localRoot == null)
            return levelCount;
        if (level == cnt){
            levelCount = levelCount + 1;
        }
        cnt = cnt + 1;
        levelCount = levelCount(levelCount, localRoot.getLeftChild(), level, cnt);
        levelCount = levelCount(levelCount, localRoot.getRightChild(), level, cnt);
        return levelCount;
    }

    public boolean xOr(boolean x, boolean y) {
        return ( ( x || y ) && ! ( x && y ) );
    }

    private boolean insertAndBalance(K value, BinaryNode<K> localRoot){
        if (value.compareTo(localRoot.getValue()) < 0)
            if (localRoot.getLeftChild() != null)
                return insertAndBalance(value, localRoot.getLeftChild());
            else
                return reorganizeSubTree(new BinaryNode<K>(value), localRoot, false);
        else
            if (localRoot.getRightChild() != null)
                return insertAndBalance(value, localRoot.getRightChild());
            else
                return reorganizeSubTree(new BinaryNode<K>(value), localRoot, true);
    }

    private boolean addToSubTree(BinaryNode<K> subTree, BinaryNode<K> node, boolean bendRight) {
        if (bendRight){
            if (subTree.getParent() != null){
                subTree.getParent().setLeftChild(node);
                node.setParent(subTree.getParent());
            }else
                root = node;
            node.setLeftChild(subTree.getLeftChild());
            subTree.setLeftChild(null);
            node.setRightChild(subTree);
            subTree.setParent(node);
            if(node.getLeftChild() != null)
                node.getLeftChild().setParent(node);
        }
        else{
            if(subTree.getParent() != null){
                subTree.getRightChild().setRightChild(node);
                node.setParent(subTree.getParent());
            }else
                root = node;
            node.setRightChild(subTree.getRightChild());
            subTree.setRightChild(null);
            node.setLeftChild(subTree);
            subTree.setParent(node);
            if (node.getRightChild() != null)
                node.getRightChild().setParent(node);
        }

    return true;
    }

    private boolean reorganizeSubTree(BinaryNode<K> node, BinaryNode<K> subTree, boolean right){
        if (!right)
            subTree.setLeftChild(node);
        else
            subTree.setRightChild(node);
        node.setParent(subTree);
        int val = maxDepth();
        val = minDepth();
        if (!isBalanced())
            balanceTree(subTree);
        return true;
    }

    private void balanceTree(BinaryNode<K> localRoot){
        if (localRoot == null)
            return ;
        if (height(localRoot, 0) - minHeight(localRoot, 0) > 1){
            balanceSubTree(localRoot);
        }
        balanceTree(localRoot.getParent());
    }

    private void balanceSubTree(BinaryNode<K> localRoot) {
        BinaryNode<K> xMostNode;
        boolean head = false;
        if (height(localRoot.getLeftChild(), 0) < height(localRoot.getRightChild(), 0) ){
            if (height(localRoot, 0) <= 3){
                if (localRoot.getRightChild().getLeftChild() != null){
                    localRoot.getRightChild().getLeftChild().setParent(localRoot.getParent());
                    if (localRoot.getParent() != null)
                        localRoot.getParent().setRightChild(localRoot.getRightChild().getLeftChild());
                    else
                        root = localRoot.getRightChild().getLeftChild();
                    localRoot.getRightChild().getLeftChild().setLeftChild(localRoot);
                    localRoot.setParent(localRoot.getRightChild().getLeftChild());
                    localRoot.getRightChild().getLeftChild().setRightChild(localRoot.getRightChild());
                    localRoot.getRightChild().setParent(localRoot.getRightChild().getLeftChild());
                    localRoot.getRightChild().setLeftChild(null);
                    localRoot.getRightChild().setRightChild(null);
                    localRoot.setRightChild(null);
                    localRoot.setLeftChild(null);
                }
                else {
                    localRoot.getRightChild().setParent(localRoot.getParent());
                    if (localRoot.getParent() != null)
                        localRoot.getParent().setRightChild(localRoot.getRightChild());
                    else
                        root = localRoot.getRightChild();
                    localRoot.getRightChild().setLeftChild(localRoot);
                    localRoot.setParent(localRoot.getRightChild());
                    localRoot.setRightChild(null);
                }
            }
            else{

                if (localRoot.getRightChild().getRightChild().getLeftChild()  != null){
                    localRoot.getRightChild().getRightChild().getLeftChild().setRightChild(localRoot.getRightChild().getRightChild());//set right
                    localRoot.getRightChild().getRightChild().getLeftChild().setLeftChild(localRoot.getRightChild()); //set left child
                    localRoot.getRightChild().setParent(localRoot.getRightChild().getRightChild().getLeftChild()); //point to new subtree
                    localRoot.getRightChild().getRightChild().setParent(localRoot.getRightChild().getRightChild().getLeftChild());
                    localRoot.getRightChild().getRightChild().getLeftChild().setParent(localRoot.getRightChild());
                    localRoot.getRightChild().setRightChild(localRoot.getRightChild().getRightChild().getLeftChild());
                    localRoot.getRightChild().getRightChild().getRightChild().setRightChild(null);
                    localRoot.getRightChild().getRightChild().getRightChild().setLeftChild(null);
                }else{
                    localRoot.getRightChild().getRightChild().setLeftChild(localRoot.getRightChild()); //8********* get
                    localRoot.getRightChild().getRightChild().getLeftChild().setParent(localRoot.getRightChild().getRightChild());
                }
                xMostNode = getLeftMostNode(localRoot.getRightChild());
                localRoot.getRightChild().getRightChild().setParent(xMostNode);   //getleft most
                xMostNode.setParent(localRoot.getParent());



                if (xMostNode.getRightChild() != null)
                    xMostNode.getRightChild().setParent(localRoot.getRightChild());
                localRoot.getRightChild().setLeftChild(xMostNode.getRightChild());

                xMostNode.setRightChild(localRoot.getRightChild().getRightChild());


                if (localRoot.getParent() != null)
                    localRoot.getParent().setRightChild(xMostNode);
                else
                    root = xMostNode;

                if (localRoot.getLeftChild().getRightChild() != null){
                    localRoot.getLeftChild().getRightChild().setLeftChild(localRoot.getLeftChild());
                    localRoot.getLeftChild().setParent(localRoot.getLeftChild().getRightChild());
                    localRoot.getLeftChild().getRightChild().setParent(localRoot);
                    localRoot.setLeftChild(localRoot.getLeftChild().getRightChild());
                    localRoot.getLeftChild().getLeftChild().setAsLeaf();
                }

                if (localRoot.getRightChild().getRightChild().getParent() != null)
                    localRoot.getRightChild().getRightChild().getParent().setLeftChild(localRoot.getLeftChild()); //check this
                localRoot.getLeftChild().setParent(localRoot.getRightChild().getRightChild().getParent());
                localRoot.getLeftChild().setRightChild(localRoot);
                localRoot.setParent(localRoot.getLeftChild());
                localRoot.getRightChild().getRightChild().getLeftChild().setRightChild(null);
                localRoot.setRightChild(null);
                localRoot.setLeftChild(null);

            }
        }else{
            if (height(localRoot, 0) <= 3){
                if (localRoot.getLeftChild().getRightChild() != null){
                    localRoot.getLeftChild().getRightChild().setParent(localRoot.getParent());
                    if (localRoot.getParent() != null)
                        localRoot.getParent().setLeftChild(localRoot.getLeftChild().getRightChild());
                    else
                        root = localRoot.getLeftChild().getRightChild();
                    localRoot.getLeftChild().getRightChild().setRightChild(localRoot);
                    localRoot.setParent(localRoot.getLeftChild().getRightChild());
                    localRoot.getLeftChild().getRightChild().setLeftChild(localRoot.getLeftChild());
                    localRoot.getLeftChild().setParent(localRoot.getLeftChild().getRightChild());
                    localRoot.getLeftChild().getRightChild().getRightChild().setLeftChild(null);
                    localRoot.getLeftChild().getRightChild().getRightChild().setRightChild(null);
                    localRoot.setLeftChild(null);
                    localRoot.setRightChild(null);
                }
                else {
                    localRoot.getLeftChild().setParent(localRoot.getParent());
                    if (localRoot.getParent() != null)
                        localRoot.getParent().setLeftChild(localRoot.getLeftChild());
                    else
                        root = localRoot.getLeftChild();
                    localRoot.getLeftChild().setRightChild(localRoot);
                    localRoot.setParent(localRoot.getLeftChild());
                    localRoot.setLeftChild(null);
                }
            }
            else {

                if (localRoot.getLeftChild().getLeftChild().getRightChild()  != null){
                    localRoot.getLeftChild().getLeftChild().getRightChild().setLeftChild(localRoot.getLeftChild().getLeftChild());//set right
                    localRoot.getLeftChild().getLeftChild().getRightChild().setRightChild(localRoot.getLeftChild()); //set left child
                    localRoot.getLeftChild().setParent(localRoot.getLeftChild().getLeftChild().getRightChild()); //point to new subtree
                    localRoot.getLeftChild().getLeftChild().setParent(localRoot.getLeftChild().getLeftChild().getRightChild());
                    localRoot.getLeftChild().getLeftChild().getRightChild().setParent(localRoot.getLeftChild());
                    localRoot.getLeftChild().setLeftChild(localRoot.getLeftChild().getLeftChild().getRightChild());
//                    localRoot.getRightChild().getRightChild().getLeftChild().setLeftChild(null);
                    localRoot.getLeftChild().getLeftChild().getLeftChild().setRightChild(null);
                    localRoot.getLeftChild().getLeftChild().getLeftChild().setLeftChild(null);
                }else{
                    localRoot.getLeftChild().getLeftChild().setRightChild(localRoot.getLeftChild());
                    localRoot.getLeftChild().getLeftChild().getRightChild().setParent(localRoot.getLeftChild().getLeftChild());
                }
                xMostNode = getRightMostNode(localRoot.getLeftChild());
                localRoot.getLeftChild().getLeftChild().setParent(xMostNode);
                xMostNode.setParent(localRoot.getParent());


                if (xMostNode.getLeftChild() != null)
                    xMostNode.getLeftChild().setParent(localRoot.getLeftChild()); //here

                localRoot.getLeftChild().setRightChild(xMostNode.getLeftChild());
                xMostNode.setLeftChild(localRoot.getLeftChild().getLeftChild());


                if (localRoot.getParent() != null)
                    localRoot.getParent().setLeftChild(xMostNode);
                else
                    root = xMostNode;

                if (localRoot.getRightChild().getLeftChild() != null){
                    localRoot.getRightChild().getLeftChild().setRightChild(localRoot.getRightChild());
                    localRoot.getRightChild().setParent(localRoot.getRightChild().getLeftChild());//check up
                    localRoot.getRightChild().getLeftChild().setParent(localRoot);
                    localRoot.setRightChild(localRoot.getRightChild().getLeftChild());
                    localRoot.getRightChild().getRightChild().setLeftChild(null);
                    localRoot.getRightChild().getRightChild().setRightChild(null);
                }

                if (localRoot.getLeftChild().getLeftChild().getParent() != null)
                    localRoot.getLeftChild().getLeftChild().getParent().setRightChild(localRoot.getRightChild());
                localRoot.getRightChild().setParent(localRoot.getLeftChild().getLeftChild().getParent());
                localRoot.getRightChild().setLeftChild(localRoot);
                localRoot.setParent(localRoot.getRightChild());
                localRoot.getLeftChild().getLeftChild().getRightChild().setLeftChild(null);
                localRoot.getLeftChild().getLeftChild().getRightChild().setRightChild(null);
                localRoot.setRightChild(null);
                localRoot.setLeftChild(null);
            }
        }
    }


    private void add4(K key) {
        if (root == null) {
            root = new BinaryNode<K>(key);
            return;
        }
        BinaryNode<K> x = root;
        while (x != null) {
            int cmp = key.compareTo(x.getValue());
            if (cmp < 0) {
                if (x.getLeftChild() == null) {
                    x.setLeftChild(new BinaryNode<K>(key));
                    return;
                } else {
                    x = x.getLeftChild();
                }

            } else if (cmp > 0) {
                if (x.getRightChild() == null) {
                    x.setRightChild(new BinaryNode<K>(key));
                    return;
                } else {
                    x = x.getRightChild();
                }
            }
        }
    }

    private LinkList<K> levelOrder(Queue<BinaryNode<K>> queue, LinkList<K> list){
        if (queue.isEmpty()){
            return list;
        }
        BinaryNode<K> val =  (BinaryNode<K>) queue.peek();
        queue.enqueue(val.getLeftChild());
        queue.enqueue(val.getRightChild());
        list.add(queue.dequeue().getValue());
        return levelOrder(queue, list);
    }
}