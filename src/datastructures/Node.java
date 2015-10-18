package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/28/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node<E> {
    private Node<E> next;
    private Node<E> prev;
    private E data;

    public Node(){
        next = prev = null;
        data = null;
    }

    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
