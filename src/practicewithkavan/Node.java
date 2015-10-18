package practicewithkavan;


/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/11/13
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node <E> {
    private E element;
    private Node<E> next;
    private Node<E> prev;

    public Node(E data, Node<E> node, Node<E> prev){
        this.element = data;
        this.next = node;
        this.setPrev(prev);
    }

    public Node(E data, Node<E> prev){
        this.element = data;
        this.setPrev(prev);
    }

    public Node(){

    }

    public E getElement() {
        return element;
    }

    public void setElement(E word) {
        this.element = word;
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

    @Override
    public String toString(){
        return element.toString();
    }

    @Override
    public Object clone(){
        Node<E> clone = new Node<E>();
        clone.setNext(this.getNext());
        clone.setElement(this.getElement());
        clone.setPrev(this.getPrev());
        return clone;
    }
}
