package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/3/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackImp2 <E> implements Comparable<E>{
    private E element;
    private StackImp2<E> next;

    public StackImp2(){
        element = null;
        next = null;
    }

    public StackImp2(E element, StackImp2<E> node){
        this.element = element;
        this.next = node;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public StackImp2<E> getNext() {
        return next;
    }

    public void setNext(StackImp2<E> next) {
        this.next = next;
    }

    @Override
    public int compareTo(E o) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
