package datastructures;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/4/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackCollectionDriver {
    public static void main(String[] args){
        StackCollection<Integer> sc = new StackCollection<Integer>();
        Random rnd = new Random();

        for (int x = 0; x < 17; x++){
            System.out.println(sc.push(rnd.nextInt(500) + 1));
        }

        System.out.println(sc.push(rnd.nextInt(500) + 1));

        sc.print();
        sc.popAt(1);
        sc.print();
    }
}
