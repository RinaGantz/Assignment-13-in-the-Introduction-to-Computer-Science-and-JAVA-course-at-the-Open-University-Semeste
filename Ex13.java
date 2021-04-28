
/**
 *This class represents 3 recursive methods: binaryNum - checks if the number is a binary number, howManyLetters- cheks how many letters in the string,
 * checkDiv- checks if the given number is divisible by 11
 *
 * @author Rina Gantz
 * @version 12/05/2020
 */
public class Ex13

{
    /**
     * boolean static recursive method that obtains an integer n and returns true if it is a binary number, 
     * meaning that all digits in the number are 0 or 1 and false otherwise.
     * @param  n  an given integer to check whether it is a binary number
     * @return true if all digits in the number are 0 or 1 and false otherwise
     */

    public static boolean binaryNum(int n)
    {
        if(n<10) //stop condition - the end case, if only a single number is left
            return n==1||n==0;
        return (n%10==0||n%10==1)&&binaryNum(n/10); // check if the last digit is 0 or 1 and re-call the method without it(and return the result at the end)
    }

    /**
     *A recursive static method that accepts a string of s characters and returns the number of characters that are English letters 
     *(large and small) in the string.
     *
     * @param  s  the given string to check how many letters inside
     * @return  the amount of letters in the given string
     */
    public static int howManyLetters (String s)
    {
        if (s.length()==0) //stop condition - the end case, if the string is empty
            return 0;
        int isc=( s.charAt(s.length()-1)>='a'&&s.charAt(s.length()-1)<='z'||
                s.charAt(s.length()-1)>='A'&& s.charAt(s.length()-1)<='Z')? 1: 0; //checks whether the current character is a letter
        return isc+howManyLetters(s.substring(0,s.length()-1)); //return the amount of letters (by re-call the method again)
    }

    /**
     * A recursive method called checkDiv11 that receives an integer parameter and checks whether it is divisible by 11
     *
     * @param  n  the given integer parameter to check whether it is divisible by 11
     * @return  true if the given number divisible by 11 and false otherwise
     */
    public static boolean checkDiv11 (int n) 
    {
        boolean flag=true; 
        int sum=calcul(n, flag); //call the private calculation method
        if (sum>10||sum<-10) //there's other calculations, it's not a single digit number
            return checkDiv11(sum);
        return sum==0; //check if the calculation ended at zero and if so return true, otherwise false
    }
    //A private recursive calculation method that calaulate the adding and reducing the number of digits,in the format.
    private static int calcul(int n,boolean flag)
    {
        if (n==0)  //stop condition - the end case, if there is no number to add / reduce
            return 0;
        if (flag)
            return (n%10)+calcul(n/10, !flag);//return the ended calculate of adding the current digit and recall method
        else
            return (-n%10)+calcul(n/10, !flag);//return the ended calculate of reduce the current digit and recall method
    }
}
