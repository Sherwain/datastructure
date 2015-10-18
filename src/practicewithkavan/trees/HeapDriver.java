package practicewithkavan.trees;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/22/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapDriver {
    public static void main(String[] args){
        Heap<Integer> heap = new Heap<Integer>();
        heap.add(12);
        heap.add(57);
        heap.add(19);
        heap.add(87);
        heap.add(15);
        heap.add(44);
        heap.add(23);
        System.out.println("Level Order: " + heap.levelOrderTraversal());
        System.out.println("Height of tree: " + heap.getHeight());
        System.out.println("Depth of tree: " + heap.getDepth());
    }
}