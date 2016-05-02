package myPackage;

public class Recursividad {

	public static void main(String args[]) {
		int fac = 20;
        for (int counter = 0; counter <= fac + 1; counter++){
            if (counter == fac){
            		System.out.printf("%d! = %d\n", counter,
            factorial(counter));
            }
        }
    }
    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}