package datastructures;

import java.util.Iterator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/7/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyQueue <E> implements Iterable<E>{
    private StackNodeImp3 stack1;
    private StackNodeImp3 stack2;
    //private Random rnd = new Random();

    public MyQueue(){
        stack1 = new StackNodeImp3<E>();
        stack2 = new StackNodeImp3<E>();
    }

    public E peek(){
        if (stack2.isEmpty()){
            loadStack2();
        }
        return (E) stack2.peek();
    }

    public void loadStack2(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public E enqueue(E item){
        stack1.push(item);
        return item;
    }

    public E dequeue(){
        if (stack2.isEmpty()){
            loadStack2();
        }
        return (E) stack2.pop();
    }

    public int size(){
        return stack1.getSize() + stack2.getSize();
    }

    public Iterator<E> iterator(){

        return stack2.iterator();
    }
}
