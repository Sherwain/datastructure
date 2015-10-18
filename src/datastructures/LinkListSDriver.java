package datastructures;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/28/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkListSDriver {
    public static <E>void main(String[] args){
        LinkListS<E> list = new LinkListS<E>();
        LinkListS<E> list1 = new LinkListS<E>();
        LinkListS<E> list2 = new LinkListS<E>();
        LinkListS<E> listSum = new LinkListS<E>();

//        list.addNode((E) new String("Devar"));
//        list.addNode((E) new String("Jevon"));
//        list.addNode((E) new String("Fermor"));
        //list.addNode((E) new String("Sherwain"));
        list.addNode((E) new String("Sherwain"));
        list.addNode((E) new String("Justine"));
        list.addNode((E) new String("Graham"));
        Node<E> node = list.getHead().getNext();

        list.addNode((E) new String("Francis"));
        list.addNode((E) new String("Chris"));
        list.addNode((E) new String("Dave"));
        list.addNode((E) new String("Chris"));
        //list.addNode((E) new String("Ken"));
        list.addNode((E) new String("Ken"));
        //System.out.println("Before " + list.getTail().getNext());
        list.addToTail(node);
        //System.out.println("After " + list.getTail().getNext());
        //System.out.println(list.printList());

        System.out.println(list.findBeginning().getData());

        //list.removeDuplicate();
        //System.out.println(list.printList());
        //System.out.println(list.getPreviousNode());
        //list.deleteDups2();
        //System.out.println(list.printList());
        //list.nthToLast2(7);
        //list.deleteFromMiddle((E) new String("Francis"));
        //System.out.println(list.printList());

        list1.addNode((E) new Integer(3));
        list1.addNode((E) new Integer(4));
        list1.addNode((E) new Integer(2));

        list2.addNode((E) new Integer(3));
        list2.addNode((E) new Integer(2));
        list2.addNode((E) new Integer(1));

        System.out.println("List1: " +list1.printList());
        System.out.println("List2: " + list2.printList());
        listSum.arithmetic(list1.getHead(), list2.getHead());
        System.out.println("List Sum: " + listSum.printList());
    }
}
