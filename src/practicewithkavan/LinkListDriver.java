package practicewithkavan;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/11/13
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkListDriver <E>{
    static LinkList list = new LinkList();

    public static<E> void main(String[] args){
        try {
            readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //find();
        List l = new ArrayList<String>();

        for (int x = 0; x < l.size(); x++){
            System.out.println(l.get(x));
        }
        System.out.println(l.indexOf("devan"));
    }

    public static void readFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("dictionary.txt"));
        while (in.hasNext()) {
            list.add(in.next ());
        }
    }

    public static<E> void find(){
        //String key = JOptionPane.showInputDialog(null, "Search for a work");
        //JOptionPane.showMessageDialog(null, "Found: " + list.find((E) JOptionPane.showInputDialog(null, "Search for a work")));
    }
}

