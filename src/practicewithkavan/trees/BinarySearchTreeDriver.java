package practicewithkavan.trees;

import practicewithkavan.LinkList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/17/13
 * Time: 3:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTreeDriver {
    public static void main(String[] args){
        BinarySearchTree<Integer> T = new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> C = new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> P = new BinarySearchTree<Integer>();
        int ary[] = {37, 24, 42, 7, 2, 40, 42, 32, 120};
        int ary3[] = {1, 2, 3, 4, 5, 12, 87, 9, 120, 90, 63};//, 44};//, 18, 7};
        Random rnd = new Random();

//        for (int x = 0; x < 500; x++)
//            T.add(rnd.nextInt(500) + 1);
//        }
        //37, 24, 42, 7, 2, 40, 42, 32, 120
        for (int x = 0; x < ary3.length; x ++){
            T.add(ary3[x]);
            System.out.println("InOrder(LVR) " + ary3[x] + ": " + T.inOrderTraversal());
        }
        //System.out.println("PreOrder(VLR): " + T.preOrderTraversal());
        System.out.println("InOrder(LVR): " + T.inOrderTraversal());
        //System.out.println("PostOrder(LRV): " + T.postOrderTraversal());
        System.out.println("Leaves T : " + T.countLeaves());
        System.out.println("Min Value: " + T.minValue());
        System.out.println("Max Value: " + T.maxValue());
        System.out.println("Max width: " + T.width());
        System.out.println("Level Count for 3: " + T.levelCount(3));
        System.out.println("Max height M: " + T.height());
        System.out.println("Min height M: " + T.minHeight());
        System.out.println("Is Balanced: " +  T.isBalanced());
        System.out.println();
//        for (int x = 0; x < ary.length; x ++)
//            C.add(ary[x]);
//
//        System.out.println("PreOrder(VLR): " + C.preOrderTraversal());
//        System.out.println("InOrder(LVR): " + C.inOrderTraversal());
//        System.out.println("PostOrder(LRV): " + C.postOrderTraversal());
//        C.remove(120);
//        System.out.println("PreOrder(VLR): " + C.preOrderTraversal());
////        System.out.println("Min Value: " + C.minValue());
////        System.out.println("Max Value: " + C.maxValue());
//        System.out.println();
        int ary2[] = {120, 42, 42, 7, 2, 32, 37, 24, 40};
//        for(int x = 0; x < ary2.length; x++)
//            P.add2(ary2[x]);
//
//        System.out.println("LevelOrder: " + P.levelOrderTraversal());
//        System.out.println("Max Height: " + P.height());
//        System.out.println("Min Height: " + P.minHeight());
//        System.out.println("Leaves P : " + P.countLeaves());
//        System.out.println("Elements at level " + 4 + ": " + P.elementsAtLevel(4));
//        System.out.println("Max height: " + P.maxDepth());
//        System.out.println("Min height: " + P.minDepth());
//        System.out.println("Is Balanced: " +  P.isBalanced());
        System.out.println();
        LinkList<Integer> list = new LinkList<Integer>();
        for(int x = 0; x < ary2.length; x++)
            list.add(ary2[x]);
        System.out.println(list);
        list.sort();
        System.out.println(list);
        System.out.println(list.nthFromTail(1));
    }
}
