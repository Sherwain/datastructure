package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/3/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackNode <E>{
    private E element;
    private StackNode<E> next;
    private E min;

    public StackNode(){
        element = null;
        next = null;

    }

    public StackNode(E element, E min, StackNode<E> node){
        this.element = element;
        this.min = min;
        this.next = node;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public StackNode<E> getNext() {
        return next;
    }

    public void setNext(StackNode<E> next) {
        this.next = next;
    }

    public E getMin() {
        return min;
    }

    public void setMin(E min) {
        this.min = min;
    }
}
