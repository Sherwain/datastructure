package practicewithkavan;

import datastructures.StackImp2;

import javax.swing.*;
import java.util.*;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/11/13
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TableList<K, V> implements Iterable<V>{
    private TableNode<K, V> head;
    private TableNode<K, V> tail;
    private TableNode<K, V> cur;
    private int size;

    public TableList(){
        head = tail = null;
        size = 0;
    }

    public void add(K key, V value){
        if (head == null) cur = null;
        else
            cur = head.getPrev();
        head = new TableNode<K, V>(key, value, head, cur );
        if (getTail() == null){
            setTail(head);
        }
        size = size() + 1;
    }

    public void add(TableNode<K, V> node){
        if (head == null) cur = null;
        else
            cur = head.getPrev();

        node.setNext(head);
        head = node;
        if (getTail() == null){
            setTail(head);
        }
        size = size() + 1;
    }

    public void setHead(TableNode<K, V> head){
        this.head = head;
    }

    public TableNode<K, V> getHead(){
        return head;
    }

    public void size(int size){
        this.size = size;
    }

    public int size(){
        return size;
    }

    public TableNode<K, V> getTail() {
        return tail;
    }

    public void setTail(TableNode<K, V> tail) {
        this.tail = tail;
    }

    public TableNode<K, V> getCur() {
        return cur;
    }

    public void setCur(TableNode<K, V> cur) {
        this.cur = cur;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String listContents(){
        String str = "";
        int x = 0;
        TableNode<K, V> cur = head;
        while (cur != null){
            System.out.println(cur.getKey() + "="  + cur.getValue());
            if (x == 0) str =  str + cur.getKey() + "="  + cur.getValue().toString();
            else str =  str + " " + cur.getKey() + "="  + cur.getValue().toString();
            cur = cur.getNext();
            x ++;
        }
        return str;
    }

    public TableNode<K, V> remove(){
        if (isEmpty())
            return null;
        cur = head;
        head = head.getNext();
        size = size() -1;
        return cur;
    }

    public boolean find(K val){
        if (isEmpty()) return false;
        cur = head;
        while (cur != null){
            if (cur.getValue().equals(val))
                return true;
            cur = cur.getNext();
        }
        return false;
    }

    public boolean findKey(K val){
        if (isEmpty()) return false;
        cur = head;
        while (cur != null){
            if (cur.getKey().equals(val))
                return true;
            cur = cur.getNext();
        }
        return false;
    }

    public boolean findValue(V val){
        if (isEmpty()) return false;
        cur = head;
        while (cur != null){
            if (cur.getValue().equals(val))
                return true;
            cur = cur.getNext();
        }
        return false;
    }

    public TableNode<K, V> findNode(V val){
        cur = head;
        while (cur != null){
            if (cur.getValue().equals(val))
                return cur;
            cur = cur.getNext();
        }
        return cur;
    }

    public V findHash(K key){
        V result = null;
        if (isEmpty()) return null;
        cur = head;
        while (cur != null){
            if (cur.getKey().equals(key))
                result = cur.getValue();
            cur = cur.getNext();
        }
        return result;
    }

    public V removeNode(K key){
        TableNode<K, V> temp;
        if (isEmpty()) throw new EmptyStackException();

        if (head.getKey().equals(key)){
            temp = head;
            head = head.getNext();
            size = size() - 1;
            return temp.getValue();
        }
        cur = head;
        while (cur.getNext() != null){
            if (cur.getNext().getKey().equals(key)){
                temp = cur.getNext();
                cur.setNext(cur.getNext().getNext());
                if (temp.getNext() != null)
                    temp.getNext().setPrev(cur);
                else
                    tail = tail.getPrev();
                size = size() - 1;
                return head.getValue();
            }
            cur = cur.getNext();
        }
        return head.getValue();
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public Set<K> getSetKeys(Set<K> set){
        cur = head;
        while (cur != null){
            set.add(cur.getKey());
            cur = cur.getNext();
        }
        return set;
    }

    public Set<V> getSetValues(Set<V> set){
        cur = head;
        while (cur != null){
            set.add(cur.getValue());
            cur = cur.getNext();
        }
        return set;
    }

    public Iterator<V> iterator(){
        return new ListIterator();
    }

    public class ListIterator implements Iterator<V>{
        private TableNode<K, V> current = head;

        @Override
        public boolean hasNext() {
            return current.getNext() !=null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public V next() {
            if (!hasNext()) throw new NoSuchElementException();
            V value = current.getValue();
            current = current.getNext();  //To change body of implemented methods use File | Settings | File Templates.
            return value;
        }

        @Override
        public void remove() {
            if (isEmpty()) throw new EmptyStackException();
            current = current.getNext();
            size(size() - 1);
        }
    }
}