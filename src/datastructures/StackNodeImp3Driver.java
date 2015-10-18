package datastructures;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/4/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackNodeImp3Driver {
    public static <E> void main(String[] args){
        StackNodeImp3 stack = new StackNodeImp3();
        stack.push(new Integer(3));
        stack.push(new Integer(9));
        stack.push(new Integer(2));
        stack.push(new Integer(13));
        stack.push(new Integer(18));
        stack.push(new Integer(5));
        System.out.println(stack.getSize());

        for (Iterator it = stack.iterator(); it.hasNext();){
            System.out.println(it.next());
            //System.out.println(stack.pop().getElement());
        }

        for (Iterator it = stack.iterator(); it.hasNext();){
            it.remove();
        }
        System.out.println(stack.pop());
    }
}
