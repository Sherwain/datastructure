package datastructures;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/3/13
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackNodeS<E> extends Stack<StackNode> {
    private int length;
    private StackNode<E> top;
    private StackNode<E> node;

    public int getLength() {
        return length;
    }

    public StackNodeS(){
        length = 0;
        top = new StackNode<E>();
    }

    public void addToStack(E element){
        node = top.getNext();
        super.push(new StackNode<E>(element, (E) new Integer(min(element)), top.getNext()));
    }

    public void setLength(int length) {
        this.length = length;
    }

    public StackNode<E> getTop() {
        return top;
    }

    public void setTop(StackNode<E> top) {
        this.top = top;
    }

    @Override
    public synchronized StackNode pop() {
        return super.pop();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public int min(E e){
        if (isEmpty()) return Integer.MAX_VALUE;
        if (Integer.parseInt(e.toString()) <  Integer.parseInt(peek().getMin().toString()) )
            return Integer.parseInt(e.toString());
        else
            return Integer.parseInt(peek().getMin().toString());
    }

    @Override
    public synchronized StackNode peek() {
        return super.peek();    //To change body of overridden methods use File | Settings | File Templates.
    }
}