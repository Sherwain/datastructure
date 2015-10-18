package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/23/13
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintArray {
    public static void main(String[] args){
        int[] arry = {12, 43, 59, 1, 32, 90};
        printArry(arry, arry.length);
    }

    public static void printArry(int[] ary, int size){
        if (size == 0){
            return;
        }
        System.out.println(ary[size - 1]);
        printArry(ary, size-1);
    }
}
