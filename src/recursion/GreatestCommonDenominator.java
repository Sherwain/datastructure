package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/23/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreatestCommonDenominator {
    public static void main(String[] args){
        int num1 = 102;
        int num2 = 68;
        System.out.println(gcd(num1, num2, (num1 < num2)? (num1) : (num2) ));
    }

    public static int gcd(int num1, int num2, int gcd){
        if ((num1%gcd == 0 && num2%gcd == 0) || gcd == 1){
            return gcd;
        }
        return gcd(num1, num2, gcd - 1) ;
    }
}

