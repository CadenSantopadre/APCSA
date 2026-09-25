package simpleLoops;

public class SimpleLoopsRunner 
{
	public static void main(String[] args)
    //Mr Morton will say what I did is bad code... You can instead just do sl inside Sysprint and it will do toString automatically since we made our own
	{
		SimpleLoops sl = new SimpleLoops();
		int result = sl.getResult();
		System.out.println("The first result is " + result+ "\n");

		int num = 25;
		int denom = 5;

		sl.divide(num, denom);
		result = sl.getResult();
		System.out.println(num+ " divided by " + denom+" = "+result+ "\n");

		sl.remainder(num,denom);
		result = sl.getResult();
		System.out.println(num+ " divided by " + denom+" 's remainder is "+result+ "\n");

		int start = 23;
		int end = 37;

		sl.countMultiples(start, end);
		result = sl.getResult();
		System.out.println("Numbers divisible by 4 or 5 but not 4 and 5 between " + start + " and " + end + " are " + result+ "\n");

		int sumDigits = 501273;

		sl.sumDigits(sumDigits);
		result = sl.getResult();
		System.out.println("the sum of the digits in " + sumDigits + " is " + result+ "\n");

		String resultAsString;
		sl.randomSum();
		resultAsString = sl.toString(); //Heres the to string version
		System.out.println("All the odd digits in between some random numbers in between 100-10 inclusive added up is " + resultAsString);
	}
}
