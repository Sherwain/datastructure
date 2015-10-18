package practicewithkavan;


/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/11/13
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TableNode <K, V> {
    private K key;
    private V value;
    private TableNode<K, V> next;
    private TableNode<K, V> prev;

    public TableNode(V value, TableNode<K, V> node, TableNode<K, V> prev){
        this.value = value;
        this.next = node;
        this.setPrev(prev);
    }


    public TableNode(K key, V value, TableNode<K, V> node, TableNode<K, V> prev){
        this.key =key;
        this.next = node;
        this.value = value;
        this.setPrev(prev);
    }

    public TableNode(){

    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public TableNode<K, V> getNext() {
        return next;
    }

    public void setNext(TableNode<K, V> next) {
        this.next = next;
    }

    public TableNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(TableNode<K, V> prev) {
        this.prev = prev;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public int hashCode(){
        return key.hashCode();
    }

    @Override
    public String toString(){
        return "["+ key.toString() + ": " + value.toString();
    }
}