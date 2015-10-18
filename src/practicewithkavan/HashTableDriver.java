package practicewithkavan;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/12/13
 * Time: 7:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class HashTableDriver {
    public static void main(String[] args){
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>();
        hashTable.put("sherwain",  23);
        hashTable.put("cleave", 80);
        hashTable.put("monique", 8);
        hashTable.put("Green", 93);
        hashTable.put("Janice", 17);
        hashTable.put("Devon", 43);
        hashTable.put("Alphanso", 55);
        hashTable.put("Rhaime", 165);
        hashTable.put("Andre", 54);
        hashTable.put("ELmore", 32);
        hashTable.put("Glen", 578);
        hashTable.put("Jermaine", 243);
        //System.out.println(hashTable);
        //hashTable.remove("Devon");
        //System.out.println(hashTable.containsKey("sherwain"));
        //System.out.println(hashTable.entrySet());
        //System.out.println(hashTable.keySet());
        //System.out.println(hashTable.valueSet());

        //using keyset
//        Set<String> keySet = hashTable.keySet();
//        Iterator<String> keySetIterator = keySet.iterator();
//        while (keySetIterator.hasNext()) {
//            System.out.println("------------------------------------------------");
//            System.out.println("Iterating Map in Java using KeySet Iterator");
//            String key = keySetIterator.next();
//            System.out.println("key: " + key + " value: " + hashTable.get(key));
//        }


        //using entryset
//        Set<Map.Entry<String, Integer>> entrySet = hashTable.entrySet();
//        for (Map.Entry entry : entrySet) {
//            System.out.println("------------------------------------------------");
//            System.out.println("looping HashMap in Java using EntrySet and java7 for loop");
//            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
//        }

        //Iterating HashMap in Java using EntrySet and Java iterator
//        Set<Map.Entry<String, Integer>> entrySet1 = hashTable.entrySet();
//        Iterator<Entry<String, Integer>> entrySetIterator = entrySet1.iterator();
//        while (entrySetIterator.hasNext()) {
//            System.out.println("------------------------------------------------");
//            System.out.println("Iterating HashMap in Java using EntrySet and Java iterator");
//            Entry entry = entrySetIterator.next();
//            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
//        }

//        for (String key :  hashTable.keySet()) {
//            System.out.println("------------------------------------------------");
//            System.out.println("Iterating or looping map using java7 foreach loop");
//            System.out.println("key: " + key + " value: " + hashTable.get(key));
//        }


//        for (Iterator<Map.Entry<String, Integer>> entrySetIterator = hashTable.entrySet().iterator(); entrySetIterator.hasNext();){// entrySet1.iterator();{
//            System.out.println("------------------------------------------------");
//            System.out.println("Iterating HashMap in Java using EntrySet and Java iterator");
//            Map.Entry entry = entrySetIterator.next();
//            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
//        }

//        for (Map.Entry<String, Integer> e : hashTable.entrySet())
//                System.out.println(e.getKey() + ": " + e.getValue());

//        for (Iterator<String> it = hashTable.keySet().iterator(); it.hasNext(); )
//            System.out.println(it.next());

        Iterator<Map.Entry<String, Integer>> entrySetIterator = hashTable.entrySet().iterator();
        while (entrySetIterator.hasNext()) {
            System.out.println("------------------------------------------------");
            System.out.println("Iterating HashMap in Java using EntrySet and Java iterator");
            Map.Entry entry = entrySetIterator.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

    }
}
