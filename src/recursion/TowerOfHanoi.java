package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 2/23/13
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class TowerOfHanoi {
    public static void main(String[] args){
        int num = 4;
        move (num, true);
    }

    public static void move(int num, boolean b){
        if(num == 0)return;
        move(num - 1, !b);
        if (b) System.out.println(num + " left");
        else System.out.println(num + " right");
        move(num - 1, !b);
    }
}