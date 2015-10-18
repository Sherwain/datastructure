package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/23/13
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayMin {
    public static void main(String[] args){
        int[] numVal = {5, 43, 213, 3, 6, 12, 8};
        System.out.println(findMin(numVal, numVal.length - 1, numVal[0]));
    }

    public static int findMin(int[] ary, int index, int min){
        if(index < 0){
            return min;
        }
        if(ary[index] < min){
            min = ary[index];
        }
        return findMin(ary, index - 1, min);
    }
}
