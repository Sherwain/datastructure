package linklistmanipulation;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/15/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListDriver {
    static LinkedList linkedList = new LinkedList();
    static LinkedListUtils util = new LinkedListUtils();

    public static void main(String[] args){
        linkedList.addToHead(new IntegerNode(9));
        linkedList.addToHead(new IntegerNode(32));
        linkedList.addToHead(new IntegerNode(65));
        linkedList.addToHead(new IntegerNode(76));
        linkedList.addToHead(new IntegerNode(9));
        linkedList.addToHead(new IntegerNode(9));
        System.out.println(linkedList);
        LinkedListUtils.removeDuplicatesInPlace(linkedList);
        System.out.println(linkedList);
    }
}
