package datastructures;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/3/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackNodeImp2<E> implements Iterable<E> {
    private StackImp2 top;
    private int length;

    public StackNodeImp2(){
        super();
        top = null;
        setLength(0);
    }

    public E push(E item) {

        top = new StackImp2<E>(item, top);

        setLength(getLength() + 1);
        return (E)top.getElement();   //To change body of overridden methods use File | Settings | File Templates.
    }



    public synchronized E pop(){
        if (isEmpty()) return (E) "Stack Empty!";
        E ele = (E) top.getElement();
        top = top.getNext();
        return ele;
    }



    public String printStack(){
        if (isEmpty())return "Stack is empty!";
        String str = "";
        for (StackImp2 n = top; n != null; n = n.getNext()){
            str = str + n.getElement().toString() + " => ";
        }
        return str;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public Iterator<E> iterator()  { return new ListIterator();  }


    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<E> {
        private StackImp2 current = top;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = (E) current.getElement();
            current = current.getNext();
            return item;
        }
    }

    private boolean isEmpty(){
        return top == null;
    }
}
