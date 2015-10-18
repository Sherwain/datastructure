package practicewithkavan.trees;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/15/13
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryNode<E> {
    private E value;
    private BinaryNode<E> leftChild;
    private BinaryNode<E> rightChild;
    private BinaryNode<E> parent;

    public BinaryNode(E value, BinaryNode<E> parent, BinaryNode<E> rightChild, BinaryNode<E> leftChild){
        this.value = value;
        this.parent = parent;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }


    public BinaryNode(){
        this.parent = null;
        this.value = null;
        this.rightChild = null;
        this.leftChild = null;
    }

    public BinaryNode(E values){
        this.parent = null;
        this.value = values;
        this.rightChild = null;
        this.leftChild = null;
    }

    public void setParent(BinaryNode<E> parent) {
        this.parent = parent;
    }

    public BinaryNode<E> getParent() {
        return parent;
    }

    public void setValue(E value) {
        this.value = value;
    }

    //[37, 24, 7, 2, 32, 42, 40, 120]

    public E getValue() {
        return value;
    }

    public BinaryNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public boolean isLeaf(){
        return this.getLeftChild() == null && this.getRightChild()==null;
    }

    @Override
    public String toString(){
        return value == null? "": value.toString();
    }

    public void copy(BinaryNode<E> node){
        this.setParent(node.getParent());
        this.setValue(node.getValue());
        this.setLeftChild(node.getLeftChild());
        this.setRightChild(node.getRightChild());
    }

    public void setAsLeaf() {
        this.setLeftChild(null);
        this.setRightChild(null);
        //To change body of created methods use File | Settings | File Templates.
    }
}
