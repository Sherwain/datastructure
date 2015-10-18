package datastructuresp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/26/13
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkListDriver {
    public static void main(String[] args){
        LinkList<String> list = new LinkList<String>();
        List<String> conList = new LinkedList<String>();
        List<String> arrList = new ArrayList<String>();
        list.addNode("Sherwain");
        list.addNode("Gawain");
        list.addNode("Sam");
        list.addNode("Dev");
        list.addNode("Clare");
        
        conList.add("Sherwain");
        conList.add("Gawain");
        conList.add("Sam");
        conList.add("Dev");
        conList.add("Clare");
        
        
        arrList.add("Sherwain");
        arrList.add("Gawain");
        arrList.add("Sam");
        arrList.add("Dev");
        arrList.add("Clare");
        
        System.out.println(list.printList());
        System.out.println(conList);
        System.out.println(arrList);

        //list2.addTraditionally("Sherwain");
        //list2.addTraditionally((E) new String("Gawain"));
//        list2.addTraditionally((E) new String("Sam"));
//        list2.addTraditionally((E) new String("Dev"));
//        list2.addTraditionally((E) new String("Clare"));
//        list2.addTraditionally((E) new String("Lavi"));
        //list2.addTraditionally((E) new String("Sherwain"));
        //list2.addTraditionally((E) new String("Jenei"));
       // System.out.println(list.printList());

//        int length = list.getLength();
//
//        System.out.println("There were found " + list2.searchBottomUp((E) new String("Sherwain")) + " of time(s) in the list.");
//
//        for(int x = 0; x < length; x ++){
//            System.out.println(list.removeAtTail());
//        }

        //System.out.println(list2.deleteNode((E) new String("Sherwain")) + " item(s) found and deleted.");
       // System.out.println(list2.printList());
    }
}
