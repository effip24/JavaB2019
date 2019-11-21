
/**
 * class Ex13 - mmn13.
 * @author (Ephraim Phil)
 * @version (10/5/2019)
 */
public class Ex13
{
    /**
     * recursive method returs the biggest digit (integer) of a number.
     * @param n the number to be checked.
     * @return the biggest digit (integer) in a number.
     */
    public static int maxDigit(int n){
        int numOne = 0;
        int numTwo = 0;
        //the end of the recursion.
        if ( n == 0)
        {
            return 0;
        }
        else
        {
            //saves the last digit of n.
            numOne = n%10;
            //calling recursion saves n without the last digit in every call.
            numTwo= maxDigit(n/10);
        }
        //checks which one is bigger
        if(numOne > numTwo)
        {
            return numOne;
        }
        else
            return numTwo;
    }

    /**
     * recursive method, gets two integers (x and y ) and returns the minimal proper operations to get from x to y.
     * <p>proper operations: </p>
     * <p>adding 1 (+1)</p>
     * <p>multiply by 2 (*2)</p>
     * @param x the first integer, the method starts from x until it gets to y and counts how many prpoer operations it had to do.
     * @param y the second integer, the method starts from x until it gets to y and counts how many prpoer operations it had to do.
     * @return the minimal proper operations to get from x to y.
     */
    public static int minOps (int x, int y)
    {
        //checks if x is smaller then y, if not 0 is returned.
        if (x < y)
        {
            //istead of checking from x to y (from bottom to top),
            //the method checks from y to x (top to bottom), 
            //if y is even it divedes y by 2 (/2).
            //if y is odd it substracts 1 (-1) .

            if (y %2 == 0 && (y/2) >= x)
            {
                //returns 1 every time the method had a proper operation and starts recursion.
                return 1 + minOps( x, (y/2));
            }
            else
            {
                return 1 + minOps( x, (y-1));
            }
        }
        return 0;
    }

    /**
     * recursive method converts an integer to roman number.
     * <p> the number 1000 repretens by the charachter 'M' in roman. </p>
     * <p> the number 500 repretens by the charachter 'D' in roman. </p>
     * <p> the number 100 repretens by the charachter 'C' in roman.</p>
     * <p> the number 50 repretens by the charachter 'L' in roman.</p>
     * <p> the number 10 repretens by the charachter 'X' in roman.</p>
     * <p> the number 5 repretens by the charachter 'V' in roman.</p>
     * <p> the number 1 repretens by the charachter 'I' in roman.</p>
     * <p> for instance 6789 represents by "MMMMMMDCCLXXXVIIII" in roman. </p>
     * @param n the number to be converted to roman.
     * @return converted numer from integer to roman.
     */
    public static String convert (int n) 
    {
        //end of recursion
        if (n == 0)
        {
            {
                return "";
            }
        }
        else
        {
            //if n is greater then 1000 the method substracts 1000 from n and starts recursion with n-1000.
            if (n > 1000)
            {               
                return "M" + convert(n - 1000);
            }
            //if n is less then 1000 and greater or equals then 500 the method substracts 500 from n and starts recursion with n-500.
            else if (n < 1000 && n >= 500)
            {
                return "D" + convert(n - 500);
            }
            //if n is less then 500 and greater or equals to 100 the method substracts 100 from n and starts recursion with n-100.
            else if ( n < 500 && n >= 100)
            {
                return "C" + convert(n - 100);
            }
            //if n is less then 100 and greater or equals to 50 the method substracts 50 from n and starts recursion with n-50.
            else if ( n < 100 && n >= 50)
            {
                return "L" + convert( n - 50);
            }
            //if n is less then 50 and greater or equals to 10 the method substracts 10 from n and starts recursion with n-10.
            else if ( n < 50 && n >= 10)
            {
                return "X" + convert( n - 10);
            }
            //if n is less then 10 and greater or equals to 5 the method substracts 5 from n and starts recursion with n-5.
            else if ( n < 10 && n >= 5)
            {
                return "V" + convert( n - 5);
            }
            //if n is less then 5 and greater or equals to 1 the method substracts 1 from n and starts recursion with n-1.
            else if (n < 5 && n >= 1)
            {
                return "I" + convert( n - 1);
            }
        }
        return "";
    }
}
