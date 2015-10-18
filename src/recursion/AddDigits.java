package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/22/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddDigits {
    public static void main(String[] args){
        int val = 243;
        System.out.println(sumOfDigitst(val));
        //sumOfDigitst(val);
    }

    private static int sumOfDigitst(int val) {
        if (val < 10){
            return val;
        }
        return sumOfDigitst(val/10) + (val%10);
    }
}
