package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/23/13
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumNumbers {
    public static void main(String[] args){
        int numVal = 5;
        System.out.println(add(numVal));
    }

    public static int add(int val){
        if (val == 1){
            return val;
        }
        else{
            return val + add(val - 1);
        }
    }
}
