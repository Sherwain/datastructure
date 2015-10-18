package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 7/28/13
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringReverse {
    public static String val;
    public static void main(String args[]){
        val = "Sherwain";
        System.out.println(reverse(val));
    }

    private static String reverse(String val) {
        if (val.length() < 2)
            return val;

        System.out.println(val.substring(1) + val.charAt(0));

        return reverse(val.substring(1)) + val.charAt(0);
    }
}
