package datastructures;

import java.util.Iterator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/7/13
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackSortedDriver {
    public static <E> void main(String[] args){
        StackSorted<E> s = new StackSorted<E>();
        Random rnd = new Random();

        System.out.println(s.push((E) new Integer(rnd.nextInt(500) + 1)));
        System.out.println(s.push((E) new Integer(rnd.nextInt(500) + 1)));
        System.out.println(s.push((E) new Integer(rnd.nextInt(500) + 1)));
        System.out.println(s.push((E) new Integer(rnd.nextInt(500) + 1)));
        System.out.println(s.push((E) new Integer(rnd.nextInt(500) + 1)));
        System.out.println(s.push((E) new Integer(rnd.nextInt(500) + 1)));

        System.out.println("The size is: " + s.size());

        System.out.println();

        for (Iterator it = s.iterator(); it.hasNext();)
            System.out.println(it.next());
    }
}
