package datastructures;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/3/13
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackNodeSDriver {
    public static <E>void main(String[] args){
        StackNodeS stack = new StackNodeS();
        stack.addToStack(new Integer(3));
        stack.addToStack(new Integer(9));
        stack.addToStack(new Integer(2));
        stack.addToStack(new Integer(13));
        stack.addToStack(new Integer(18));
        stack.addToStack(new Integer(5));
        //System.out.println(stack.size());
        System.out.println("Smallest element: " + stack.peek().getMin());
        for (Iterator it = stack.iterator(); it.hasNext();){
            System.out.println(((StackNode<E>) it.next()).getElement());
            //System.out.println(stack.pop().getElement());
        }

        for (Iterator it = stack.iterator(); it.hasNext();){
            //System.out.println(((StackNode<E>) it.next()).getElement());
            System.out.println(stack.pop().getElement());
        }
    }
}
