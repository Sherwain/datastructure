package datastructuresp;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/25/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node<E>{
    private E element;
    private Node prev;
    private Node next;

    public Node() {
        element = null;
        prev = null;
        next = prev;
    }

    public Node(E element, Node node){
        this.element = element;
        this.next = node;
    }

    public Node(E element, Node<E> prev, Node next){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public Node<E> setNext(Node next) {
        return this.next = next;
    }
}
