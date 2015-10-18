package datastructuresp;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/25/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkList <E>{
    private Node<E> node;
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public LinkList(){
        length = 0;
        node = head = tail = new Node();
    }

    public Node<E> getNode() {
        return node;
    }

    public void insertAtTail(E element){
        node = new Node<E>(element, tail.getNext()); //points node to null {points to what tail.next is pointing to}
        node.setPrev(tail); //points the node to the previously last node of the list{formerly tail}
        tail.setNext(node); //Set previously last element to point to the new node now at the end
        tail = node; // Set the tail to be last element in the list
        if (length == 0){
            head.setNext(node);
            //node.setPrev(head);//
        }
        length ++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addNode(E element){
        node = head.getNext(); //get reference to the head of the list
        head.setNext(new Node<E>(element, head.getNext())); //set new node to be head of the list and previously first node to be second in the list
        if (length == 0)
            tail = head.getNext();//set the first node to be the tail
        else
            node.setPrev(head.getNext());// set prev of the second node to point to the first node in the list
        length++; //increment the amount of nodes in the list
    }

    public void addTraditionally(E element){
        node = new Node<E>(element, head.getNext()); //create new node to point to be the first node in the list
        if (length == 0){
            tail = node; //set the first node to be the tail
        }
        else
            head.getNext().setPrev(node);//set the second node to point its prev to new node
        head.setNext(node); //make new node to be the first node in the list
        length ++; //increment the amount of nodes in the list
    }

    public Node<E> getHead() {
        return head;
    }

    public E removeAtTail(){
        if (length == 0){
            return (E) new String("The list is empty.");
        }
        E element = tail.getElement();
        tail = tail.getPrev();
        length--;
        return element;
    }

    public E removeAtHead(){
        if (length == 0) return (E) new String("The list is empty.");
        node = head.getNext(); //make a reference to the first node
        E element = node.getElement(); //gets the value for the first element in the list
        head.setNext(node.getNext()); //set the head node to point the node that the first node was pointing to
        if (length == 1){   //removing the last element from within the list
            tail = head; tail.setPrev(null);
        }
        else{
            head.getNext().setPrev(null); //points the first node to null
        }
        length--;
        return element;
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

    public String printList(){
        if (length == 0) return "List is empty!";

        String str = "";
        for (node = head.getNext(); node != null; node = node.getNext()){
            str = str + " " + node.getElement().toString();
        }
        return str;
    }

    public int searchTopDown(E element){
        int occ = 0;
        for (node = head.getNext(); node != null; node = node.getNext()){
            if (node.getElement().equals(element)){
                occ ++;
            }
        }
        return occ;
    }

    public int searchBottomUp(E element){
        int occ = 0;
        for (node = tail; node != null; node = node.getPrev()){
            if (node.getElement().equals(element)){
                occ ++;
            }
        }
        return occ;
    }

    public int deleteNode(E element){
        Node<E> del = new Node<E>();
        E tempElement;
        int occ = 0;
        if (head.getNext() == null) return occ;

        for (node = head.getNext(); node != null; node = node.getNext() ){
            tempElement = node.getElement();
            if (tempElement.equals(element)){
                del = node;   //creates a reference to the node that should be deleted
                if (del == tail){ // this is the last node in the list
                    tail.setNext(null); //set the tail next pointer to point to null
                    tail = node.getPrev();
                }
                else{ //not the end of the list
                    if (node.getPrev() == null){//deleting from head of the list
                        head.setNext(del.getNext());
                        node.getNext().setPrev(null);
                    }
                    else{ //one of the middle node is being deleted
                        node.getNext().setPrev(del.getPrev());
                        node.getPrev().setNext(del.getNext());
                    }
                }
                del = null;
                occ++;
                length--;
            }
        }
        return occ;
    }

    public int deleteFromTail(E element){
        if (tail == null)return 0;
        E tempElement;
        Node<E> del = new Node<E>();
        int occ = 0;

        for (node = tail; node != null; node = node.getPrev()){
            tempElement = node.getElement();
            if (tempElement.equals(element)){
                del = node;
                if (tail == node){ // this is the last in the list(tail)
                    tail.setNext(null); //set the tail next pointer to point to null
                    tail = node.getPrev(); //move tail to previous node in the list
                }
                else{
                    node.getNext().setPrev(node.getPrev());
                    if (node.getPrev()==null){   //check if the node is at the beginning of the list
                        head.setNext(node.getNext()); //
                        node.getNext().setPrev(null); //sets the previous node to point to null
                    }
                    else{
                        node.getPrev().setNext(node.getNext());
                    }
                }
                del = null;
                occ++;
                length--;
            }
        }
        return occ;
    }
}
