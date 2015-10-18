package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/22/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Factorial {
    public static void main(String[] args){
        int num = 5;
        System.out.println("The factorial of " + num  + " is: " + factorial(num));
    }

    public  static int factorial(int num){
        if (num == 1){
            return 1;
        }
        return num * factorial(num - 1);
    }
}
