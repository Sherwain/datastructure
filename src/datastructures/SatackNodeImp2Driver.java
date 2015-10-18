package datastructures;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/3/13
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SatackNodeImp2Driver {
    public static <E>void main(String[] args){
        StackNodeImp2 s = new StackNodeImp2();

        s.push(new Integer(3));
        s.push(new Integer(9));
        s.push(new Integer(2));
        s.push(new Integer(13));
        s.push(new Integer(18));
        s.push(new Integer(5));
        //System.out.println(stack.size());

        for (Iterator it = s.iterator(); it.hasNext();){
            System.out.println(it.next());
            //System.out.println(s.pop().getElement());
        }

        System.out.println(s.printStack());

        for (Iterator it = s.iterator(); it.hasNext();){
            System.out.println(s.pop());
        }

        System.out.println();

        for (Iterator it = s.iterator(); it.hasNext();){
            System.out.println(s.pop());
        }
    }
}
