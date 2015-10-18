package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/6/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueueDriver {
    public static <E> void main(String[] args){
        Queue<E> queue = new Queue<E>();
        Random rnd = new Random();

        queue.enqueue((E) new Integer(rnd.nextInt(500) + 1));
        queue.enqueue((E) new Integer(rnd.nextInt(500) + 1));
        queue.enqueue((E) new Integer(rnd.nextInt(500) + 1));

        System.out.println(queue.peek());

        for (Iterator it = queue.iterator(); it.hasNext();)
            System.out.println(it.next());

        Map m = new HashMap<String, Integer>();

        m.put("Sherwain", 4);
        m.put("David", 5);

        System.out.println(m);
    }
}
