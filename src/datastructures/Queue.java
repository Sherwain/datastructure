package datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/6/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Queue <E> implements Iterable<E>{


    private Node<E> first;
    private Node<E> last;
    private int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getFirst() {
        return first;
    }

    public E dequeue(){
        if (isEmpty()) throw new EmptyStackException();
        E item = first.getData();
        first = first.getNext();
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(E item){
        if (size== 0)
            first = last = new Node<E>(item, null);
        else{
            last.setNext(new Node<E>(item, null));
            last = last.getNext();
        }
        size++;
    }

    public E peek(){
        if (isEmpty()) throw new EmptyStackException();
        return first.getData();
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public class StackIterator implements Iterator<E>{
        private Node<E> current;

        public StackIterator(){
            current = getFirst();
        }

        @Override
        public boolean hasNext() {
            return current != null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public E next() {
            if (!hasNext()) throw new EmptyStackException();
            E item = current.getData();
            current = current.getNext();
            return item;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void remove() {
            if (!hasNext()) throw new EmptyStackException();
            current = current.getNext();
            setSize(getSize() - 1);
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
