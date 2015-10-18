package practicewithkavan;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/4/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinkList <E extends Comparable> implements Iterable<E>{
    private Node<E> head;
    private int size;
    private Node<E> tail;
    private Node<E> middle;

    public LinkList(){
        head = null;
        setSize(0);
        tail = null;
    }

    public void addToHead(E element){
        Node<E> cur;
        if (head == null) cur = null;
        else
            cur = head.getPrev();
        head = new Node<E>(element, head, cur );
        if (getTail() == null){
            setTail(head);
        }
        size = getSize() + 1; //increment the amount of nodes in the list
    }

    public E nthFromTail(int nth){
        if (this.isEmpty()) throw new EmptyStackException();
        if (size < nth) throw new IndexOutOfBoundsException();
        Node<E> cur = head;
        Node<E> trailer = null;
        boolean start = false;
        int count = 0;
        while(cur != null){
            if (count == nth){
                trailer = head;
                start = true;
            }
            if (start)
                trailer = trailer.getNext();
            cur = cur.getNext();
            count = count + 1;
        }
        return trailer.getElement();
    }

    public void add(E element){
        Node<E> node = new Node<E>(element, null, tail); //points node to null {points to what tail.next is pointing to

        if (isEmpty()){
            tail = node;
            head = tail;
        }
        else
            tail.setNext(node);
        tail = node; // Set the tail to be last element in the list
        size ++;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void setTail(Node<E> tail){
        this.tail = tail;
    }

    private Node<E> getTail(){
        return this.tail;
    }

    public void addTraditionally(E element){
        Node<E> cur;
        Node<E> node = new Node<E>(element, head); //create new node to point to be the first node in the list
        if (isEmpty()){
            tail = node; //set the first node to be the tail
        }
        else
            head.getNext().setPrev(node);//set the second node to point its prev to new node
        head.setNext(node); //make new node to be the first node in the list
        size ++; //increment the amount of nodes in the list
    }

    public Node<E> getHead() {
        return head;
    }

    public E removeAtTail(){
        if (isEmpty()) throw new EmptyStackException();
        E element = tail.getElement();
        tail = tail.getPrev();
        size--;
        return element;
    }

    public E removeAtHead(){
        if (isEmpty()) throw new EmptyStackException();
        Node<E> node = head.getNext(); //make a reference to the first node
        E element = node.getElement(); //gets the value for the first element in the list
        head.setNext(node.getNext()); //set the head node to point the node that the first node was pointing to
        if (size == 1){   //removing the last element from within the list
            tail = head; tail.setPrev(null);
        }
        else{
            head.getNext().setPrev(null); //points the first node to null
        }
        size--;
        return element;
    }

    public boolean remove(Node<E> node) {
        if (head == null) {
            return false;
        }

        HashTable<E, Node<E>> table = new HashTable<E, Node<E>>();
        Node<E> current = head;

        table.put(current.getElement(), current);

        while (current.getNext() != null) {
            if (table.containsKey(current.getNext().getElement())) {
                // We've accessed this node before, so we're going
                // to go ahead and delete it
                Node matchedNode = current.getNext();
                current.setNext(matchedNode.getNext());
            }
            else {
                table.put(current.getNext().getElement(), current);
                current = current.getNext();
            }
        }
        return false;
    }

    public int searchTopDown(E element){
        int occ = 0;
        for (Node<E> node = head.getNext(); node != null; node = node.getNext()){
            if (node.getElement().equals(element)){
                occ ++;
            }
        }
        return occ;
    }

    public boolean find(E element){
        for (Node<E> node = head.getNext(); node != null; node = node.getNext()){
            if (node.getElement().equals(element)){
                return  true;
            }
        }
        return false;
    }

    public int searchBottomUp(E element){
        int occ = 0;
        for (Node<E> node = tail; node != null; node = node.getPrev()){
            if (node.getElement().equals(element)){
                occ ++;
            }
        }
        return occ;
    }

    public int deleteNode(E element){
        Node<E> del = new Node<E>();
        E tempElement;
        int occ = 0;
        if (head.getNext() == null) return occ;

        for (Node<E> node = head.getNext(); node != null; node = node.getNext() ){
            tempElement = node.getElement();
            if (tempElement.equals(element)){
                del = node;   //creates a reference to the node that should be deleted
                if (del == tail){ // this is the last node in the list
                    tail.setNext(null); //set the tail next pointer to point to null
                    tail = node.getPrev();
                }
                else{ //not the end of the list
                    if (node.getPrev() == null){//deleting from head of the list
                        head.setNext(del.getNext());
                        node.getNext().setPrev(null);
                    }
                    else{ //one of the middle node is being deleted
                        node.getNext().setPrev(del.getPrev());
                        node.getPrev().setNext(del.getNext());
                    }
                }
                del = null;
                occ++;
                size--;
            }
        }
        return occ;
    }

    public int deleteFromTail(E element){
        if (tail == null)return 0;
        E tempElement;
        Node<E> del = new Node<E>();
        int occ = 0;

        for (Node<E> node = tail; node != null; node = node.getPrev()){
            tempElement = node.getElement();
            if (tempElement.equals(element)){
                del = node;
                if (tail == node){ // this is the last in the list(tail)
                    tail.setNext(null); //set the tail next pointer to point to null
                    tail = node.getPrev(); //move tail to previous node in the list
                }
                else{
                    node.getNext().setPrev(node.getPrev());
                    if (node.getPrev()==null){   //check if the node is at the beginning of the list
                        head.setNext(node.getNext()); //
                        node.getNext().setPrev(null); //sets the previous node to point to null
                    }
                    else{
                        node.getPrev().setNext(node.getNext());
                    }
                }
                del = null;
                occ++;
                size--;
            }
        }
        return occ;
    }

    public void sort(){
        if (isEmpty() || head.getNext() == null) return;
        boolean swapped = true;
        Node<E> cur = head;
        Node<E> nex = head.getNext();
        while (swapped){
            swapped = false;
            nex = head.getNext();
            nex.setPrev(head);
            while (nex != null){
                if (cur.getElement().compareTo(nex.getElement()) > 0)  {
                    if (cur == head)
                        head = nex;
                    cur.setNext(nex.getNext());
                    if (cur.getPrev() == null){
                        cur.setPrev(nex);
                        nex.setNext(cur);
                        head.setPrev(null);
                    }
                    else{
                        cur.getPrev().setNext(nex);
                        nex.setNext(cur);
                        nex.setPrev(cur.getPrev());
                        cur.setPrev(nex);
                    }
                    nex = cur.getNext();
                    if (nex != null)
                        nex.setPrev(cur);
                    else
                        tail = nex;
                    swapped = true;
                }
                else{
                    nex = nex.getNext();
                    if (nex != null){
                        nex.setPrev(cur.getNext());
                        cur = cur.getNext();
                        cur.setPrev(nex.getPrev().getPrev());
                    }
                }
            }
            cur = head;
        }
    }

    public void clear(){
        head = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString(){
        String str = "[";
        int k = 0;
        for (Iterator it = this.iterator(); it.hasNext();){
            if (k > 0) str = str + ", ";
                str = str + it.next();
            k ++;
        }
        return str + "]";
    }


//    @Override
//    public int compareTo(E o) {
//        return 0;  //To change body of implemented methods use File | Settings | File Templates.
//    }

    private class ListIterator implements Iterator<E>{
        private Node<E> current = head;

        @Override
        public boolean hasNext(){
            return (getCurrent() != null);
        }

        @Override
        public E next(){
            if (!hasNext()) throw new NoSuchElementException();
            E item = getCurrent().getElement();
            setCurrent(getCurrent().getNext());
            return item;
        }

        @Override
        public void remove() {
            if (isEmpty()) throw new EmptyStackException();
            setCurrent(getCurrent().getNext());
            setSize(getSize() - 1);
        }

        public Node<E> getCurrent() {
            return current;
        }

        public void setCurrent(Node<E> current) {
            this.current = current;
        }
    }

    public E deleteMiddle(){
        setMiddle();
        E item = middle.getElement();
        middle = middle.getNext();
        return item;
    }

    private void setMiddle(){
        if (isEmpty()) throw new EmptyStackException();
        if (head.getNext() == null){
            middle = head;
            return;
        }
        Node<E> cur = head;
        middle = head;
        int x = 1;
        while(cur != null){
            cur = cur.getNext();
            if (x%2 == 0){
                middle = middle.getNext();
            }
            x = x ++;
        }
    }
}