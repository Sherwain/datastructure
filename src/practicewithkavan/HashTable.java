package practicewithkavan;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/12/13
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashTable <K, V>{
    private final double LOADFACTOR = .75;
    private int initalCapacity;
    private TableList<K, V>[] values;
    private int size;
    private Set<K> keySet = null;
    private Set<Map.Entry<K,V>> entrySet = null;

    HashTable(){
        initalCapacity = 10;
        setValues(new TableList[initalCapacity]);
        setSize(0);
        for (int x = 0; x < getValues().length; x++){
            getValues()[x] = new TableList<K, V>();
        }
    }

    public V put(K key, V value){
        checkSize();
        if (value == null ) throw new IllegalArgumentException("Value cannot be null.");
        if (key == null ) throw new IllegalArgumentException("Key cannot be null.");
        if (!values[getHashValue(key, values.length)].findKey(key)){
            getValues()[getHashValue((key), values.length)].add(key, value);
            setSize(getSize() + 1);
        }
        return value;
    }


    public V get(K key){
        if (key == null ) throw new IllegalArgumentException("Key cannot be null.");
        int keyVal;
        return getValues()[getHashValue(key, getValues().length)].findHash(key);
    }

    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }


    synchronized private void checkSize(){
        if (size >= getValues().length * LOADFACTOR + 1){
            rehash();
        }
    }

    public Set<K> keySet(){
        Set<K> set = new TreeSet<K>();
        List<K> list = new ArrayList<K>();
        for (int x = 0 ; x < values.length; x++){
            if (!values[x].isEmpty())
                set =  getValues()[x].getSetKeys(set);
        }
        return set;
    }

    public Set valueSet(){
        Set<V> set = new HashSet<V>();
        for (int x = 0 ; x < values.length; x++){
            if (!values[x].isEmpty())
                set =  getValues()[x].getSetValues(set);
        }
        return set;
    }

    public boolean containsKey(K key){
        if (key == null ) throw new IllegalArgumentException("Key cannot be null.");
            if (!values[getHashValue(key, values.length)].isEmpty())
                if( getValues()[getHashValue(key, values.length)].findKey(key)) return true;
        return false;
    }

    public boolean containsValue(V value){
        if (value == null ) throw new IllegalArgumentException("Key cannot be null.");
        for (int x = 0 ; x < values.length; x++){
            if (!values[x].isEmpty())
                if( getValues()[x].findValue(value)) return true;
        }
        return false;
    }

    public V remove(K key){
        if (key == null ) throw new IllegalArgumentException("Key cannot be null.");
        V v = getValues()[getHashValue(key, getValues().length)].removeNode(key);
        return v;
    }

    public void clear(){
        for (int x = 0 ; x < values.length; x++){
            if (!values[x].isEmpty())
                getValues()[x].clear();
        }
    }

    public synchronized void putAll(Map<? extends K, ? extends V> t) {
        for (Map.Entry<? extends K, ? extends V> e : t.entrySet())
            put(e.getKey(), e.getValue());
    }

    public class EntryMap<K, V> implements Map.Entry, Comparable {
        private K key;
        private V value;

        EntryMap(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() { return key; }

        public V getValue() { return value; }

        public Object setValue(Object nv) {
            throw new UnsupportedOperationException("Not supported");
        }

        public int compareTo(Object o2) {
            if (!(o2 instanceof EntryMap))
                throw new IllegalArgumentException("Not a EntryMap");
            K otherKey = ((EntryMap<K, V>)o2).getKey();
            return ((Comparable)key).compareTo((Comparable)otherKey);
        }

        public String toString(){
            return key +" " + value;
        }
    }

    private class MapSet<E extends Comparable> extends AbstractSet {
        LinkList<E> list;
        MapSet(LinkList<E> al) {
            list = al;
        }
        public Iterator iterator() {
            return list.iterator();
        }
        public int size() {
            return list.getSize();
        }
    }

    public Set<Map.Entry<K,V>> entrySet() {
        Set<EntryMap<K,V>> set = new HashSet<EntryMap<K, V>>();
        int x;
        TableNode<K, V> cur;
        LinkList<EntryMap<K, V>> list = new LinkList<EntryMap<K, V>>();
        for (x = 0 ; x < values.length; x++){
            if (!values[x].isEmpty()){
                cur = values[x].getHead();
                while (cur != null){
                    list.add(new EntryMap<K, V>(cur.getKey(), cur.getValue()));
                    cur = cur.getNext();
                }
            }
        }
        return new MapSet(list);
    }

    @Override
    public String toString(){
        String str = "{";
        int x, k;
        for (x = 0, k = 0; x < values.length ; x ++){
            if (!values[x].isEmpty()){
                if (k > 0) str = str + " ";
                str = str + getValues()[x].listContents();
                k ++;
            }
            x++;
        }
        return str + "}";
    }

    private TableList<K, V>[] getValues() {
        return values;
    }

    public void setValues(TableList<K, V>[] values) {
        this.values = values;
    }

    private int getHashValue(K k, int size){
        return Math.abs(k.hashCode() % size);
    }

    private void rehash() {
        int newSize = values.length * 2 + 1;
        TableList<K, V>[] valuesTemp = new TableList[newSize];
        valuesTemp = initializeList(valuesTemp);
        valuesTemp = copyBucketNodes(valuesTemp);
        values = valuesTemp;
        valuesTemp = null;
    }

    private TableList<K, V>[] copyBucketNodes(TableList<K, V>[] valuesTemp){
        TableNode<K, V> cur = new TableNode();
        int x = 0;

        for (x = 0 ; x < values.length; x++){
            if (!values[x].isEmpty()){
                cur = values[x].getHead();
                while (cur != null){
                    valuesTemp[getHashValue(cur.getKey(), valuesTemp.length)].add(cur.getKey(), cur.getValue());
                    cur = cur.getNext();
                }
            }
        }
        return valuesTemp;
    }

    private TableList<K, V>[] initializeList(TableList<K, V>[] valuesTemp) {
        for (int x = 0; x < valuesTemp.length; x++){
            valuesTemp[x] = new TableList<K, V>();
        }
        return valuesTemp;
    }
}
