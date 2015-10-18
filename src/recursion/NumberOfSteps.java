package recursion;


public class NumberOfSteps {
	public static void main(String[] args){
		System.out.print(numberOfSteps(8));
	}
	
	public static int numberOfSteps(int n){
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else
			return numberOfSteps(n - 1) + numberOfSteps(n - 2) + numberOfSteps(n - 3);
	}
}
