package datastructures;

import java.util.Random;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/7/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyQueueDriver {
    public static <E> void main(String[] args){
        MyQueue<E> queue = new MyQueue<E>();
        Random rnd = new Random();

        for (int x = 0; x < 5; x++){
            System.out.println(queue.enqueue((E) new Integer(rnd.nextInt(500) + 1)));
        }

        System.out.println("Size of the queue is: " + queue.size());

        queue.peek();

        for (Iterator it = queue.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

    }
}
