package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/4/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackOfBoundException extends Exception{
    public StackOfBoundException(){
        super("Stack is full. Cannot add any more element.");
    }

    public StackOfBoundException(String msg){
        super(msg);
    }
}