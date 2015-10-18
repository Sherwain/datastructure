package datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/7/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackSorted <E> implements Iterable<E>{
    private StackNodeImp3 stack1;
    private StackNodeImp3 stack2;


    public StackSorted(){
        stack1 = new StackNodeImp3<E>();
        stack2 = new StackNodeImp3<E>();
    }

    public E peek(){
        if (stack1.isEmpty()) throw new EmptyStackException();
        return (E) stack1.peek();
    }

    public E push(E item){
        if (stack1.isEmpty()){
            stack1.push(item);
        }
        else{
            if (!stack1.isEmpty()){
                while ( Integer.parseInt(item.toString()) > Integer.parseInt(stack1.peek().toString())){
                    stack2.push(stack1.pop());
                    if (stack1.isEmpty()) break;
                }
            }
            stack1.push(item);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return item;
    }

    public E pop(){
        if (stack1.isEmpty()) throw new EmptyStackException();
        return (E) stack2.pop();
    }

    public int size(){
        return stack1.getSize() + stack2.getSize();
    }

    public Iterator<E> iterator(){
        return stack1.iterator();
    }
}