package datastructures;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 3/4/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackCollection <E>{
    private Map<Integer, StackNodeImp3<E>> stackList;
    private int currentStack;

    public StackCollection(){
        setStackList(new LinkedHashMap<Integer, StackNodeImp3<E>>());
        setCurrentStack(0);
    }

    public Map<Integer, StackNodeImp3<E>> getStackList() {
        return stackList;
    }

    public void setStackList(HashMap<Integer, StackNodeImp3<E>> stackList) {
        this.stackList = stackList;
    }

    public Map getStackList(HashMap<Integer, StackNodeImp3<E>> stackList) {
        return this.stackList;
    }

    public void addNewStack(Integer index){
        stackList.put(index, new StackNodeImp3<E>());
    }

    public StackNodeImp3<E> getStack(Integer index){
        return stackList.get(index);
    }

    public String push(E item){
        if (stackList.isEmpty() || stackList.get(getCurrentStack()).isFull()){//add additional stack if empty
            setCurrentStack(getCurrentStack() + 1);
            stackList.put(getCurrentStack(), new StackNodeImp3<E>());
        }
        stackList.get(getCurrentStack()).push(item);
        return item + " added to stack " + getCurrentStack();
    }

    public E pop(){
        if (stackList.size() == 0) return (E) "Stack is empty!";

        E item = stackList.get(currentStack).pop();

        if (stackList.get(currentStack).getSize() == 0){
            stackList.remove(getCurrentStack());
            setCurrentStack(getCurrentStack() - 1);
        }

        return item;
    }

    public E popAt(int index){
        if (stackList.size() == 0) return (E) "Stack is empty!";
        if (index > stackList.size()) return (E) "Index out of range!";
        E item = stackList.get(index).pop();

        if (stackList.get(index).getSize() == 0){
            stackList.remove(item);
            setCurrentStack(getCurrentStack() - 1);
        }

        if(index < stackList.size()){ //delete from middle to beginning; hence move down nodes
            for (int y = index + 1; y <= stackList.size(); y++){//pop from the bottom of the next stack
                StackImp2<E> n = (StackImp2 <E>) stackList.get(y - 1).push(popAtBottom(stackList.get(y), y));
                stackList.get(y - 1).setTop(n);
            }
        }
        return item;
    }

    public E popAtBottom(StackNodeImp3<E> s, int temp){
        int x = 1;
        E item = null;
        for (Iterator it = s.iterator(); it.hasNext();){
            if (x == s.getSize()){
                item = (E) it.next();
                //s.deleteNode(item);
                s.setTop(s.deleteNode2(s.getTop(), item));
                break;
            }
            it.next();
            x++;
        }
        if (s.getSize() == 0){
            stackList.remove(temp);
            setCurrentStack(getCurrentStack() - 1);
        }
        return item;
    }

    public void print(){
        StackNodeImp3<E> temp;
        for (Map.Entry<Integer, StackNodeImp3<E>> entrySet : stackList.entrySet()){
            System.out.print("-----------------Stack# "+entrySet.getKey()+"----------------------------");
            temp = entrySet.getValue();
            System.out.println(temp.toString());
        }
    }

    public int getCurrentStack() {
        return currentStack;
    }

    public void setCurrentStack(int currentStack) {
        this.currentStack = currentStack;
    }
}