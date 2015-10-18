package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/23/13
 * Time: 9:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class COuntZeros{
    public static void main(String[] args){
        int[] numVal = {5, 43, 213, 3, 6, 12, 8};
        System.out.println(count(numVal, numVal.length - 1));
    }

    public static int count(int[] val, int size){
        if (size < 0){
            return 0;
        }
        if (val[size] == 0){
            return 1 + count(val, size - 1);
        }
        else{
            return 0 + count(val, size - 1);
        }
    }
}
