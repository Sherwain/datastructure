package datastructures;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/28/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkListS <E>{
    private Node<E> node;
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public LinkListS(){
        length = 0;
        head = tail = node = new Node();
    }

    public void addNode(E element){
        node = new Node<E>(element, head.getNext());
        if (length == 0){
            tail = node;
        }
        head.setNext(node);
        length ++;
    }

    public void addToTail(Node<E> next){
        Node<E> temp = new Node<E>();
        for (node = head.getNext(); node != null; node = node.getNext()){
            temp = node;
        }
        node = temp;
        System.out.println("Before node.getNext()=> " + node.getNext() + ". node = " + node + " Node val = " + node.getData());
        System.out.println("Before tail.getNext()=> " + tail.getNext() + ". tail = " + tail + " Tail val = " + tail.getData());

        tail.setNext(next);
        tail = next;
        //node.set
        length ++;
        //tail = null;

        System.out.println();

        System.out.println("After node.getNext()=> " + node.getNext() + ". node = " + node + " node.getNext().getData()=> " + node.getNext().getData());
        System.out.println("After tail.getNext()=> " + tail.getNext() + ". tail = " + tail + " tail.getNext().getData()=> " + tail.getNext().getData());
    }

    public String printList(){
        if (length == 0) return "List is empty!";
        String str = "[";
        for(node = head.getNext(); node != null; node = node.getNext()){
            str = str + " " + node.getData().toString();
        }
        return str + " ]";
    }

    public void removeDuplicate(){ // by me
        Node<E> runner = head;
        for (node = head.getNext(); node != null; node = node.getNext()){
            Node<E> outerNode = node;
            for (Node<E> InnerNode = head.getNext(); InnerNode != null; InnerNode = InnerNode.getNext()){
                if ( outerNode != InnerNode && outerNode.getData().equals(InnerNode.getData()) ){
                    //getPreviousNode(InnerNode).setNext(InnerNode.getNext());//get previous node inner node
                    runner.setNext(InnerNode.getNext());
                }
                //System.out.println(InnerNode.getData().toString());
                runner = runner.getNext();
            }
            runner = head;
        }
    }

    public Node<E> getPreviousNode(Node<E> curr){
        System.out.println("in: " +curr.toString());
        Node<E> temp = new Node<E>();
        for(temp = head.getNext(); temp != null; temp = temp.getNext()){
            if(temp.getNext() == curr) break;
        }
        return temp;
    }

    public void deleteDups() {             //using a hashmap collection
        Node<E> n = head.getNext();
        Hashtable table = new Hashtable();
        Node<E> previous = null;
        while (n != null) {
            if (table.containsKey(n.getData()))
                previous.setNext(n.getNext());
            else {
                table.put(n.getData(), true);
                previous = n;
            }
            n = n.getNext();
        }
        System.out.println(table);
    }

    public void nthTolast(int nth){
        if (nth < 0 || nth > length || length == 0){
            System.out.println("List is empty or value entered is out of range.");
            return;
        }

        int index = 1;
        for (node = head.getNext(); node != null; node = node.getNext()){
            if(index >= nth){
                System.out.println(node.getData());
            }
            index++;
        }
    }

    public void nthToLast2( int n) {//from book
         if (head == null || n < 1) {
             System.out.println("List is empty or value entered is out of range.");
         }
         Node<E> p1 = head;
         Node<E> p2 = head;
         for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
             if (p2 == null) {
                 return ; // not found since list size < n
             }
             p2 = p2.getNext();
         }
         while (p2.getNext() != null) {
             System.out.println(p2.getNext().getData());
             p2 = p2.getNext();
         }
    }

    public void deleteFromMiddle(E element){
        if(head == null) return;

        Node<E> runner = head;

        for (node = head.getNext(); node != null; node = node.getNext()){
            if (node.getData().equals(element)){
                //deleteNode(node);
                runner.setNext(node.getNext());
                node = null;
                length--;
                break;
            }
            runner = runner.getNext();
        }
    }

    public void deleteNode(Node<E> n) {   //from book
        if (n == null || n.getNext() == null) {
            return; // Failure
         }
        Node<E> next = n.getNext();
        n.setData(next.getData());
        n.setNext(next.getNext());
    }

    public void arithmetic(Node<E> node1, Node<E> node2){
        int carry = 0;
        int rem = 0;
        int ans = 0;
        node2 = node2.getNext();
        for(node1 = node1.getNext(); node1 !=null; node1 = node1.getNext()){
            ans = Integer.parseInt(node1.getData().toString()) + Integer.parseInt(node2.getData().toString()) + carry;
            carry = ans / 10;
            this.addNode((E) new Integer(ans % 10));
            node2 = node2.getNext();
        }
    }

    public Node<E> findBeginning(){
        Node<E> runner = head;
        Node<E> val;
        int x = 1;
        for (node = head.getNext(); x <= length ; node = node.getNext()){
            Node<E> temp = node;
            for (Node<E> inn = head.getNext(); inn != temp; inn = inn.getNext()){
                if (inn == temp){
                    node = temp;
                    break;
                }
            }
            runner = head;
            x++;
        }
        return node;
    }

    public Node<E> getNode() {
        return node;
    }

    public void setNode(Node<E> node) {
        this.node = node;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void createNode(E element){

    }
}
