package datastructures;

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
public class StackNodeImp3 <E> implements Iterable<E>{
    private StackImp2<E> top;
    private int size;
    private int capacity;
    private StackImp2<E> next;

    public StackNodeImp3(){
        setTop(null);
        setSize(0);
        setCapacity(5);
        setNext(null);
    }

    public synchronized E pop(){
        if(isEmpty()) return (E) "The Stack is Empty!";
        E item = (E) top.getElement();
        top = top.getNext();
        setSize(getSize() - 1);
        return item;
    }


    public synchronized E push(E item){
        if (isFull()) return (E) "This stack is full. Please use another stack to store the Element.";
        top = new StackImp2<E>(item, top);
        setSize(getSize() + 1);
        return (E) top;
    }

    public synchronized E peek(){
        if (isEmpty()) return (E) "The Stack is Empty!";
        return (E) top.getElement();
    }

    public synchronized void deleteNode(E item){
        if (top.getElement() == item){
            top = top.getNext();
            setSize(getSize()-1);
            return;
        }
        for(StackImp2<E> temp = top; temp != null; temp = temp.getNext()){
            if (temp.getElement() == item){
                temp = temp.getNext();
                setSize(getSize() - 1);
                break;
            }
        }
    }

    public StackImp2<E> deleteNode2(StackImp2<E> head, E d) {
        StackImp2<E> n = head;
         if (n.getElement().equals(d)) {
             return head.getNext(); /* moved head */
         }
         while (n.getNext() != null) {
             if (n.getNext().getElement() == d) {
                 n.setNext(n.getNext().getNext());
                 size --;
                 return head; /* head didn’t change */
             }
             n = n.getNext();
        }
        return null;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public StackImp2<E> getTop() {
        return top;
    }

    public void setTop(StackImp2<E> top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public StackImp2<E> getNext() {
        return next;
    }

    public void setNext(StackImp2<E> next) {
        this.next = next;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString(){
        String str = "";
        for (Iterator it = this.iterator(); it.hasNext();){
            str = str + "\n" + it.next();
        }
        return str;
    }

    private class ListIterator implements Iterator<E>{
        private StackImp2<E> current = top;

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

        public StackImp2<E> getCurrent() {
            return current;
        }

        public void setCurrent(StackImp2<E> current) {
            this.current = current;
        }
    }
}